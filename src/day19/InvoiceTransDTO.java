package day19;

import java.io.Serializable;

public class InvoiceTransDTO implements Serializable, Cloneable{
	private String invoiceId;
	private int itemId;
	private int qty;
	

	private static InvoiceTransDTO invoiceTransDTO;
	synchronized public static InvoiceTransDTO getInvoiceTransDTO() {
		if(invoiceTransDTO == null) {
			invoiceTransDTO = new InvoiceTransDTO();
		}
		return invoiceTransDTO.getCloneItemDTO();		
	}
	
	private InvoiceTransDTO getCloneItemDTO() {
		try {
			return (InvoiceTransDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private InvoiceTransDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getInvoiceId() {
		return invoiceId;
	}
	
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
		result = prime * result + itemId;
		result = prime * result + qty;
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
		InvoiceTransDTO other = (InvoiceTransDTO) obj;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		if (itemId != other.itemId)
			return false;
		if (qty != other.qty)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceTransDTO [itemId=" + itemId + ", qty=" + qty + ", invoiceId=" + invoiceId + "]";
	}
	
}
