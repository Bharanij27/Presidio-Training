package day19;

public class CustomerDTO {
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerPhone;
	private String customerAccountDetails;
	private String customeGSTNumber;
	
	private static CustomerDTO customerDTO;
	
	synchronized public static CustomerDTO getCustomerDTO() {
		if(customerDTO==null) {
			customerDTO=new CustomerDTO();
		}
		return customerDTO.getCloneCustomerDTO();		
	}
	
	private CustomerDTO getCloneCustomerDTO() {
		try {
			return (CustomerDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private CustomerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAccountDetails() {
		return customerAccountDetails;
	}

	public void setCustomerAccountDetails(String customerAccountDetails) {
		this.customerAccountDetails = customerAccountDetails;
	}

	public String getCustomeGSTNumber() {
		return customeGSTNumber;
	}

	public void setCustomeGSTNumber(String customeGSTNumber) {
		this.customeGSTNumber = customeGSTNumber;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerPhone=" + customerPhone + ", customerAccountDetails="
				+ customerAccountDetails + ", customeGSTNumber=" + customeGSTNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customeGSTNumber == null) ? 0 : customeGSTNumber.hashCode());
		result = prime * result + ((customerAccountDetails == null) ? 0 : customerAccountDetails.hashCode());
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPhone == null) ? 0 : customerPhone.hashCode());
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
		CustomerDTO other = (CustomerDTO) obj;
		if (customeGSTNumber == null) {
			if (other.customeGSTNumber != null)
				return false;
		} else if (!customeGSTNumber.equals(other.customeGSTNumber))
			return false;
		if (customerAccountDetails == null) {
			if (other.customerAccountDetails != null)
				return false;
		} else if (!customerAccountDetails.equals(other.customerAccountDetails))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
			return false;
		return true;
	}
	
}