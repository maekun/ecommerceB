/**
 * 
 */
/**
 * @author hiroshi.igari
 *トッピングのドメインクラス
 */
package jp.co.rakus.ecommerce_b.controller.form;

import java.util.List;

public class ToppingForm {
	/* 商品ID */
	private Integer id;
	/* トッピングの名前 */
	private List<String> toppingVariety;
	/* Mサイズピザの値段 */
	private Integer priceM;
	/* Lサイズピザの値段 */
	private Integer priceL;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<String> getToppingVariety() {
		return toppingVariety;
	}
	public void setToppingVariety(List<String> toppingVariety) {
		this.toppingVariety = toppingVariety;
	}
	public Integer getPriceM() {
		return priceM;
	}
	public void setPriceM(Integer priceM) {
		this.priceM = priceM;
	}
	public Integer getPriceL() {
		return priceL;
	}
	public void setPriceL(Integer priceL) {
		this.priceL = priceL;
	}
}