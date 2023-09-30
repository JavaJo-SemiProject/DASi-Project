package com.project.dasi.order.model.dao;

import com.project.dasi.order.model.dto.PayInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentMapper {

    void insertPayment(PayInfoDTO payment);
}