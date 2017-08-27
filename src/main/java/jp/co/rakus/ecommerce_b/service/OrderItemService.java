package jp.co.rakus.ecommerce_b.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.ecommerce_b.repository.ItemRepository;
import jp.co.rakus.ecommerce_b.repository.OrderItemRepository;

@Service
@Transactional
public class OrderItemService {

	@Autowired
	OrderItemRepository orderitemrepository;
	@Autowired
	ItemRepository itemrepository;

	
	
	
//	/**
//	 * 全件検索
//	 * @return
//	 */
//	public List<OrderItem> findAll(){
//		orderitemrepository.findAll();
//		
//		List<Item> itemList = itemrepository.findAll();
//		for(item : itemList){
//			item.getId();
//			item.getName();
//			item.getDescription();
//			item.getPriceM();
//			item.getPriceL();
//			item.getImagePath();
//		
//		
//		return a;
//	}

	/**
	 * 削除
	 * @param id
	 */
	public void delete(Integer id) {
		orderitemrepository.delete(id);
	}
}
