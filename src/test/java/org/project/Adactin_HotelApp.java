package org.project;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utility.UtilClass;

public class Adactin_HotelApp extends UtilClass{
public static void main(String[] args) throws IOException {

//	QUESTION 10
//	--------------
//	URL :  http://www.adactin.com/HotelApp/
//
//	NOTE: Create an excel sheet with all details required for Hotel Booking .
//	      Create a maven project. 
//	      Book a hotel using above url by getting the input data  from excel sheet.
//	      Update the orderNo generated after hotel booking in excel sheet using DataDriven.
	
	browserLanch("chrome");
	maxiWindow();
	urlLanch("http://www.adactin.com/HotelApp/");
	impWait(5);
	WebElement username = driver.findElement(By.id("username"));
	pasVal(username, getParDataFromExcel("adactin", 0, 1));
	
	WebElement password = driver.findElement(By.id("password"));
	pasVal(password, getParDataFromExcel("adactin", 1, 1));
	
	WebElement login = driver.findElement(By.id("login"));
	mouseClickElement(login);
	
	WebElement location = driver.findElement(By.id("location"));
	dropDownIndex(location, 2);
	
	WebElement hotels = driver.findElement(By.id("hotels"));
	dropDownIndex(hotels, 2);
	
	WebElement room_type = driver.findElement(By.id("room_type"));
	dropDownIndex(room_type, 2);
	
	WebElement room_nos = driver.findElement(By.id("room_nos"));
	dropDownIndex(room_nos, 2);
	
	WebElement datepick_in = driver.findElement(By.id("datepick_in"));
	pasVal(datepick_in, getParDataFromExcel("adactin", 6, 1));
	
	WebElement datepick_out = driver.findElement(By.id("datepick_out"));
	pasVal(datepick_out, getParDataFromExcel("adactin", 7, 1));
	
	WebElement adult_room = driver.findElement(By.id("adult_room"));
	dropDownIndex(adult_room, 2);
	
	WebElement child_room = driver.findElement(By.id("child_room"));
	dropDownIndex(child_room, 2);
	
	WebElement Submit = driver.findElement(By.id("Submit"));
	mouseClickElement(Submit);
	
	WebElement radiobuttonclick = driver.findElement(By.id("radiobutton_0"));
	mouseClickElement(radiobuttonclick);
	
	WebElement hotelconfirm = driver.findElement(By.id("continue"));
	mouseClickElement(hotelconfirm);
	
	WebElement first_name = driver.findElement(By.id("first_name"));
	pasVal(first_name, getParDataFromExcel("adactin", 10, 1));
	
	WebElement last_name = driver.findElement(By.id("last_name"));
	pasVal(last_name, getParDataFromExcel("adactin", 11, 1));
	
	WebElement address = driver.findElement(By.id("address"));
	pasVal(address, getParDataFromExcel("adactin", 12, 1));
	
	WebElement cc_num = driver.findElement(By.id("cc_num"));
	pasVal(cc_num, getParDataFromExcel("adactin", 13, 1));
	
	WebElement cc_type = driver.findElement(By.id("cc_type"));
	dropDownIndex(cc_type, 1);
	
	WebElement cc_exp_month = driver.findElement(By.id("cc_exp_month"));
	dropDownIndex(cc_exp_month, 6);
	
	WebElement cc_exp_year = driver.findElement(By.id("cc_exp_year"));
	dropDownIndex(cc_exp_year, 9);
	
	WebElement cc_cvv = driver.findElement(By.id("cc_cvv"));
	pasVal(cc_cvv, getParDataFromExcel("adactin", 18, 1));
	
	WebElement book_now = driver.findElement(By.id("book_now"));
	mouseClickElement(book_now);
	
	WebElement order_no = driver.findElement(By.id("order_no"));
	String attribute = order_no.getAttribute("value");
	System.out.println(attribute);
	
	writeExcelInExistingRow("adactin", 19, 1, attribute); 
}
}
