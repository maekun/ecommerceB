package jp.co.rakus.ecommerce_b.controller.form;

/**
 * OrderToppingForm作成
 * @author akihiko.yahiro
 *
 */
public class OrderToppingForm {
	/**id*/
	private String id;
	/**トッピングのid*/
	private String toppingId;
	/**注文商品のid*/
	private String orderItemId;
	/**Toppingクラスのフォーム*/
	private String topping;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToppingId() {
		return toppingId;
	}
	public void setToppingId(String toppingId) {
		this.toppingId = toppingId;
	}
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getTopping() {
		return topping;
	}
	public void setTopping(String topping) {
		this.topping = topping;
	}
	

}
