package jp.co.rakus.ecommerce_b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.domain.OrderItem;
import jp.co.rakus.ecommerce_b.domain.OrderTopping;
import jp.co.rakus.ecommerce_b.domain.ShoppingCart;
import jp.co.rakus.ecommerce_b.repository.OrderItemRepository;
import jp.co.rakus.ecommerce_b.repository.OrderRepository;
import jp.co.rakus.ecommerce_b.repository.OrderToppingRepository;

/**
 * ショッピングカートに商品を追加するコントローラクラス.
 * 
 * @author hiroki.mae
 *
 */
@Service
@Transactional
public class CartAddService {

	/** ログインユーザid */
	private Long loginUserId;
	/** カートid */
	private Long orderId;
	/** 注文されたトッピングのついたピザid */
	private Long orderItemId;
	// てんぷれ
	// /** */
	// private

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private OrderToppingRepository orderToppingRepository;


	/**
	 * ShoppingCartごと注文を受ける.
	 * 
	 * @param cart
	 *            ショッピングカート
	 */
	public void insertOrder(ShoppingCart cart) {

		Order order = new Order(cart);
		Order newOrder = insertOrder(order);
		orderId = newOrder.getId();
		
		List<OrderItem> orderItemList = cart.getOrderItemList();
		
		for (OrderItem orderItem : orderItemList) {
			OrderItem orderItemWithId = insertOrderItem(orderItem);
			orderItemId = orderItemWithId.getId();
			
			List<OrderTopping>orderToppingList = orderItem.getOrderToppingList();
			for (OrderTopping orderTopping : orderToppingList) {
				insertOrderTopping(orderTopping);
			}
		}
	}
	/**
	 * OrdersテーブルへのInsert担当
	 * 
	 * @return id付きOrderオブジェクト
	 */
	public Order insertOrder(Order order) {
		return orderRepository.firstInsertItem(order);
	}

	/**
	 * Order_itemsテーブルへのInsert担当.
	 * 
	 * @param orderItem
	 *            ピザの注文
	 */
	public OrderItem insertOrderItem(OrderItem orderItem) {
		OrderItem orderItemWithId = orderItemRepository.insert(orderItem);
		return orderItemWithId;
	}

	/**
	 * Order_toppingsテーブルへのInsert担当.
	 * 
	 * @param orderTopping
	 *            ピザの注文id付きトッピングオブジェクト
	 * @return ピザの注文id付きトッピングオブジェクト
	 */
	public OrderTopping insertOrderTopping(OrderTopping orderTopping) {

			orderTopping.setOrderItemId(orderItemId);
			orderToppingRepository.insert(orderTopping);

			return orderTopping;
	}

}
