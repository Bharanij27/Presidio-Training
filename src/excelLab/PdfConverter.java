package excelLab;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface PdfConverter extends Remote{ 
	public byte[] createExcel() throws Exception;
	public void autoFit(XSSFWorkbook workbook) throws RemoteException;
}
