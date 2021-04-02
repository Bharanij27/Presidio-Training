package day19;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day18.DBUtility;

public class InvoiceMasterDTOImpl implements InvoiceMasterDAO{

	public void setIncvoiceMasterData(InvoiceMasterDTO invoice, String id, Date date, int cid){		
		invoice.setInvoiceId(id);
		invoice.setInvoiceDate(date);
		invoice.setCustomerId(cid);
	}
	
	@Override
	public InvoiceMasterDTO findByID(Integer invoiceId) {
		InvoiceMasterDTO invoiceMaster = null;
		
		try {
			invoiceMaster = InvoiceMasterDTO.getInvoiceMasterDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement st = con.prepareStatement("select * from invoiceMaster where invoiceId=?");
			
			st.setInt(1, invoiceId);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {				
				setIncvoiceMasterData(invoiceMaster, rs.getString(1), rs.getDate(2), rs.getInt(3));
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}

//		System.out.println(invoiceMaster);
		return invoiceMaster;
	}

	@Override
	public List<InvoiceMasterDTO> findAll() {
		List<InvoiceMasterDTO> invoiceArray = null;
		
		try {
			invoiceArray = new ArrayList<InvoiceMasterDTO>();
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from invoiceMaster");
			while(rs.next()) {		
				InvoiceMasterDTO invoiceMaster = InvoiceMasterDTO.getInvoiceMasterDTO();
				setIncvoiceMasterData(invoiceMaster, rs.getString(1), rs.getDate(2), rs.getInt(3));
				invoiceArray.add(invoiceMaster);
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		
//		invoiceArray.forEach(c -> {
//			System.out.println(c);
//		});
		return invoiceArray;
	}

	@Override
	public int insertItem(InvoiceMasterDTO invoiceMasterDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			int cid = invoiceMasterDTO.getCustomerId();
			Date invoiceDate = invoiceMasterDTO.getInvoiceDate();
			String invoiceId =  invoiceMasterDTO.getInvoiceId();
			
			i = st.executeUpdate("insert into invoiceMaster values ('" + invoiceId + "','" + invoiceDate + "'," + cid + ")");
			System.out.println(i +" rows inserted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int updateItem(InvoiceMasterDTO invoiceMasterDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
//			int cid = invoiceMasterDTO.getCustomerId();
			Date invoiceDate = invoiceMasterDTO.getInvoiceDate();
			String invoiceId =  invoiceMasterDTO.getInvoiceId();
			
			i = st.executeUpdate("update invoiceMaster set invoiceDate = '" + invoiceDate + "'" + " where invoiceId = " + invoiceId);
			System.out.println(i +" rows updated....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByID(Integer invoiceMasterDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from invoiceMaster where invoiceId = " + invoiceMasterDTO);
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByDTO(InvoiceMasterDTO invoiceMasterDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from invoiceMaster where invoiceId = " + invoiceMasterDTO.getInvoiceId());
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

}
