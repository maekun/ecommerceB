package jp.co.rakus.ecommerce_b.controller.form;

/**
 * orderの内容を受けるForm
 * @author yuta.honma
 *
 */
public class OrderForm {
	/**宛先名前*/
	private String destinationName;
	/**宛先のEメール*/
	private String destinationEmail;
	/**宛先郵便番号*/
	private String destinationZipcode;
	/**宛先住所*/
	private String destinationAddress;
	/**宛先TEL*/
	private String destinationTel;
	/**注文日*/
	private String orderDate;
	/**配達時間*/
	private String deliveryTime;
	/**支払い方法*/
	private String paymentethod;
	
	
	
	
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
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public String getPaymentethod() {
		return paymentethod;
	}
	public void setPaymentethod(String paymentethod) {
		this.paymentethod = paymentethod;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
