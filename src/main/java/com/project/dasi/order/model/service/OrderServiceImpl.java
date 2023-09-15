package com.project.dasi.member.order.service;

import com.project.dasi.member.order.dao.OrderMapper;
import com.project.dasi.member.order.dto.OrderListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl{

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<OrderListDTO> findMyAllOrder(){

        List<OrderListDTO> myOrderList = orderMapper.findMyAllOrder();

        return myOrderList;
    }




}
