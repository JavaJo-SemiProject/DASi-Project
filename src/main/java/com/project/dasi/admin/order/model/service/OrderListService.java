package com.project.dasi.admin.order.model.service;

import com.project.dasi.admin.order.model.dao.OrderListMapper;
import com.project.dasi.admin.order.model.dto.OrderListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListService {

    private final OrderListMapper orderListMapper;

    public OrderListService(OrderListMapper orderListMapper) {
        this.orderListMapper = orderListMapper;
    }


    public List<OrderListDTO> selectAllOrderList() {

        List<OrderListDTO> orderList = orderListMapper.selectAllOrderList();

        return orderList;
    }
}
