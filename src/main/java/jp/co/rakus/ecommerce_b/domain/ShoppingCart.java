package jp.co.rakus.ecommerce_b.domain;

import java.util.List;

/**
 * ショッピングカートを表すドメインクラス.
 * @author hiroki.mae
 *
 */
public class ShoppingCart {

	/** ログインユーザid*/
	private Long loginUserId;
	/**配達完了ステータス*/
	private Integer status;
	/** カートに追加されたピザを管理*/
	private List<OrderItem> orderItemList;
	/** 合計金額（税込）*/
	//購入履歴で使用するなら税込かなと
	private Integer totalPrice;
	
	public ShoppingCart() {
		super();
	}
	public ShoppingCart(Long loginUserId,Integer status,Integer totalPrice) {
		super();
		this.loginUserId = loginUserId;
		this.status = status;
		this.totalPrice = totalPrice;
	}
	public ShoppingCart(Long loginUserId,Integer status,List<OrderItem> orderItemList, Integer totalPrice) {
		super();
		this.loginUserId = loginUserId;
		this.orderItemList = orderItemList;
		this.totalPrice = totalPrice;
	}
	public Long getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(Long loginUserId) {
		this.loginUserId = loginUserId;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
