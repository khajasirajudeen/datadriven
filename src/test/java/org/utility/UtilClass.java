package org.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilClass {
	// Static Variable ---------------------------------------------------------

	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static JavascriptExecutor j;
	public static Alert at;

	// WebDriverManager Methods-------------------------------------------------

	public static void browserLanch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Lanch Successfully");
		}
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser Lanch Successfully");
		}
		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge Browser Lanch Successfully");
		}
	}

	// driver methods---------------------------------------------------------

	public static void maxiWindow() {
		driver.manage().window().maximize();
	}

	public static void urlLanch(String url) {
		driver.get(url);
	}

	public static void getcurrentPageTitle() {
		String currenttitle = driver.getTitle();
		System.out.println(currenttitle);
	}

	public static void getcurrenPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void pasVal(WebElement ele, String val) {
		ele.sendKeys(val);
	}

	public static void getAttval(WebElement ele, String val) {
		String attribute = ele.getAttribute(val);
		System.out.println(attribute);
	}

	public static void getText(WebElement ele) {
		String text = ele.getText();
		System.out.println(text);
	}

	public static void display(WebElement ele) {
		boolean displayed = ele.isDisplayed();
		System.out.println(displayed);
	}

	public static void eneble(WebElement ele) {
		boolean enabled = ele.isEnabled();
		System.out.println(enabled);
	}

	// Actions class methods-------------------------------------------------
	
	public static void mouseClick() {
		a = new Actions(driver);
		a.click().perform();
	}

	public static void mouseClickElement(WebElement ele) {
		a = new Actions(driver);
		a.click(ele).perform();
	}

	public static void mouseRightClick(WebElement ele) {
		a = new Actions(driver);
		a.contextClick(ele).perform();
	}

	public static void mouseDoubleClick(WebElement ele) {
		a = new Actions(driver);
		a.doubleClick(ele).perform();
	}

	public static void mouseMove(WebElement ele) {
		a = new Actions(driver);
		a.moveToElement(ele).perform();
	}

	public static void dragDrop(WebElement source, WebElement target) {
		a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	// Java Script Executor Methods--------------------------------------------

	public static void javaScriptClick(WebElement ele) {
		j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()", ele);
	}

	public static void javaScriptScroll(WebElement ele,String val) {
		j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(" + val + ")", ele);
	}

	public static void javaScriptPasVal(WebElement ele,String val) {
		j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].setAttribute('value','" + val + "')", ele);
	}

	public static void javaScriptGetVal(WebElement ele,String val) {
		j = (JavascriptExecutor) driver;
		Object text = j.executeScript("return arguments[0].getAttribute('value',)", ele);
		System.out.println(text);
	}

	// Windows
	// Handel-----------------------------------------------------------------------------------

	// single window handel
	public static void windowsHandel() {

		String parentwindow = driver.getWindowHandle();

		Set<String> allWindowsId = driver.getWindowHandles();

		for (String itrId : allWindowsId) {
			if (itrId != parentwindow) {
				driver.switchTo().window(itrId);
			}
		}
	}

	// multiple window handel

	// public static void multipleWindowsHande() {
	// Set<String> allWindowsId = driver.getWindowHandles();
	// List<String> l = new ArrayList<String>;
	// }

	// Alert Class
	// Methods------------------------------------------------------------------------------

	public static void alertAccept() {
		Alert at = driver.switchTo().alert();
		at.accept();
	}

	public static void alertDismiss() {
		Alert at = driver.switchTo().alert();
		at.dismiss();
	}

	public static void alertGetText() {
		Alert at = driver.switchTo().alert();
		System.out.println(at.getText());
	}

	public static void alertSendKeys(String val) {
		Alert at = driver.switchTo().alert();
		at.sendKeys(val);
	}

	// Drop
	// Down---------------------------------------------------------------------------------

	public static void dropDownIndex(WebElement ele, int indexno) {
		Select s = new Select(ele);
		s.selectByIndex(indexno);
	}

	public static void dropDownValue(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}

	public static void dropDownVisibleText(WebElement ele, String visibletext) {
		Select s = new Select(ele);
		s.selectByVisibleText(visibletext);
	}

	public static void dropDownGetOptions(WebElement ele) {
		Select s = new Select(ele);
		List<WebElement> options = s.getOptions();
	}

	public static void dropDownGetOptions(WebElement ele, int val) {
		Select s = new Select(ele);
		List<WebElement> options = s.getOptions();
		WebElement webElement = options.get(val);
		System.out.println(webElement.getText());
	}

	// File
	// Operation............................................................................

	public static void checkFilePath(String path) {
		File f = new File(path);
		boolean directory = f.isDirectory();
		System.out.println(directory);
	}

	public static void fileCreate(String path) throws IOException {
		File f = new File(path);
		boolean newfile = f.createNewFile();
		System.out.println(newfile);
	}

	public static void createFolder(String path) {
		File f = new File(path);
		boolean mainfolder = f.mkdir();
		System.out.println(mainfolder);
	}

	public static void createInsideFolder(String path) {
		File f = new File(path);
		boolean insidefilder = f.mkdirs();
		System.out.println(insidefilder);
	}

	public static void checkDirectory(String path) {
		File f = new File(path);
		boolean directory = f.isDirectory();
		System.out.println(directory);
	}

	public static void checkFile(String path) {
		File f = new File(path);
		boolean file = f.isFile();
		System.out.println(file);
	}

	public static void CheckFileHidden(String path) {
		File f = new File(path);
		boolean hidden = f.isHidden();
		System.out.println(hidden);
	}

	public static void deleteFile(String path) {
		File f = new File(path);
		boolean delete = f.delete();
		System.out.println(delete);
	}

	public static void chekFileExecute(String path) {
		File f = new File(path);
		boolean canExecute = f.canExecute();
		System.out.println(canExecute);
	}

	public static void checkFileRead(String path) {
		File f = new File(path);
		boolean canRead = f.canRead();
		System.out.println(canRead);
	}

	public static void checkFileWrite(String path) {
		File f = new File(path);
		boolean canWrite = f.canWrite();
		System.out.println(canWrite);
	}

	public static void checkFileExist(String path) {
		File f = new File(path);
		boolean exists = f.exists();
		System.out.println(exists);
	}

	// Frame
	// Methods---------------------------------------------------------------------------------------------------------

	public static void frameString(String val) {
		driver.switchTo().frame(val);
	}

	public static void frameIndex(int val) {
		driver.switchTo().frame(val);
	}

	public static void frameEle(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public static void frameParent(WebElement ele) {
		driver.switchTo().parentFrame();
	}

	public static void exitFrame() {
		driver.switchTo().defaultContent();
	}

	// Wait Interface
	// Methods----------------------------------------------------------------------------------------------

	public static void tsleep(int a) throws InterruptedException {
		Thread.sleep(a);
	}

	// Implicity
	// Wait-------------------------------------------------------------------------------------------------------

	public static void impWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// Fluent
	// Wait-------------------------------------------------------------------------------------------------------------

	public static void fluentWait(long wto, long pet, WebElement ele) {
		FluentWait f = new FluentWait(driver);
		WebDriverWait w = new WebDriverWait(driver, 20);
		f.withTimeout(Duration.ofSeconds(wto)).pollingEvery(Duration.ofNanos(pet)).ignoring(Throwable.class);
		f.until(ExpectedConditions.elementToBeClickable(ele));
	}

	// webDriver
	// Wait-------------------------------------------------------------------------------------------------------

	public static void waitAlert() {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitSelect(WebElement ele, boolean selected) {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementSelectionStateToBe(ele, selected));
	}

	// Robot Class
	// Methods--------------------------------------------------------------------------------------------------
	public static void robot() throws AWTException {
		Robot r = new Robot();
	}

	// Take Screen Shot
	// Method----------------------------------------------------------------------------------------------

	public static void screenShot(String val) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scimg = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Admin\\eclipse-workspace\\MavenProject\\ScreenShot\\" + val + "");
		FileUtils.copyFile(scimg, dest);
		System.out.println("screen Shot Taken and stored name as:" + val);
	}

	// Data
	// Driven............................................................................................................

	// Get Particular Data
	public static String getParDataFromExcel(String sheetname, int rowno, int cellno) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Maven_Data_Driven\\Data\\data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fi);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		int type = cell.getCellType();

		String value = "";

		if (type == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd,MMM,yyyy");
			value = s.format(d);
		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);
		}
		return value;
	}

	// Get All Datas
	public static void getAllDatasFromExcel(String sheetname) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Maven_Data_Driven\\Data\\data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fi);
		Sheet s = book.getSheet(sheetname);

		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);

			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell cell = r.getCell(j);
				int cellType = cell.getCellType();
				String value = "";

				if (cellType == 1) {
					value = cell.getStringCellValue();
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
					value = sd.format(d);
				} else {
					double d = cell.getNumericCellValue();
					long l = (long) d;
					value = String.valueOf(l);
				}
				System.out.println(value);
			}
		}
	}

	// Write in Excel in Existing Row
	public static void writeExcelInExistingRow(String sheetname, int rowno, int cellno, String value)
			throws IOException {

		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Maven_Data_Driven\\Data\\data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fi);
		Sheet s = book.getSheet(sheetname);
		Row cr = s.getRow(rowno);
		Cell c1 = cr.createCell(cellno);
		c1.setCellValue(value);
		FileOutputStream fs = new FileOutputStream(f);
		book.write(fs);
	}

	// Write in Excel in Existing Row
	public static void writeExcelInNewRow(String sheetname, int rowno, int cellno, String value)
			throws IOException {

		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\Maven_Data_Driven\\Data\\data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fi);
		Sheet s = book.getSheet(sheetname);
		Row cr = s.createRow(rowno);
		Cell c1 = cr.createCell(cellno);
		c1.setCellValue(value);
		FileOutputStream fs = new FileOutputStream(f);
		book.write(fs);
	}

	// Date and
	// Time--------------------------------------------------------------------------------------------------------------------------------------
	public static void dateTime() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String date = s.format(d);
		System.out.println(date);
	}

}
