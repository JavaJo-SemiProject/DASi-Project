package com.project.dasi.mypage.model.dao;

import com.project.dasi.auth.model.dto.UserDTO;
import com.project.dasi.order.model.dto.OrderListDTO;

import java.util.List;
import java.util.Map;

public interface MyPageMapper {
	public List<OrderListDTO> selectMyOrderGoodsList(String userId);
	public List selectMyOrderInfo(String orderId);
	public List<OrderListDTO> selectMyOrderHistoryList(Map dateMap);
	public void updateMyInfo(Map memberMap);
	public UserDTO selectMyDetailInfo(String userId);
	public void updateMyOrderCancel(String orderId);
}
