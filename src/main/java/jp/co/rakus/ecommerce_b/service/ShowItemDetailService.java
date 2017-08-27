package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.domain.Topping;
import jp.co.rakus.ecommerce_b.repository.ItemRepository;
import jp.co.rakus.ecommerce_b.repository.ToppingRepository;
/**
 * トッピングの情報を引き出すサービス
 * 
 * @author hiroshi.igari
 *
 */
@Service
public class ShowItemDetailService {
	
@Autowired
private ToppingRepository toppingRepository;
@Autowired
private ItemRepository itemRepository;

	//全件検索を行うfindAllのメソッド
	public Item execute(Integer id){
		// (1)Item を取ってくる
		Item item = itemRepository.load(id);
		
		// (2)トッピングリストを取ってくる
		List<Topping> toppingList=toppingRepository.findAll();
		
		//(1)でとってきたitemのなかに(2)でとってきたトッピングリストを入れる
		item.setToppingList(toppingList);
		// itemを返す
		return item;
	}
}