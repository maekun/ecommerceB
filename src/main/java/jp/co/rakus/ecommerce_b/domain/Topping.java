package jp.co.rakus.ecommerce_b.domain;
/**
 * 
 */
/**
 * @author hiroshi.igari
 *トッピングのドメインクラス
 */
public class Topping {
	/* 商品ID */
	private Integer id;
	/* トッピングの名前 */
	private String name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
