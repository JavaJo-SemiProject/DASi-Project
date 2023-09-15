package com.project.dasi.admin.order.model.dao;

import com.project.dasi.admin.order.model.dto.OrderListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderListMapper {
    List<OrderListDTO> selectAllOrderList();
}
