package tessexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.TableEntry;
import model.WriteExcel;
import net.sourceforge.tess4j.*;

public class TessMain {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File imageFile = new File("ExcelDemo5.png");
		ITesseract instance = new Tesseract();
		
		ArrayList<TableEntry> entryList = new ArrayList<TableEntry>(); // This entrylist will contain the table entries
		ArrayList<String> strings = new ArrayList<String>();
		
		String result = null;
		String[] arr;
		
		try {
			result = instance.doOCR(imageFile);         //The method here returns a string representing the image we scanned.
			System.out.println(result);
			
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
		
//		arr = result.split("\\n");               //Here I break up the string for each row of the table
//		for (String s : arr) {
//			
//			try {
//				s.charAt(0);
//				strings.add(s);
//			} catch (Exception e) {           //So, for some reason tesseract was padding space with empty strings 
//				                              //(which makes no damn sense btw) 
//			}                                 //I remove them here so they don't screw with trying to make the table entries
//
//	    }
//		
//		//System.out.println(strings);
//		
//		for (String s : strings) {                   //Making the table entries and throwing them into an arraylist.
//			if (s.charAt(0) == 'X') {
//				entryList.add(new TableEntry(s.substring(2), true));
//				
//			} else {
//				entryList.add(new TableEntry(s));
//			}
//		}
//		
//		WriteExcel.createExcel(entryList);
//		for (TableEntry t : entryList) {
//			System.out.println(t.getId() + ": " + t.isChecked() + "!");        //This block here just prints out the table entries and whether
//		}                                                                      //they've been checked or not

	}

}
