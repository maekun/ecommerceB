package jp.co.rakus.ecommerce_b.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce_b.controller.form.SearchForm;
import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.repository.ItemRepository;

/**
 * Item(商品)用サービス.
 * @author ochi
 *
 */
@Service
public class ItemService {

	/** Item(商品)用リポジトリ */
	@Autowired
	private ItemRepository itemRepository;

	/**
	 * Item(商品)の全件検索.
	 * コントローラーからリポジトリへの仲介
	 * @return 検索結果のItem(商品)リスト
	 */
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	/**
	 * Item(商品)の1件検索.
	 * コントローラーからリポジトリへの仲介
	 * orderItemとの紐付けで必要な為、八尋が作成しました.
	 * @param id itemのid
	 * @return　検索結果のItem(商品)
	 */
	public Item load(Integer id){
		return itemRepository.load(id);
	}
	
	/**
	 * Item(商品)の名前検索.
	 * @param form 検索フォーム
	 * @return 検索結果のItem(商品)リスト
	 */
	public List<Item> findByName(SearchForm form){

		List<String> searchWordList = new ArrayList<>();
		searchWordList = form.getSearchWordList();
		
		List<Item> itemList = new ArrayList<>();
		
		boolean sameSwitch = false;
		
		for (String searchWord : searchWordList) {
			List<Item> searchResultList = itemRepository.findByName(searchWord);
			
			for (Item searchItem : searchResultList) {

					if (searchItem.getId() != null) {
						
							if(itemList.size() != 0){
								for (Item item : itemList) {
									if(searchItem.getId() == item.getId()){
										sameSwitch = true;
									}
								}
							}
							
							if(sameSwitch == false){
						
								itemList.add(searchItem);

							}else{
								
								sameSwitch = false;
								
							}
							
					}
			}
		}
		
		return itemList;
		
	}

}