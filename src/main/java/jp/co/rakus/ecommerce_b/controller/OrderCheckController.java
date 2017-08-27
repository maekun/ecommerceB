package jp.co.rakus.ecommerce_b.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.domain.OrderItem;
import jp.co.rakus.ecommerce_b.service.OrderCheckService;

//TODO:ほんま pathを全体で確認しろ
@Controller
@RequestMapping("/order-result")
public class OrderCheckController {
	@Autowired
	private OrderCheckService service;
	@Autowired
	private HttpSession session;
	
	
	
	/**
	 * 確認画面へ遷移
	 * @return
	 */
	@RequestMapping("/show")
	public String show(){
		return "ordercheck";
	}
	
	/**
	 * オーダー確認表示するための処理
	 * @return 確認画面へ遷移
	 */
	@RequestMapping("")
	public String checkOrder(){
//		消費税合計額計算
		List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("orderItemList");
		int tax = service.calcTax(orderItems);
		int totalPrice = service.calcsubTotalPrice(orderItems) + tax;
		session.setAttribute("tax", tax);
		session.setAttribute("totalPrice", totalPrice);
		
		return "redirect:/order-result/show";
	}
	
}
