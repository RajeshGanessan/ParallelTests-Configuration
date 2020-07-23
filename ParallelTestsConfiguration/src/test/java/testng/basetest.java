package test.java.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import testng.BrowserFactory;

public class basetest {

	public static testng.ExcelUtils utils;
	public static String filePath = System.getProperty("user.dir") + "/excelFile.xlsx";
	protected static BrowserFactory browserFactory = BrowserFactory.getInstance();



	@Parameters(value = { "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) {
		System.out.println("BaseClass's Before  method");

		testng.BrowserFactory browserFactory = testng.BrowserFactory.getInstance();
		browserFactory.setDriver(browser);
		browserFactory.getDriver().get("http://google.co.in");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("BaseClass's After  method");

		browserFactory.getDriver().quit();
	}
}
