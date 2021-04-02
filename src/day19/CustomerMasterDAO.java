package day19;

import java.util.List;

public interface CustomerMasterDAO {
	public CustomerDTO findByID(Integer customerId);
	public List<CustomerDTO> findAll();
	public int insertItem(CustomerDTO customerDTO);
	public int updateItem(CustomerDTO customerDTO);
	public int deleteItemByID(Integer customerId);
	public int deleteItemByDTO(CustomerDTO customerDTO);
}
