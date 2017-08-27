package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.ecommerce_b.domain.OrderTopping;
import jp.co.rakus.ecommerce_b.repository.OrderToppingRepository;

@Service
@Transactional
public class OrderToppingService {

	@Autowired
	OrderToppingRepository ordertoppingrepository;

	/**
	 * 1件検索
	 * @param id
	 * @return
	 */
	public OrderTopping load(Integer id) {
		return ordertoppingrepository.load(id);
	}

	/**
	 * 全件検索
	 * @return
	 */
	public List<OrderTopping> findAll() {
		return ordertoppingrepository.findAll();
	}

	/**
	 * 削除
	 * @param id
	 */
	public void delete(Integer id) {
		ordertoppingrepository.delete(id);

	}

}
