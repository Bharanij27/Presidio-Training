package excelLab;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.Naming;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;


public class ExcelToPDF implements Serializable{
	public static void main(String[] args) throws Exception 
    {   
        try
	    {
        	PdfConverter excelConverter = (PdfConverter)Naming.lookup("rmi://localhost:5000/rmiservice/PdfConverter");
        	byte[] bs = excelConverter.createExcel();
        	InputStream inputStream = new ByteArrayInputStream(bs);

//        	byte[] source = excelConverter.createExcel();
//        	ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        	// write bytes to bos ...
//        	byte[] sink = bos.toByteArray();        	
//        	ByteArrayInputStream bis = new ByteArrayInputStream(source);
//        	InputStream stream = new ByteArrayOutputStream(bs);

 
	        //Write the workbook in file system
        	XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	        FileOutputStream out = new FileOutputStream(new File("invoice.xlsx"));
	        workbook.write(out);
	        out.close();
	        System.out.println("invoice.xlsx written successfully on disk.");
	        convertToPDF();
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
    }
	
	public static void convertToPDF() throws Exception {
		Workbook workbook = new Workbook("invoice.xlsx");
		workbook.save("Excel-to-PDF.pdf", SaveFormat.PDF); 	// Save the document in PDF format
	}
}