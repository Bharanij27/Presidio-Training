package excelLab;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcel {
	public XSSFWorkbook create() throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(); 
        
        //Create a blank sheet
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
        
        new AutoFit().fit(workbook);
        return workbook;
	}
}
