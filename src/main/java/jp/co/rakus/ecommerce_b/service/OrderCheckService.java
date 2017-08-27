package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.OrderItem;

@Service
public class OrderCheckService {
	
	public int calcTax(List<OrderItem> orderItemList){
		int tax = (int)(calcsubTotalPrice(orderItemList) * 0.08);
		return tax;
	}
	
	public int calcsubTotalPrice(List<OrderItem> OrderItemList){
		List<OrderItem> orderItems = OrderItemList;
		int subtotal = 0;
		for (OrderItem orderItem : orderItems) {
			subtotal += orderItem.getSubTotal();
		}
		return subtotal;
	}
	
}
