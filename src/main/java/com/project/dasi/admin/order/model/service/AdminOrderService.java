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
    @Transactional
    public List<OrderListDTO> selectAllOrderList() {
        List<OrderListDTO> orderList = adminOrderMapper.selectAllOrderList();

        System.out.println("orderList : " + orderList);

        return orderList;
    }

    @Override
    @Transactional
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
}
