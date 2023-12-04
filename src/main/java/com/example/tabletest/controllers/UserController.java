package com.example.tabletest.controllers;

import com.example.tabletest.Services.UserService;
import com.example.tabletest.entities.BusinessEntity;
import com.example.tabletest.entities.UserEntity;
import com.example.tabletest.vos.LoginVo;
import com.example.tabletest.vos.RegisterVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/register")
    public ModelAndView getRegister(ModelAndView modelAndView){
        modelAndView.setViewName("/user/register"); //html인식 시키기
        return modelAndView;
    }
    @PostMapping(value="/register")
    public ModelAndView postRegister(ModelAndView modelAndView,
                                     RegisterVo registerVo){
        this.userService.Login(registerVo);
        modelAndView.addObject("registerVo",registerVo);
        modelAndView.setViewName("/user/register");
        return modelAndView;
    }
    @GetMapping(value="/login")
    public ModelAndView getLogin(ModelAndView modelAndView){
        modelAndView.setViewName("/user/login");
        return modelAndView;
    }
    @PostMapping(value = "/login")
    public ModelAndView postLogin(ModelAndView modelAndView,
                                  LoginVo loginVo,
                                  HttpServletRequest request,
                                  HttpSession session){
        LoginVo loginVo1=this.userService.loginUser(loginVo);
        if(loginVo1.getResult().equals("성공")){
            session=request.getSession();
            session.setAttribute("loginVo1",loginVo1);
            modelAndView.setViewName("redirect:/main/index"); //redirect : 새로운 url 재요청
            System.out.println("성공");
        }
        else{
            modelAndView.setViewName("/user/login");
            System.out.println("실패");
        }
        return modelAndView;
    }
    @GetMapping(value = "/join")
    public ModelAndView getJoin(ModelAndView modelAndView){
        modelAndView.setViewName("/user/join");
        return modelAndView;
    }
    @PostMapping(value="join")
    public ModelAndView postJoin(ModelAndView modelAndView,
                                 UserEntity userEntity){
        this.userService.insertUser(userEntity);
        modelAndView.setViewName("redirect:/user/login");
        return modelAndView;
    }


}
