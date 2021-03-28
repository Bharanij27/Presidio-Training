package excelLab;

import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
public class ConvertToPDF {
	public void convert() throws Exception{
		Workbook workbook = new Workbook("invoice.xlsx");
		// Save the document in PDF format
		workbook.save("Excel-to-PDF.pdf", SaveFormat.PDF);
	}
}
