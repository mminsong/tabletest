package com.example.tabletest.Services;

import com.example.tabletest.entities.BusinessEntity;
import com.example.tabletest.mappers.IMainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final IMainMapper mainMapper;
    @Autowired
    public MainService(IMainMapper mainMapper) {
        this.mainMapper = mainMapper;
    }

    public BusinessEntity[] businesscard(){
        return this.mainMapper.selectBusiness();
    }

    public void insertBusiness(BusinessEntity businessEntity){this.mainMapper.insertBusiness(businessEntity);}
}
