package com.example.tabletest.controllers;

import com.example.tabletest.Services.MainService;
import com.example.tabletest.entities.BusinessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "main")
public class MainController {
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping(value = "index")
    public ModelAndView getIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("/main/index");
        BusinessEntity[] businessEntities = this.mainService.businesscard();
        modelAndView.addObject("businessEntities", businessEntities);
        return modelAndView;

    }
    @GetMapping(value="/add")
    public ModelAndView getAdd(ModelAndView modelAndView){
        modelAndView.setViewName("/main/add");
        return modelAndView;
    }
    @PostMapping(value = "/add")
    public ModelAndView PostAdd(ModelAndView modelAndView,
                               BusinessEntity businessEntity) {
        this.mainService.insertBusiness(businessEntity);
        modelAndView.setViewName("redirect:/main/index");
        return modelAndView;
    }
    @GetMapping(value="/mypage")
    public ModelAndView getMypage(ModelAndView modelAndView){
        BusinessEntity[] businessEntities = this.mainService.businesscard();
        modelAndView.setViewName("/main/mypage");
        return modelAndView;
    }


}
