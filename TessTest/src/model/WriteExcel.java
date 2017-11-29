package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.TableEntry;

public class WriteExcel {

	public static void createExcel(ArrayList<TableEntry> theTableEntryList) throws FileNotFoundException, IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Trucks Washed");
		for (int i = 0; i < theTableEntryList.size(); i++) {
			HSSFRow row = sheet.createRow(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(theTableEntryList.get(i).getId());
			if(theTableEntryList.get(i).isChecked()) {
				row.createCell(1).setCellValue("X");
			} else {
				row.createCell(1).setCellValue("");
			}		
		}
		
		
		workbook.write(new FileOutputStream("excel.xls"));
		workbook.close();
	}

}
