package com.project.dasi.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.project.dasi", annotationClass = Mapper.class)
public class MyBatisConfiguration {}