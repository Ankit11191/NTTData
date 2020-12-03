package PageObjectModel.NTTData.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import PageObjectModel.NTTData.base.BrowserSetup;
import PageObjectModel.NTTData.base.WaitConfiguration;
import PageObjectModel.NTTData.context.PublicContext;
import PageObjectModel.NTTData.listner.RetryingTestCases;
import PageObjectModel.NTTData.objectRepo.Guru99BankLoginPage;
import PageObjectModel.NTTData.objectRepo.Guru99HomePage;
import PageObjectModel.NTTData.objectRepo.Guru99RegConformation;

public class Guru99HomePageTestCase extends BrowserSetup {

	@DataProvider
	public Object[] dataSetUP(){
		return new Object[] {"TestCase201@test.com"};
		
	}
	
	@Test(retryAnalyzer = RetryingTestCases.class, dataProvider = "dataSetUP")
	public void testcase1(String UID) throws InterruptedException {
		PublicContext.test=PublicContext.reports.createTest("Verifying user is able to login into Gtpl BankBank ");
		Guru99HomePage homePage=new Guru99HomePage();
		Guru99RegConformation confPage=new Guru99RegConformation();
		Guru99BankLoginPage bankLoginpage=new Guru99BankLoginPage();
		homePage.sendEmailId(UID);
		PublicContext.test.log(Status.PASS, MarkupHelper.createLabel("UserID "+UID+" is provided", ExtentColor.GREEN));
		homePage.clickOnSubmit();
		WaitConfiguration.applySleep(5);
		PublicContext.test.log(Status.PASS, MarkupHelper.createLabel("click in Login button", ExtentColor.GREEN));
		assertEquals("Access details to demo site.", confPage.getHeader());
		PublicContext.test.log(Status.PASS, MarkupHelper.createLabel("Assertion successful", ExtentColor.GREEN));
		String userID = confPage.getUserID();
		String password = confPage.getPassword();
		confPage.clickOnBankLink();
		bankLoginpage.enterUID(userID);
		PublicContext.test.log(Status.PASS, MarkupHelper.createLabel("UserID : "+userID+" is provided", ExtentColor.GREEN));
		bankLoginpage.enterPWD(password);
		PublicContext.test.log(Status.PASS, MarkupHelper.createLabel("Password : ******* is provided", ExtentColor.GREEN));
		bankLoginpage.clickLogin();
		PublicContext.test.log(Status.PASS, MarkupHelper.createLabel("User loggein successfully in account", ExtentColor.GREEN));
		assertEquals("Gtpl Bank", bankLoginpage.getBankName());
		PublicContext.test.log(Status.PASS, MarkupHelper.createLabel("Assertion successful", ExtentColor.GREEN));
		
	}
}
