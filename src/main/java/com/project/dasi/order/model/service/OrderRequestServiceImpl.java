package com.project.dasi.order.model.service;


import com.project.dasi.order.model.dao.OrderMapper;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderRequestServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    public OrderRequestServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    @Transactional
    public void registOrder(OrderListDTO order) {

        System.out.println("order ser: " + order);

        orderMapper.insertOrderContent(order);

    }


}
