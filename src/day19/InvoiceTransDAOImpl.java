package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day18.DBUtility;

public class InvoiceTransDAOImpl implements InvoiceTransDAO{

	public void setInvoicrTransData(InvoiceTransDTO invoiceTransDTO, String invoiceId, int itemId, int qty){		
		invoiceTransDTO.setItemId(itemId);
		invoiceTransDTO.setInvoiceId(invoiceId);
		invoiceTransDTO.setQty(qty);
	}
	
	@Override
	public InvoiceTransDTO findByID(Integer itemId, String invoiceId) {
		InvoiceTransDTO trans = null;
		
		try {
			trans = InvoiceTransDTO.getInvoiceTransDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement st = con.prepareStatement("select * from invoiceTrans where itemId=? and invoiceId=?");
			
			st.setInt(1, itemId);
			st.setString(2, invoiceId);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {				
				setInvoicrTransData(trans, rs.getString(1), rs.getInt(2), rs.getInt(3));
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}

//		System.out.println(trans);
		return trans;
	}

	@Override
	public List<InvoiceTransDTO> findAll() {
		List<InvoiceTransDTO> invoiceTransArray = null;
		
		try {
			invoiceTransArray = new ArrayList<InvoiceTransDTO>();
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from invoiceTrans");
			while(rs.next()) {		
				InvoiceTransDTO invoiceTrans = InvoiceTransDTO.getInvoiceTransDTO();
				setInvoicrTransData(invoiceTrans, rs.getString(1), rs.getInt(2), rs.getInt(3));
				invoiceTransArray.add(invoiceTrans);
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		
		invoiceTransArray.forEach(c -> {
			System.out.println(c);
		});
		return invoiceTransArray;
	}

	@Override
	public int insertItem(InvoiceTransDTO invoiceTransDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			int itemId = invoiceTransDTO.getItemId();
			String invoiceId = invoiceTransDTO.getInvoiceId();
			int qty = invoiceTransDTO.getQty();
			
			i = st.executeUpdate("insert into invoiceTrans values ('" + invoiceId + "', "  + itemId + ", " + qty + ")");
			System.out.println(i +" rows updated....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int updateItem(InvoiceTransDTO invoiceTransDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			int itemId = invoiceTransDTO.getItemId();
			String invoiceId = invoiceTransDTO.getInvoiceId();
			int qty = invoiceTransDTO.getQty();
			
			i = st.executeUpdate("update invoiceTrans set quantity = " + qty + " where itemId = " + itemId + " and invoiceId = " + invoiceId);
			System.out.println(i +" rows updated....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByID(Integer itemId, String invoiceId) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from invoiceTrans where itemId = " + itemId + " and invoiceId = '" + invoiceId + "'");
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByDTO(InvoiceTransDTO invoiceTransDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from invoiceTrans where itemId = " + invoiceTransDTO.getItemId() + " and invoiceId = '" + invoiceTransDTO.getInvoiceId() + "'");
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}
	
//	public static void main(String[] args) {
//		InvoiceTransDAOImpl i =  new InvoiceTransDAOImpl();
//		InvoiceTransDTO it =InvoiceTransDTO.getInvoiceTransDTO();
////		System.out.println(i.findByID(1, "I0001"));
//		i.findAll();
//		i.setInvoicrTransData(it, 666, "desc", 12);
//		i.insertItem(it);
//		i.findAll();
		
//		i.setInvoicrTransData(it, "desc", 666, 88);
//		System.out.println(i.findByID(666, "desc"));
		
//		i.deleteItemByID(666, "desc");
//		i.findAll();
//	}

}
