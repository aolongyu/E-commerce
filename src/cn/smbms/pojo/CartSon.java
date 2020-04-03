package cn.smbms.pojo;

public class CartSon extends Cart {
	String itemType;
	String itemName;
	double priceOld;
	double priceNow;
	String picture;

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
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

	public void setPriceNow(double priceNow) {
		this.priceNow = priceNow;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
