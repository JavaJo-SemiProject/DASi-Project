package com.project.dasi.order.model.service;


import com.project.dasi.order.model.dao.OrderMapper;
import com.project.dasi.order.model.dto.OrderFileDTO;
import com.project.dasi.order.model.dto.OrderListDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderRequestServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    public OrderRequestServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    @Transactional
    public void registOrder(OrderListDTO order) {

        System.out.println("order : " + order);



        int orderResult = orderMapper.insertOrderContent(order);

       /* List<OrderFileDTO> orderFileList = order.getOrderFileList();

        for (int i = 0; i < orderFileList.size(); i++) {

            orderFileList.get(i).setOrderId(order.getOrderId());

        }

        int orderFileResult = 0;
        for (int i = 0; i < orderFileList.size(); i++) {
            orderFileResult += orderMapper.insertOrderFile(orderFileList.get(i));
        }

        if (!(orderResult > 0 && orderFileResult == orderFileList.size())) {
            throw new RuntimeException("주문 등록에 실패하셨습니다.");
        }*/
    }


}
