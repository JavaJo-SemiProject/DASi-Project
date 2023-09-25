package com.project.dasi.admin.order.model.dao;

import com.project.dasi.order.model.dto.OrderListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminOrderMapper {
    List<OrderListDTO> selectAllOrderList();

    OrderListDTO selectOrderDetail(String orderId);

    void editStatus(OrderListDTO orderList);
}
