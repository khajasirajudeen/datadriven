package org.project;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utility.UtilClass;

public class Demoqa_Registration extends UtilClass {
public static void main(String[] args) throws IOException {
	
//	QUESTION 8
//	-----------
//	URL : https://demoqa.com/registration/
//
//	NOTE: Create an excel sheet with all required details for registration . 
//	      Register the form by getting the input data  from excel sheet using DataDriven and execute in maven.

	browserLanch("chrome");
	maxiWindow();
	urlLanch("https://demoqa.com/automation-practice-form");
	
	WebElement firstName = driver.findElement(By.id("firstName"));
	javaScriptPasVal(firstName, getParDataFromExcel("demo", 0, 1));
	
	WebElement lastName = driver.findElement(By.id("lastName"));
	javaScriptPasVal(lastName, getParDataFromExcel("demo", 1, 1));
	
	WebElement userEmail = driver.findElement(By.id("userEmail"));
	javaScriptPasVal(userEmail, getParDataFromExcel("demo", 2, 1));

	WebElement male = driver.findElement(By.id("gender-radio-1"));
	javaScriptClick(male);

	WebElement mobile = driver.findElement(By.id("userNumber"));
	javaScriptPasVal(mobile, getParDataFromExcel("demo", 3, 1));
	
	WebElement dOB = driver.findElement(By.id("dateOfBirthInput"));
	javaScriptClick(dOB);
	WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
	javaScriptClick(year);
	dropDownValue(year, "1994");
	
	WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
	javaScriptClick(month);
	dropDownValue(month, "5");
	
	WebElement day = driver.findElement(By.xpath("//div[text()='23']"));
	javaScriptClick(day);
	
	WebElement sport = driver.findElement(By.id("hobbies-checkbox-1"));
	javaScriptClick(sport);
	
	WebElement subject = driver.findElement(By.id("subjectsContainer"));
	javaScriptPasVal(subject, getParDataFromExcel("demo", 5, 1));
	
	WebElement address = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
	pasVal(address, getParDataFromExcel("demo", 6, 1));

	WebElement dd = driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[1]"));
	List<WebElement> alldd = dd.findElements(By.xpath("//div[text()='Select State']"));
	WebElement sta = alldd.get(0);
	javaScriptClick(sta);

	
	
//	WebElement state = driver.findElement(By.id("state"));
//	WebElement june = driver.findElement(By.xpath("//option[@value='5']"));
//	javaScriptPasVal(d.getFirstname(), getParDataFromExcel("domoform", 0, 1)); // "khaja"
//	javaScriptPasVal(d.getLastName(), getParDataFromExcel("domoform", 1, 1)); // "sirajudeen"
//	javaScriptPasVal(d.getEmail(), getParDataFromExcel("domoform", 2, 1)); // "khaja@gmail.com"/
//	javaScriptClick(d.getMale());
//	javaScriptPasVal(d.getMobile(), getParDataFromExcel("domoform", 3, 1)); // "9876543210"
//	javaScriptPasVal(d.getdOB(), getParDataFromExcel("domoform", 4, 1)); // "20 Feb 2023"
//	javaScriptClick(d.getdOB());
//	javaScriptClick(d.getYear());
//	dropDownValue(d.getYear(), "1994");
//	javaScriptClick(d.getMonth());
//	dropDownValue(d.getMonth(), "5");
//	javaScriptClick(d.getDay());
//	javaScriptClick(d.getSport());
//	javaScriptPasVal(d.getSubject(), getParDataFromExcel("domoform", 5, 1)); // "JAVA"
//	javaScriptPasVal(d.getAddress(), getParDataFromExcel("domoform", 6, 1)); // "chennai"
//	pasVal(d.getAddress(), getParDataFromExcel("domoform", 6, 1));
//	WebElement dd = driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[1]"));
//	List<WebElement> alldd = dd.findElements(By.xpath("//div[text()='Select State']"));
//	WebElement sta = alldd.get(0);
//	javaScriptClick(sta);
}
}
