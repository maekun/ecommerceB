package jp.co.rakus.ecommerce_b.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.controller.form.OrderForm;
import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.domain.OrderItem;
import jp.co.rakus.ecommerce_b.service.SettlementService;

@Controller
@RequestMapping("/")
public class SettlementController {
	@Autowired
	private SettlementService settlementService;
	
	@Autowired
	private HttpSession session;
	@ModelAttribute
	private OrderForm setorderForm(){
		return new OrderForm();
	}
	
	public String settle(OrderForm form){
//		オーダー登録処理
		//TODO:ほんま　UserID　Userフィールドの処理を行うこと
//		String to Date
		String strOrderDate = form.getOrderDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date orderDate = null;
		try {
			orderDate = sdf.parse(strOrderDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String deliveryHour = form.getDeliveryTime();
		String strTimeStamp = strOrderDate + " " + deliveryHour + ":00:00";
		Timestamp deliveryTime = Timestamp.valueOf(strTimeStamp);
		
//		paymentmethod
		int paymentmethod = 0;
		paymentmethod = Integer.parseInt(form.getPaymentethod());
		
//		status
		int status = 0;
		if (paymentmethod == 1) {
			status = 1;
		} else {
			status = 2;
		}
		
		
		
		//TODO:ほんま見直し
		
		return "redirect";
	}
}
