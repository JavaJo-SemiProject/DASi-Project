package com.project.dasi.admin.order.model.service;

import com.project.dasi.admin.order.model.dao.AdminOrderMapper;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminOrderService implements AdminOrderSer {

    private final AdminOrderMapper adminOrderMapper;

    public AdminOrderService(AdminOrderMapper adminOrderMapper) {
        this.adminOrderMapper = adminOrderMapper;
    }


    @Override
    public List<OrderListDTO> selectAllOrderList() {
        List<OrderListDTO> orderList = adminOrderMapper.selectAllOrderList();

        System.out.println("orderList : " + orderList);

        return orderList;
    }

    @Override
    public OrderListDTO selectOrderDetail(String orderId) {
        OrderListDTO orderDetail = null;

        orderDetail = adminOrderMapper.selectOrderDetail(orderId);


        return orderDetail;

    }

    @Transactional
    public void editStatus(OrderListDTO orderList) {
        System.out.println("Controller OrderList: " + orderList);
       adminOrderMapper.editStatus(orderList);
    }

    public List<OrderListDTO> selectMyOrderList(String userId) {
        System.out.println("UserCode: " + userId);
        List<OrderListDTO> orderList = adminOrderMapper.selectMyOrderList(userId);
        System.out.println("orderList: " + orderList);

        return orderList;
    }

    @Transactional
    public void updateDeliver(OrderListDTO order) {
        System.out.println("order ser : " + order);
        adminOrderMapper.updateDeliver(order);
    }
}
