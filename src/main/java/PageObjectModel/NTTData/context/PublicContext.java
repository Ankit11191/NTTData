package PageObjectModel.NTTData.context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class PublicContext {
	public static WebDriver driver = null;
	public static ExtentHtmlReporter htmlReport = null;
	public static ExtentReports reports = null;
	public static ExtentTest test = null;
	public static WebDriverWait driverWait = null;
}
