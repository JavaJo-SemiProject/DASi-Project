package com.project.dasi.order.model.service;

import com.project.dasi.auth.model.dto.UserDTO;
import com.project.dasi.order.model.dto.OrderListDTO;

import java.util.List;

public interface OrderService {

    List<OrderListDTO> selectMyOrderList();

    OrderListDTO selectMyOrderDetail(UserDTO userId);

    void registOrder(OrderListDTO orderList);

}
