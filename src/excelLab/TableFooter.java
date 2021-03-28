package excelLab;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;


public class TableFooter {
	
	public void getFooter(XSSFSheet sheet) {
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

	public void setFooter(XSSFSheet sheet, int rownum, double totalPrice, double discount, double tax, double extraCharge) {
		Map<String, String> footerValue = setFooterValue(totalPrice, discount, tax, extraCharge);
		
		for(Map.Entry<String, String> entry: footerValue.entrySet()) {
			Row row = sheet.createRow(rownum++);
			Cell desc = row.createCell(2);
			desc.setCellValue(entry.getKey());
			
			Cell val = row.createCell(3);
			val.setCellValue(entry.getValue());
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
		}
	}

	private Map<String, String> setFooterValue(double totalPrice, double discount, double tax, double extraCharge) {
		Map<String, String> footerValue = new LinkedHashMap<String, String>();
		DecimalFormat d = new DecimalFormat("#.##");
		
		footerValue.put("SubTotal", String.format("%.2f", totalPrice));
		footerValue.put("Discount", String.format("%.2f", discount));
		
		double subtotal =totalPrice + (totalPrice * (discount / 100));
		footerValue.put("SubTotal Less Discount", String.format("%.2f", subtotal));
		
		
		footerValue.put("Tax Rate", String.format("%.2f", tax));
		double totalAfterTax = subtotal + (subtotal * (tax / 100));
		footerValue.put("Tax Rate", String.format("%.2f", totalAfterTax));
		
		footerValue.put("Shipping/Handling", String.format("%.2f", extraCharge));
		
		double balance = subtotal + extraCharge;
		footerValue.put("Balance", String.format("%.2f", balance));

		return footerValue;
	}
	
	
}
