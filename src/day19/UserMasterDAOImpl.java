package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day18.DBUtility;

public class UserMasterDAOImpl implements UserMasterDAO{

	public void setUserData(UserDTO user, int id, String name, String password, int flag){		
		user.setUserId(id);
		user.setUserName(name);
		user.setPassword(password);
		user.setFlag(flag);
	}
	
	@Override
	public UserDTO findByID(Integer userId) {
		UserDTO user = null;
		
		try {
			user = UserDTO.getUserDTO();
			Connection con = DBUtility.getConnection();
			PreparedStatement st = con.prepareStatement("select * from user where userId=?");
			
			st.setInt(1, userId);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {				
				setUserData(user, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}

//		System.out.println(user);
		return user;
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> userArray = null;
		
		try {
			userArray = new ArrayList<UserDTO>();
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from user");
			while(rs.next()) {		
				UserDTO user = UserDTO.getUserDTO();
				setUserData(user, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				userArray.add(user);
			}
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		
//		userArray.forEach(c -> {
//			System.out.println(c);
//		});
		return userArray;
	}

	@Override
	public int insertItem(UserDTO userDTO) {
	
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			int id = userDTO.getUserId();
			String name = userDTO.getUserName();
			String password =  userDTO.getPassword();
			int flag = userDTO.getFlag();

			i = st.executeUpdate("insert into user values (" + id + ",'" + name + "','" + password + "'," + flag + ")");
			System.out.println(i +" rows inserted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int updateItem(UserDTO userDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			
			int id = userDTO.getUserId();
			String name = userDTO.getUserName();
			String password =  userDTO.getPassword();
			int flag = userDTO.getFlag();
			
			i = st.executeUpdate("update user set userName = '" + name + "', password = '" + password + "', flag = " + flag + " where userId = " + id);
			System.out.println(i +" rows updated....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByID(Integer userId) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from user where userId = " + userId);
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}

	@Override
	public int deleteItemByDTO(UserDTO userDTO) {
		int i = 0;
		
		try {
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();

			i = st.executeUpdate("delete from user where userId = " + userDTO.getUserId());
			System.out.println(i +" rows deleted....");
			
			DBUtility.closeConnection(null, null);
			
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		return i;
	}
	
//	public static void main(String[] args) {
//		UserMasterDAOImpl u = new UserMasterDAOImpl();
//		UserDTO us = UserDTO.getUserDTO();
//		u.setUserData(us, 2, "n", "pass", 0);
//		u.insertItem(us);
//		u.findAll();
//		
//		u.setUserData(us, 2, "name", "passsssss", 1);
//		u.updateItem(us);
//		u.findByID(2);
//		
//		u.deleteItemByID(2);
//		u.findAll();
//	}
	
}
