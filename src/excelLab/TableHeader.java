package excelLab;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class TableHeader {
	public void setHeader(XSSFSheet wb) {
		String [] obj = {"Description", "QTY", "Unit Price", "Total Price"};
		Row row = wb.createRow(0);
		int colnum = 0;
		for(String str : obj) {
			Cell cell = row.createCell(colnum++);
			cell.setCellValue(str);
		}
	}
	
	public void getHeader(XSSFSheet sheet) {
			Iterator<Row> rowIterator = sheet.iterator();
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                System.out.println(cell.getStringCellValue());
            }
	}
}
