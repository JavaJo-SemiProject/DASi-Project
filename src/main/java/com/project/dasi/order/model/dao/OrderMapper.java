package com.project.dasi.order.model.dao;

import com.project.dasi.order.model.dto.OrderListDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int insertOrderContent(OrderListDTO order);

    /*int insertOrderFile(OrderFileDTO orderFileDTO);*/
}
