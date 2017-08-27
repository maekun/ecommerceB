package jp.co.rakus.ecommerce_b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.controller.form.SearchForm;
import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.service.ItemService;

/**
 * 商品一覧画面(トップ画面)用コントローラー.
 * 
 * @author ochi
 *
 */
@Controller
@RequestMapping("/top")
public class ItemListController {

	/** Item(商品)用サービス */
	@Autowired
	private ItemService itemService;

	/** 検索フォーム クラス*/
	@ModelAttribute
	public SearchForm setUpForm() {
		return new SearchForm();
	}

	/**
	 * 商品一覧画面(トップ画面)表示.
	 * 
	 * @param model
	 *            リクエストスコープ
	 * @return 商品一覧画面(トップ画面)へフォワード
	 */
	@RequestMapping("/")
	public String show(Model model) {
		List<Item> itemList = itemService.findAll();

		model.addAttribute("itemList", itemList);
		
		return "pizza/top";
	}

	/**
	 * 商品検索.
	 * @param form 検索キーワードフォーム
	 * @param model リクエストスコープ
	 * @return 商品一覧画面(トップ画面)へフォワード
	 */
	@RequestMapping("/search")
	public String search(SearchForm form, Model model) {

		List<Item> itemList = itemService.findByName(form);

		if(itemList.size() == 0){
			model.addAttribute("notFound", "該当する商品がありません");
			itemList = itemService.findAll();
			model.addAttribute("itemList", itemList);
			return "pizza/top";
		}
			
		model.addAttribute("itemList", itemList);
		
		return "pizza/top";
				
	}

}