package jp.co.rakus.ecommerce_b.domain;

/**
 * OrderToppingクラスの作成
 * @author akihiko.yahiro
 *
 */
public class OrderTopping {
	/**id*/
	private Integer id;
	/**トッピングのid*/
	private Integer toppingId;
	/**注文商品のid*/
	private Integer orderItemId;
	/**Toppingクラスを持つためのフィールド*/
	private Topping topping;
	
	/**
	 * デフォルトコンストラクタ.
	 */
	public OrderTopping() {
		super();
	}
	/**
	 * 引数ありコンストラクタ.
	 * @param toppingId
	 * @param orderItemId
	 */
	public OrderTopping(Integer toppingId, Integer orderItemId) {
		super();
		this.toppingId = toppingId;
		this.orderItemId = orderItemId;
	}
	/**
	 * orderItemIdをorderToppingにセットする際に使用.
	 * @param orderItemId orderItemId
	 */
	public void setOrderItemId(Long orderItemId) {
		try {
			this.orderItemId = new Integer(orderItemId.toString());
		} catch (NullPointerException e){
			this.orderItemId = 0;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.err.println("order_itemsテーブルのidが大きすぎます");
		}
	}
	public Topping getTopping() {
		return topping;
	}
	public void setTopping(Topping topping) {
		this.topping = topping;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getToppingId() {
		return toppingId;
	}
	public void setToppingId(Integer toppingId) {
		this.toppingId = toppingId;
	}
	public Integer getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

}
