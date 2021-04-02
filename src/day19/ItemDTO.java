package day19;

import java.io.Serializable;

public class ItemDTO implements Serializable,Cloneable{
	private int itemid;
	private String itemDesc;
	private float price;
	
	private static ItemDTO itemDTO;
	synchronized public static ItemDTO getItemDTO() {
		if(itemDTO==null) {
			itemDTO=new ItemDTO();
		}
		return itemDTO.getCloneItemDTO();		
	}
	
	private ItemDTO getCloneItemDTO() {
		try {
			return (ItemDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private ItemDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "ItemDTO [itemid=" + itemid + ", itemDesc=" + itemDesc + ", price="
				+ price + "]";
	}

	public final int getItemid() {
		return itemid;
	}
	public final void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public final String getItemDes() {
		return itemDesc;
	}
	public final void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public final float getPrice() {
		return price;
	}
	public final void setPrice(float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemDesc == null) ? 0 : itemDesc.hashCode());
		result = prime * result + itemid;
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDTO other = (ItemDTO) obj;
		if (itemDesc == null) {
			if (other.itemDesc != null)
				return false;
		} else if (!itemDesc.equals(other.itemDesc))
			return false;
		if (itemid != other.itemid)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}


	
}
