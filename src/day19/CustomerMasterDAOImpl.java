package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day18.DBUtility;

public class CustomerMasterDAOImpl implements CustomerMasterDAO{
	
	public void setCustomerData(CustomerDTO customer, int id, String name, String address, String phone, String acc, String gst){		
		customer.setCustomerId(id);
		customer.setCustomerName(name);
		customer.setCustomerAddress(address);
		customer.setCustomerPhone(phone);
		customer.setCustomerAccountDetails(acc);
		customer.setCustomeGSTNumber(gst);
	}
	
	@Override
	public CustomerDTO findByID(Integer customerId) {
		
		CustomerDTO customer = null;
		
		try {
			customer = CustomerDTO.getCustomerDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement st = con.prepareStatement("select * from customer where customerId=?");
			
			st.setInt(1, customerId);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {				
				setCustomerData(customer, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		
		return customer;
	}

	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerDTO> customerArray = null;
		
		try {
			customerArray = new ArrayList<CustomerDTO>();
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from customer");
			while(rs.next()) {		
				CustomerDTO customer = CustomerDTO.getCustomerDTO();
				setCustomerData(customer, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				customerArray.add(customer);
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		
		return customerArray;
	}

	@Override
	public int insertItem(CustomerDTO customerDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			int id = customerDTO.getCustomerId();
			String name = customerDTO.getCustomerName();
			String address =  customerDTO.getCustomerAddress();
			String phoneNumber = customerDTO.getCustomerPhone();
			String accNum = customerDTO.getCustomerAccountDetails();
			String gstNum = customerDTO.getCustomeGSTNumber();
			
			i = st.executeUpdate("insert into customer values (" + id + ",'" + name + "','" + address + "','" + phoneNumber + "','" + accNum + "','" + gstNum + "')");
			System.out.println(i +" rows inserted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int updateItem(CustomerDTO customerDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			int id = customerDTO.getCustomerId();
			String name = customerDTO.getCustomerName();
			String address =  customerDTO.getCustomerAddress();
			String phoneNumber = customerDTO.getCustomerPhone();
			String accNum = customerDTO.getCustomerAccountDetails();
			String gstNum = customerDTO.getCustomeGSTNumber();
			
			i = st.executeUpdate("update customer set customerName = '" + name + "', customerAddress = '" + address + "', customerPhoneNum = '" + phoneNumber + "', customerAccountDetail = '" + accNum + "', customerGSTNum = '" + gstNum + "' where customerId = " + id);
			System.out.println(i +" rows updated....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByID(Integer customerId) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from customer where customerId = " + customerId);
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByDTO(CustomerDTO customerDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from customer where customerId = " + customerDTO.getCustomerId());
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

}