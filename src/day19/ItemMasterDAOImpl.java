package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day18.DBUtility;

public class ItemMasterDAOImpl implements ItemMasterDAO{
	
	public void setItemData(ItemDTO item, int id, String desc, float price){		
		item.setItemid(id);
		item.setItemDesc(desc);
		item.setPrice(price);
	}

	@Override
	public ItemDTO findByID(Integer itemid) {
		ItemDTO item = null;
		
		try {
			item = ItemDTO.getItemDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement st = con.prepareStatement("select * from itemMaster where itemId=?");
			
			st.setInt(1, itemid);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {				
				setItemData(item, rs.getInt(1), rs.getString(2), rs.getFloat(3));
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}

//		System.out.println(item);
		return item;
	}

	@Override
	public List<ItemDTO> findAll() {
		List<ItemDTO> itemArray = null;
		
		try {
			itemArray = new ArrayList<ItemDTO>();
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from itemMaster");
			while(rs.next()) {		
				ItemDTO item = ItemDTO.getItemDTO();
				setItemData(item, rs.getInt(1), rs.getString(2), rs.getFloat(3));
				itemArray.add(item);
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		
//		itemArray.forEach(c -> {
//			System.out.println(c);
//		});
		return itemArray;
	}

	@Override
	public int insertItem(ItemDTO itemDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			int id = itemDTO.getItemid();
			String desc = itemDTO.getItemDes();
			float price =  itemDTO.getPrice();

			i = st.executeUpdate("insert into itemMaster values (" + id + ",'" + desc + "'," + price + ")");
			System.out.println(i +" rows inserted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int updateItem(ItemDTO itemDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			int id = itemDTO.getItemid();
			String desc = itemDTO.getItemDes();
			float price =  itemDTO.getPrice();
			
			i = st.executeUpdate("update itemMaster set itemDesc = '" + desc + "', price = " + price + " where itemId = " + id);
			System.out.println(i +" rows updated....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByID(Integer itemid) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from itemMaster where itemId = " + itemid);
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByDTO(ItemDTO itemDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from itemMaster where itemId = " + itemDTO.getItemid());
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}
	
//	public static void main(String[] args) {
//		System.out.println(new ItemMasterDAOImpl().findByID(1));
//		ItemMasterDAOImpl i = new ItemMasterDAOImpl();
//		
//		ItemDTO item = ItemDTO.getItemDTO();
//		i.setItemData(item, 7, "aaaa", 20);
//		i.insertItem(item);
//		i.findAll();
//		
//		i.setItemData(item, 7, "bbb", 200);
//		i.updateItem(item);
//		System.out.println(i.findByID(7));
//		i.deleteItemByDTO(item);
//		i.findAll();
//	}
	
}
