package cn.smbms.pojo;

public class ItemClass {
	private String itemId;
	private String itemType;
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	@Override
	public String toString() {
		return "ItemClass [itemId=" + itemId + ", itemType=" + itemType + "]";
	}
	
}
