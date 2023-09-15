package com.project.dasi.member.order.dao;

import com.project.dasi.member.order.dto.OrderListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderListDTO> findMyAllOrder();
}
