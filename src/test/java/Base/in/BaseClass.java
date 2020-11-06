package Base.in;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	static Select s;

	
	// 1.Launch Browser
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Ellipse - Gtech\\selenium drivers\\87.0\\86.0\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// 2.Launch URL
	public static void launchUrl(String Urlinput) {
		driver.get(Urlinput);
	}

	// 3. To click Button
	public static void bclick(WebElement buttonclick) {
		buttonclick.click();
	}

	// 4.TO fill text Box
	public static void filltxtbox(WebElement fill, String input) {
		fill.sendKeys(input);
	}

	// 5.Drop down select by Index
	public static void dropdown(WebElement drpdwn, int Indexvalue) {
		s = new Select(drpdwn);
		s.selectByIndex(Indexvalue);
	}

	// 6.Select BY value
	public static void dropdownValue(WebElement drpdwn, String value) {
		s.selectByValue(value);
	}

	public static String readfromExcel(int row, int cell ,String Sheetname) throws Throwable {
		File Filepath = new File ("E:\\Ellipse - Gtech\\Workspace\\SampleScenari\\Excel\\FreeCRm.xlsx");
		FileInputStream stream= new FileInputStream(Filepath);
		Workbook WorkbookName=new XSSFWorkbook(stream);
		Sheet sheetname= WorkbookName.getSheet(Sheetname);
		Row Rownumber = sheetname.getRow(row);
		String stringCellValue2 = Rownumber.getCell(cell).getStringCellValue();
		return stringCellValue2;	
	}
	
	public static String excelvalues(int row, int cell ,String Sheetname) throws Throwable {
		File Filepath = new File ("E:\\Ellipse - Gtech\\Workspace\\SampleScenari\\Excel\\FreeCRm.xlsx");
		FileInputStream stream= new FileInputStream(Filepath);
		Workbook WorkbookName=new XSSFWorkbook(stream);
		Sheet sheetname= WorkbookName.getSheet(Sheetname);
		String valueOf= null;
		String format = null;
		
	for (int i = 0; i < sheetname.getPhysicalNumberOfRows(); i++) {
		Row rowvalues = sheetname.getRow(i);
		for (int j = 0; j < rowvalues.getPhysicalNumberOfCells(); j++) {
			Cell cellvalues = rowvalues.getCell(j);
			int cellType = cellvalues.getCellType();
			if(cellType==1) {
				String stringCellValue = cellvalues.getStringCellValue();
				return stringCellValue;
			}
			else if(cellType==0) {
				if(DateUtil.isCellDateFormatted(cellvalues)) {
					Date dateCellValue = cellvalues.getDateCellValue();
					SimpleDateFormat dateformat=new SimpleDateFormat("DD-MM-YYYY HH:SS");
					 format = dateformat.format(dateCellValue);
					 return format;
				}
			}
				else {
					
					double numericCellValue = cellvalues.getNumericCellValue();
					//Typecasting double to long
					long intolong = (long)numericCellValue;
					//Convert long into string
					valueOf = String.valueOf(intolong);
					
				}
			}
		}
	return valueOf;
	}
		

		
	public static void close() throws Throwable {
		Thread.sleep(4000);
		driver.quit();

	}

}

