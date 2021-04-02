package day19;

import java.util.List;

public interface InvoiceTransDAO {
	public InvoiceTransDTO findByID(Integer itemId, String invoiceId);
	public List<InvoiceTransDTO> findAll();
	public int insertItem(InvoiceTransDTO invoiceTransDTO);
	public int updateItem(InvoiceTransDTO invoiceTransDTO);
	public int deleteItemByID(Integer itemId, String invoiceId);
	public int deleteItemByDTO(InvoiceTransDTO invoiceTransDTO);
}
