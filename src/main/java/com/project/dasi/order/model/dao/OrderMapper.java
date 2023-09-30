package com.project.dasi.order.model.dao;

import com.project.dasi.order.model.dto.OrderFileDTO;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    int insertOrderContent(OrderListDTO order);

    /*int insertOrderFile(OrderFileDTO orderFileDTO);*/
}
