package jp.co.rakus.ecommerce_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ショッピングカートに商品を追加するコントローラクラス.
 * @author hiroki.mae
 *
 */
@Controller
@RequestMapping("/cart-add-controller")
public class CartAddController {

	@Autowired
	private CartController cartController;
	
	/**
	 * カートに商品を追加する.
	 * @return カート詳細画面
	 */
	@RequestMapping("/add")
	public String addOrderItem(){
		
		return cartController.show();
	}
}
