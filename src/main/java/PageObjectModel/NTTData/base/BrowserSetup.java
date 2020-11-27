package PageObjectModel.NTTData.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageObjectModel.NTTData.context.PublicContext;

public class BrowserSetup {
	ReadFromProperties properties = new ReadFromProperties();

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		PublicContext.driver = new ChromeDriver();// to launch browser
		PublicContext.driver.manage().window().maximize();
		PublicContext.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PublicContext.driver.get(properties.readProperties("AppURL"));
		System.out.println("app launch successfully");
	}

	@AfterTest
	public void teardown() {
		PublicContext.driver.quit();
	}
}
