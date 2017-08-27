package jp.co.rakus.ecommerce_b.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.rakus.ecommerce_b.domain.Order;
import jp.co.rakus.ecommerce_b.domain.OrderItem;
import jp.co.rakus.ecommerce_b.domain.OrderTopping;
import jp.co.rakus.ecommerce_b.domain.ShoppingCart;
import jp.co.rakus.ecommerce_b.repository.OrderItemRepository;
import jp.co.rakus.ecommerce_b.repository.OrderRepository;
import jp.co.rakus.ecommerce_b.repository.OrderToppingRepository;

/**
 * CartAddServiceクラスのテストクラス.
 * @author hiroki.mae
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartAddServiceTest {
	
	@Autowired
	private CartAddService cartAddService;
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderToppingRepository orderToppingRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		orderRepository.deleteAll();
		orderItemRepository.deleteAll();
		orderToppingRepository.deleteAll();
		
		OrderTopping orderTopping1 = new OrderTopping(1,2);
		OrderTopping orderTopping2 = new OrderTopping(2,3);
		OrderTopping orderTopping3 = new OrderTopping(3,1);
		
		List<OrderTopping>orderToppingList = new ArrayList<>();
		orderToppingList.add(orderTopping1);
		orderToppingList.add(orderTopping2);
		orderToppingList.add(orderTopping3);
		
		for (OrderTopping orderTopping : orderToppingList) {
			cartAddService.insertOrderTopping(orderTopping);
		}
		
		OrderItem orderItem = new OrderItem(new Long("1"),new Long("2"),5, 'L');
		cartAddService.insertOrderItem(orderItem);
		
		List<OrderItem>orderItemList = new ArrayList<>();
		orderItemList.add(orderItem);
		ShoppingCart cart = new ShoppingCart(new Long("1"),0, 10000);
		
		Order order = new Order(cart);
		cartAddService.insertOrder(order);
	}

	@After
	public void tearDown() throws Exception {
		orderRepository.deleteAll();
		orderItemRepository.deleteAll();
		orderToppingRepository.deleteAll();
	}

	@Test
	public void order_toppingsテーブルに全件追加できていること() {
		//OrderTopping insertOrderTopping(OrderTopping orderTopping) {
		List<OrderTopping>orderToppingList = orderToppingRepository.findAll();
		assertThat("TC1:全件追加できていません",orderToppingList.size(),is(3));
	}
	@Test
	public void order_toppingsテーブルに正しい内容で追加できていること() {
		//OrderTopping insertOrderTopping(OrderTopping orderTopping) {
		OrderTopping orderTopping = orderToppingRepository.loadByToppingId(3);
		assertThat("TC2:正しい内容で追加できていません",orderTopping.getOrderItemId(),is(0));
	}
	@Test
	public void order_itemsテーブルに正しい内容で追加できていること() {
		//OrderTopping insertOrderTopping(OrderTopping orderTopping) {
		OrderItem orderItem = orderItemRepository.loadByItemId(1);
		assertThat("TC3:正しい内容で追加できていません",orderItem.getOrderId(),is(2L));
	}
	@Test
	public void ordersテーブルに正しい内容で追加できていること() {
		//OrderTopping insertOrderTopping(OrderTopping orderTopping) {
		Order order = orderRepository.loadByUserId(1);
		assertThat("TC3:正しい内容で追加できていません",order.getTotalPrice(),is(10000));
	}
	

}
