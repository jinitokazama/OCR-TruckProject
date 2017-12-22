package tessexample;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcel {
	
	public static void createExcel(ArrayList<TableEntry> theTableEntryList, String theName) throws FileNotFoundException, IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Trucks Washed");
		HSSFRow headerRow = sheet.createRow(0);
		
		//creates the header for the Truck number column
		HSSFCell truckIDCell = headerRow.createCell(0);
		truckIDCell.setCellValue("Truck #");
		
		//creates the header for the Washed? column
		HSSFCell washedCell = headerRow.createCell(1);
		washedCell.setCellValue("Washed?");
		
		//fills the sheet with the table entries
		for (int i = 0; i < theTableEntryList.size(); i++) {
			HSSFRow row = sheet.createRow(i + 1);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(theTableEntryList.get(i).getId());
			if(theTableEntryList.get(i).isChecked()) {
				row.createCell(1).setCellValue("X");
			} else {
				row.createCell(1).setCellValue("");
			}		
		}
		
		//auto sizes the columns
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		
		//creates an excel file with the information in the sheet
		workbook.write(new FileOutputStream(removeFileExtension(theName)));
		workbook.close();
	}
	
	public static String removeFileExtension(String theName) {
		String fileName = theName.substring(0, theName.indexOf('.')) + ".xls";
		return fileName;
	}

}
