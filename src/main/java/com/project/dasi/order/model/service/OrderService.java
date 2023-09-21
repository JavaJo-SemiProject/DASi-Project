package com.project.dasi.order.model.service;

import com.project.dasi.order.model.dto.OrderListDTO;

import java.util.List;

public interface OrderService {

    public List<OrderListDTO> selectMyOrderList();

    public OrderListDTO selectMyOrderDetail(String userId);

    public void registOrder(OrderListDTO orderList);

}
