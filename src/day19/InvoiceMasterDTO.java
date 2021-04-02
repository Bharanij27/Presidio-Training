package day19;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class InvoiceMasterDTO implements Serializable, Cloneable{
	private String invoiceId;
	private Date invoiceDate;
	private int customerId;
	private static InvoiceMasterDTO invoiceMasterDTO;
	
	synchronized public static InvoiceMasterDTO getInvoiceMasterDTO() {
		if(invoiceMasterDTO == null) {
			invoiceMasterDTO = new InvoiceMasterDTO();
		}
		return invoiceMasterDTO.getCloneInvoiceMasterDTO();		
	}
	
	private InvoiceMasterDTO getCloneInvoiceMasterDTO() {
		try {
			return (InvoiceMasterDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}	

	public InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + ((invoiceDate == null) ? 0 : invoiceDate.hashCode());
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
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
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		if (customerId != other.customerId)
			return false;
		if (invoiceDate == null) {
			if (other.invoiceDate != null)
				return false;
		} else if (!invoiceDate.equals(other.invoiceDate))
			return false;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", customerId="
				+ customerId + "]";
	}

	
}
