package PageObjectModel.NTTData.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageObjectModel.NTTData.context.PublicContext;
import PageObjectModel.NTTData.reporting.GetScreenshot;

public class BrowserSetup {
	ReadFromProperties properties = new ReadFromProperties();

	@BeforeMethod()
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		PublicContext.driver = new ChromeDriver();// to launch browser
		PublicContext.driver.manage().window().maximize();
		PublicContext.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PublicContext.driver.get(properties.readProperties("AppURL"));
		System.out.println("app launch successfully");
	}

	@BeforeTest()
	public void reportSetup() {
		PublicContext.htmlReport = new ExtentHtmlReporter("./Report/result.html");
		PublicContext.reports = new ExtentReports();
		PublicContext.reports.attachReporter(PublicContext.htmlReport);
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if (result.getStatus() == result.SUCCESS) {
			PublicContext.test.log(Status.PASS, MarkupHelper.createLabel("Passed", ExtentColor.GREEN));
		}
		if (result.getStatus() == result.FAILURE) {
			PublicContext.test.log(Status.FAIL, MarkupHelper.createLabel("Failed", ExtentColor.RED));
			String SSpath = new GetScreenshot().getScreenshotAs();
			try {
				PublicContext.test.fail("Fail",
						MediaEntityBuilder.createScreenCaptureFromPath(SSpath).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			PublicContext.test.fail(result.getThrowable().getLocalizedMessage());
		}
		PublicContext.driver.quit();
	}

	@AfterSuite
	public void ReportFinish() {
		PublicContext.reports.flush();
	}
}
