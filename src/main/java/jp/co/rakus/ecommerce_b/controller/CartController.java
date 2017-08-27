package jp.co.rakus.ecommerce_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.service.OrderItemService;

/**
 * ショッピングカート一覧を表示するコントローラクラス.
 * @author hiroki.mae
 *
 */
@Controller
@RequestMapping("/cart-controller")
public class CartController {

	@Autowired
	OrderItemService orderitemservice;

	/**
	 * カート内一覧表示.
	 * @return カート画面へ遷移
	 */
	@RequestMapping("/show")
	public String show(){
		return "cart&checkorder/shopping_cart";
	}
	
	// ★item(大地さん)★
	// 商品の写真
	// 商品名
	// 商品サイズ
	// 商品価格
	// 商品数量

	// ★topping(猪狩)★
	// アイテムトッピング
	// アイテムトッピング価格
	// すべての小計(税抜)
	
	// 表示
	// 全件削除
	
	
	
	

}
