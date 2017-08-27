package jp.co.rakus.ecommerce_b.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.User;

/**
 * オーダーの入力値を受け取るForm
 * @author yuta.honma
 *
 */
public class Order {
	/**オーダーID*/
	private long id;
	/**ユーザーのID*/
	private long userId;
	/**配達状況ステータス*/
	private Integer status;
	/**オーダーの合計金額*/
	private Integer totalPrice;
	/**注文日*/
	private Date orderDate;
	/**宛先名*/
	private String destinationName;
	/**宛先のEメール*/
	private String destinationEmail;
	/**宛先郵便番号*/
	private String destinationZipcode;
	/**宛先住所*/
	private String destinationAddress;
	/**宛先TEL*/
	private String destinationTel;
	/**配達時間*/
	private Timestamp deliveryTime;
	/**支払い方法*/
	private Integer paymentethod;
	/**ログインユーザー*/
	private User user;
	/**注文リスト*/
	private List<OrderItem> orderItemList;
	
	/**
	 * デフォルトコンストラクタ.
	 */
	public Order(){
		super();
	}

	/**
	 * 会計前にカートをテーブルに保存する際に使用する<br>
	 * カートを受け取るコンストラクタ.
	 */
	public Order(ShoppingCart cart){
		super();
		this.userId = cart.getLoginUserId();
		this.status = cart.getStatus();
		this.totalPrice = cart.getTotalPrice();
	}
	
	/**
	 * 引数にカート有りのコンストラクタ.
	 */
	public Order(long id,Integer status,  Date orderDate, String destinationName,
			String destinationEmail, String destinationZipcode, String destinationAddress, String destinationTel,
			Timestamp deliveryTime, Integer paymentethod, User user,ShoppingCart cart) {
		super();
		this.id = id;
		this.userId = cart.getLoginUserId();
		this.status = status;
		this.totalPrice = cart.getTotalPrice();
		this.orderDate = orderDate;
		this.destinationName = destinationName;
		this.destinationEmail = destinationEmail;
		this.destinationZipcode = destinationZipcode;
		this.destinationAddress = destinationAddress;
		this.destinationTel = destinationTel;
		this.deliveryTime = deliveryTime;
		this.paymentethod = paymentethod;
	}
	/**
	 * 引数からUserとOrderItemListコンストラクタ.
	 */
	public Order(long id, long userId, Integer status, Integer totalPrice, Date orderDate, String destinationName,
			String destinationEmail, String destinationZipcode, String destinationAddress, String destinationTel,
			Timestamp deliveryTime, Integer paymentethod) {
		super();
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.destinationName = destinationName;
		this.destinationEmail = destinationEmail;
		this.destinationZipcode = destinationZipcode;
		this.destinationAddress = destinationAddress;
		this.destinationTel = destinationTel;
		this.deliveryTime = deliveryTime;
		this.paymentethod = paymentethod;
	}
	/**
	 * 全引数ありコンストラクタ.
	 */
	public Order(long id, long userId, Integer status, Integer totalPrice, Date orderDate, String destinationName,
			String destinationEmail, String destinationZipcode, String destinationAddress, String destinationTel,
			Timestamp deliveryTime, Integer paymentethod, User user, List<OrderItem> orderItemList) {
		super();
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.destinationName = destinationName;
		this.destinationEmail = destinationEmail;
		this.destinationZipcode = destinationZipcode;
		this.destinationAddress = destinationAddress;
		this.destinationTel = destinationTel;
		this.deliveryTime = deliveryTime;
		this.paymentethod = paymentethod;
		this.user = user;
		this.orderItemList = orderItemList;
	}

	public Long getLongId() {
		return Long.valueOf(id);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getDestinationEmail() {
		return destinationEmail;
	}
	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}
	public String getDestinationZipcode() {
		return destinationZipcode;
	}
	public void setDestinationZipcode(String destinationZipcode) {
		this.destinationZipcode = destinationZipcode;
	}
	public String getDestinationAddress() {
		return destinationAddress;
	}
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	public String getDestinationTel() {
		return destinationTel;
	}
	public void setDestinationTel(String destinationTel) {
		this.destinationTel = destinationTel;
	}
	public Timestamp getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Integer getPaymentethod() {
		return paymentethod;
	}
	public void setPaymentethod(Integer paymentethod) {
		this.paymentethod = paymentethod;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	public int getTax(){
		int totalPrice = 0;
		for (OrderItem orderItem : orderItemList) {
			totalPrice += orderItem.getSubTotal();
		}
		int tax = (int)(totalPrice * 0.08);
		return tax;
	}

}
