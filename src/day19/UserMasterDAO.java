package day19;

import java.util.List;

public interface UserMasterDAO {
	public UserDTO findByID(Integer userId);
	public List<UserDTO> findAll();
	public int insertItem(UserDTO userDTO);
	public int updateItem(UserDTO userDTO);
	public int deleteItemByID(Integer userId);
	public int deleteItemByDTO(UserDTO userDTO);
}
