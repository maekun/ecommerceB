package jp.co.rakus.ecommerce_b.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.controller.form.OrderItemForm;
import jp.co.rakus.ecommerce_b.controller.form.SearchForm;
import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.service.ShowItemDetailService;

/**
 * 商品詳細画面用コントローラー.
 * @author ochi
 *
 */
@Controller
@RequestMapping("/item-detail-controller")
public class ShowItemDetailController {
	
	@Autowired
	private ItemListController itemListController;
	
	/** 詳細画面用(トッピング付きピザを完成させることができる)サービス */
	@Autowired
	private ShowItemDetailService showItemDetailService;
	
	/** 商品注文フォームクラス */
	@ModelAttribute
	public OrderItemForm setUpForm(){
		return new OrderItemForm();
	}
	/** 検索フォーム クラス*/
	@ModelAttribute
	public SearchForm setUpSearchForm(){
		return new SearchForm();
	}

	/**
	 * 商品詳細画面表示.
	 * @param id 商品ID
	 * @param model リクエストスコープ
	 * @return 商品詳細画面へフォワード
	 */
	@RequestMapping("/show")
	public String show(Integer id, Model model){
		
		//期待しているURLが飛んでこなかった場合、商品一覧へ画面遷移させる
		try {
			Item item = showItemDetailService.execute(id);
			model.addAttribute("item", item);
		} catch (Exception e) {
			return itemListController.show(model);
		}
		
		Map<Integer, Integer> quantityMap = new LinkedHashMap<>();
		quantityMap.put(1, 1);
		quantityMap.put(2, 2);
		quantityMap.put(3, 3);
		quantityMap.put(4, 4);
		quantityMap.put(5, 5);
		quantityMap.put(6, 6);
		quantityMap.put(7, 7);
		quantityMap.put(8, 8);
		quantityMap.put(9, 9);
		quantityMap.put(10, 10);
		quantityMap.put(11, 11);
		quantityMap.put(12, 12);
		model.addAttribute("quantityMap", quantityMap);
		
		return "pizza/detail";
	}

}
