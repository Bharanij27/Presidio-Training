package excelLab;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

public class ExcelServer extends UnicastRemoteObject implements PdfConverter{
	NewWorkBook wb;
	public ExcelServer() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public byte[] createExcel() throws Exception {
		wb  = new NewWorkBook();
		XSSFWorkbook workbook = wb.getWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Invoice");
	        
	    int productCount = 0;
	    Map<Integer, Object> data = new TreeMap<Integer, Object>();
	    data.put(productCount++, new Object[] {"Web Design", 1, 1000.00});
	    data.put(productCount++, new Object[] {"Logo Design", 2, 420.0});
	    data.put(productCount++, new Object[] {"Animation Video", 1, 399.90});
	    data.put(productCount++, new Object[] {"Image Editing", 3, 450.00});
	        
	    TableHeader header = new TableHeader();
	    header.setHeader(sheet);
	        
	    double totalPrice = 0;
	        //Iterate over data and write to sheet
	    Set<Integer> keyset = data.keySet();
	    int rownum = 1;
	    for (Integer key : keyset)
	    {
	    	Row row = sheet.createRow(rownum++);
	        Object [] objArr = (Object[]) data.get(key);
	        int cellnum = 0;
		    for (int i = 0; i < objArr.length; i++)
		    {
		    	Object obj = objArr[i];
		        Cell cell = row.createCell(cellnum++);
		        cell.setCellValue(obj.toString());
		        if(i == objArr.length - 1) {
		        	Cell totalCol = row.createCell(cellnum++);
		        	double qty = (int)objArr[1];
		        	double price = (double)objArr[i];
		        	double total = qty * price;
		        	totalCol.setCellValue(Double.toString(total));
		        	totalPrice += total;
		       	}
		     }
		 }
	        
	     TableFooter tf = new TableFooter();
	     tf.setFooter(sheet, rownum, totalPrice, 10, 5, 100);
	        
	     autoFit(workbook);
	     System.out.println(11);
	     ByteArrayOutputStream bos = new ByteArrayOutputStream();
	     workbook.write(bos);
	     return bos.toByteArray();
	}
	
	@Override
	public void autoFit(XSSFWorkbook workbook) throws RemoteException {
		XSSFSheet sheet = workbook.getSheetAt(0);
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println(colCount);
		for(int i = 0; i < colCount; i++) {
			sheet.autoSizeColumn(i);
		}    
    }
	
	public static void main(String[] args) throws Exception {
		ExcelServer excel = new ExcelServer();
		LocateRegistry.createRegistry(4070);		
		
		System.out.println("Server Ready....");
		Naming.bind("rmi://localhost:4070/rmiservice/PdfConverter", excel);
	}
	
}

class NewWorkBook implements Serializable{
	public XSSFWorkbook workbook;
	
	public XSSFWorkbook getWorkbook() {
		return workbook;
	}

	public NewWorkBook() {
		XSSFWorkbook wb  = new XSSFWorkbook(); 
		this.workbook = wb;
	}
	
	
}
