package jp.co.rakus.ecommerce_b.domain;

import java.util.List;

/**
 * Item(商品)ドメイン.
 * @author ochi
 *
 */
public class Item {

	/** 商品ID */
	private Long id;
	/** 商品名 */
	private String name;
	/** 商品説明 */
	private String description;
	/** Mサイズの価格 */
	private Integer priceM;
	/** Lサイズの価格 */
	private Integer priceL;
	/** 画像パス */
	private String imagePath;
	/** 削除フラグ */
	private Boolean deleted;
	/** Toppingの全件検索を格納 **/
	private List<Topping> toppingList;
	
	/** 以降getter/setter */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public List<Topping> getToppingList() {
		return toppingList;
	}

	public void setToppingList(List<Topping> toppingList) {
		this.toppingList = toppingList;
	}

}
