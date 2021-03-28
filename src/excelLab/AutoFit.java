package excelLab;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AutoFit {
	public void fit(XSSFWorkbook workbook) throws Exception {
		XSSFSheet sheet = workbook.getSheetAt(0);
        
        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println(colCount);
        for(int i = 0; i < colCount; i++) {
        	sheet.autoSizeColumn(i);
        }
        
	}
}
