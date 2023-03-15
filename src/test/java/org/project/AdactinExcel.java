package org.project;

import java.io.IOException;

import org.utility.UtilClass;

public class AdactinExcel extends UtilClass {
public static void main(String[] args) throws IOException {
	
//	QUESTION 5
//	URL :  http://www.adactin.com/HotelApp/
//	NOTE: Create an excel sheet with all details required for Hotel Booking .
	
	
	writeExcelInNewRow("registration", 0, 0, "UserID ");
	writeExcelInExistingRow("registration", 0, 1, "manivasagam966");
	
	writeExcelInNewRow("registration", 1, 0, "Password");
	writeExcelInExistingRow("registration", 1, 1, "8610971286k");

	writeExcelInNewRow("registration", 2, 0, "Location ");
	writeExcelInExistingRow("registration", 2, 1, "2");
	
	writeExcelInNewRow("registration", 3, 0, "Hotels");
	writeExcelInExistingRow("registration", 3, 1, "2");
	
	writeExcelInNewRow("registration", 4, 0, "Room Type");
	writeExcelInExistingRow("registration", 4, 1, "2");
	
	writeExcelInNewRow("registration", 5, 0, "Number of Rooms");
	writeExcelInExistingRow("registration", 5, 1, "2");

	writeExcelInNewRow("registration", 6, 0, "Check In Date");
	writeExcelInExistingRow("registration", 6, 1, "23-02-2023");
	
	writeExcelInNewRow("registration", 7, 0, "Check Out Date");
	writeExcelInExistingRow("registration", 7, 1, "24-02-2023");
	
	writeExcelInNewRow("registration", 8, 0, "Adults per Room");
	writeExcelInExistingRow("registration", 8, 1, "2");
	
	writeExcelInNewRow("registration", 9, 0, "Children per Room");
	writeExcelInExistingRow("registration", 9, 1, "2");

	writeExcelInNewRow("registration", 10, 0, "First Name");
	writeExcelInExistingRow("registration", 10, 1, "khaja");
	
	writeExcelInNewRow("registration", 11, 0, "Last Name");
	writeExcelInExistingRow("registration", 11, 1, "sirajudeen");
	
	writeExcelInNewRow("registration", 12, 0, "Billing Address");
	writeExcelInExistingRow("registration", 12, 1, "chennai");
	
	writeExcelInNewRow("registration", 13, 0, "Credit Card No");
	writeExcelInExistingRow("registration", 13, 1, "4220422042204220");

	writeExcelInNewRow("registration", 14, 0, "Credit Card Type");
	writeExcelInExistingRow("registration", 14, 1, "1");
	
	writeExcelInNewRow("registration", 15, 0, "Expiry Date");
	writeExcelInExistingRow("registration", 15, 1, "1");
	
	writeExcelInNewRow("registration", 16, 0, "Select Month");
	writeExcelInExistingRow("registration", 16, 1, "6");
	
	writeExcelInNewRow("registration", 17, 0, "Select Year");
	writeExcelInExistingRow("registration", 17, 1, "9");
	
	writeExcelInNewRow("registration", 18, 0, "CVV Number");
	writeExcelInExistingRow("registration", 18, 1, "654");
	
	writeExcelInNewRow("registration", 19, 0, "Hotels");
	writeExcelInExistingRow("registration", 19, 1, "Order NO");
	
}

}
