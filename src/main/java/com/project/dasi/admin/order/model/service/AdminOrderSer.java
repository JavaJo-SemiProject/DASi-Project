package com.project.dasi.admin.order.model.service;

import com.project.dasi.order.model.dto.OrderListDTO;

import java.util.List;

public interface AdminOrderSer {
    public List<OrderListDTO> selectAllOrderList();

    public OrderListDTO selectOrderDetail(String orderId);
}
