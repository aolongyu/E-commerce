package cn.smbms.pojo;

public class Item {

	String itemId;
	String itemName;
	double priceOld;
	double priceNow;
	int stock;
	String picture;
	String itemType;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPriceOld() {
		return priceOld;
	}

	public void setPriceOld(double priceOld) {
		this.priceOld = priceOld;
	}

	public double getPriceNow() {
		return priceNow;
	}

	public void setPeiceNow(double priceNow) {
		this.priceNow = priceNow;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
