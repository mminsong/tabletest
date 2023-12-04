package com.example.tabletest.mappers;

import com.example.tabletest.entities.BusinessEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMainMapper {
    BusinessEntity[] selectBusiness();
    int insertBusiness(BusinessEntity businessEntity);
}
