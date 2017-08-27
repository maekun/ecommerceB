package jp.co.rakus.ecommerce_b.domain;

import java.util.List;

/**
 * OrderItemの作成
 * 
 * @author akihiko.yahiro
 *
 */
public class OrderItem {
	/** id */
	private Long id;
	/** 商品のid */
	private Long itemId;
	/** 注文のid */
	private Long orderId;
	/** 数量 */
	private Integer quantity;
	/** サイズ */
	private Character size;
	/** 商品 */
	private Item item;
	/** トッピングのリスト */
	private List<OrderTopping> orderToppingList;

	public OrderItem() {
		super();
	}

	//テスト用コンストラクタ
	public OrderItem(Long itemId, Long orderId, Integer quantity, Character size) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.size = size;
	}

	/** ドメインモデルにはvoidと記載されていましたが誤りと判断し、intと記述しました。 */
	// TODO:八尋:まだ実行テストしていません。
	public int getSubTotal() {

		if (size.equals("m")) {
			int subTotal = 0;
			int itemPriceM = item.getPriceM();
			subTotal += itemPriceM;
			for (OrderTopping orderTopping : orderToppingList) {
				Topping topping = orderTopping.getTopping();
				int toppingPriceM = topping.getPriceM();
				subTotal += toppingPriceM;
			}
			return subTotal;
		}
		if (size.equals("l")) {
			int subTotal = 0;
			int itemPriceL = item.getPriceL();
			subTotal += itemPriceL;
			for (OrderTopping orderTopping : orderToppingList) {
				Topping topping = orderTopping.getTopping();
				int toppingPriceL = topping.getPriceL();
				subTotal += toppingPriceL;
			}
			return subTotal;
		}
		return 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLongId(int id) {
		this.id = Long.valueOf(id);
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Character getSize() {
		return size;
	}

	public void setSize(Character size) {
		this.size = size;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<OrderTopping> getOrderToppingList() {
		return orderToppingList;
	}

	public void setOrderToppingList(List<OrderTopping> orderToppingList) {
		this.orderToppingList = orderToppingList;
	}

}
