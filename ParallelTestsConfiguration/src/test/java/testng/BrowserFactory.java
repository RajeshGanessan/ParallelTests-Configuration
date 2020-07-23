package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	private static BrowserFactory instance = null;
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static BrowserFactory getInstance() {

		if (instance == null) {

			instance = new BrowserFactory();
		}

		return instance;
	}

	public final void setDriver(String browser) {

		switch (browser) {
		case "Chrome":

			ChromeOptions options = new ChromeOptions();

			WebDriverManager.chromedriver().setup();

			driver.set(new ChromeDriver());
			
			break;
		case "firefox":

			
			WebDriverManager.firefoxdriver().setup();

			driver.set(new FirefoxDriver());
		}
	}

	public WebDriver getDriver() {
		return driver.get();
	}
}
