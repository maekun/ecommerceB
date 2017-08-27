package jp.co.rakus.ecommerce_b.controller.form;

import java.util.List;

/**
 *  OrderItemFormの作成
 * @author akihiko.yahiro
 *
 */
public class OrderItemForm {
	/**id*/
	private String id;
	/**商品のid*/
	private String itemId;
	/**注文のid*/
	private String orderId;
	/**数量*/
	private String quantity;
	/**サイズ*/
	private String size;
	/**商品*/
	private String item;
	/**トッピングのリスト*/
	private List<String> orderToppingList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public List<String> getOrderToppingList() {
		return orderToppingList;
	}
	public void setOrderToppingList(List<String> orderToppingList) {
		this.orderToppingList = orderToppingList;
	}
	
	
	
	
}
