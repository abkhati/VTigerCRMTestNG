package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//import com.google.common.collect.Table.Cell;

public class ExcelUtils {

	
	
       public String  getDataFromExcelFile(String sheetName, int rowno, int cellno ) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("src\\test\\resources\\FrameWork.xlsx");
		Workbook wb =  WorkbookFactory.create(file);
		
		Sheet sh = wb.getSheet("Sheet1");
		Row row  = sh.getRow(rowno);
		Cell cell = row.getCell(cellno);
		
		return cell.getStringCellValue();		
	}
	
}
