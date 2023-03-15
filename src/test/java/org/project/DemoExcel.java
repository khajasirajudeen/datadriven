package org.project;

import java.io.IOException;

import org.utility.UtilClass;

public class DemoExcel extends UtilClass {
	public static void main(String[] args) throws IOException {
		
//		QUESTION 4
//		----------
//		URL : https://demoqa.com/registration/
//
//		NOTE: Create an excel sheet with all required details for registration . 
		
		
		writeExcelInNewRow("demoexcel", 0, 0, "First Name ");
		writeExcelInExistingRow("demoexcel", 0, 1, "khaja");
		
		writeExcelInNewRow("demoexcel", 1, 0, "Last Name");
		writeExcelInExistingRow("demoexcel", 1, 1, "sirajudeen");

		writeExcelInNewRow("demoexcel", 2, 0, "Email ");
		writeExcelInExistingRow("demoexcel", 2, 1, "khaja@gmail.com");
		
		writeExcelInNewRow("demoexcel", 3, 0, "Mobile");
		writeExcelInExistingRow("demoexcel", 3, 1, "9876543210");
		
		writeExcelInNewRow("demoexcel", 4, 0, "DOB");
		writeExcelInExistingRow("demoexcel", 4, 1, "20-Feb-23");
		
		writeExcelInNewRow("demoexcel", 5, 0, "Subject ");
		writeExcelInExistingRow("demoexcel", 5, 1, "java");

		writeExcelInNewRow("demoexcel", 6, 0, "Address");
		writeExcelInExistingRow("demoexcel", 6, 1, "chennai");
		
	
}
}