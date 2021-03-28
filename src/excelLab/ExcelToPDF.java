package excelLab;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.aspose.cells.SaveFormat;


public class ExcelToPDF {
	public static void main(String[] args) throws Exception 
    {   
		XSSFWorkbook workbook = new CreateExcel().create();
        try
	    {
	        //Write the workbook in file system
	        FileOutputStream out = new FileOutputStream(new File("invoice.xlsx"));
	        workbook.write(out);
	        out.close();
	        System.out.println("invoice.xlsx written successfully on disk.");
	        ConvertToPDF obj = new ConvertToPDF();
	        obj.convert();
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
    }
}