package day19;

import java.util.List;

public interface InvoiceMasterDAO {
	public InvoiceMasterDTO findByID(Integer invoiceId);
	public List<InvoiceMasterDTO> findAll();
	public int insertItem(InvoiceMasterDTO invoiceMasterDTO);
	public int updateItem(InvoiceMasterDTO invoiceMasterDTO);
	public int deleteItemByID(Integer invoiceMasterDTO);
	public int deleteItemByDTO(InvoiceMasterDTO invoiceMasterDTO);
}
