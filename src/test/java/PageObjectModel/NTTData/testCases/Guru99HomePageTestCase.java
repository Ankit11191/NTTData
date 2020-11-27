package PageObjectModel.NTTData.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import PageObjectModel.NTTData.base.BrowserSetup;
import PageObjectModel.NTTData.objectRepo.Guru99BankLoginPage;
import PageObjectModel.NTTData.objectRepo.Guru99HomePage;
import PageObjectModel.NTTData.objectRepo.Guru99RegConformation;

public class Guru99HomePageTestCase extends BrowserSetup {
	@Test
	public void testcase1() throws InterruptedException {
		Guru99HomePage homePage=new Guru99HomePage();
		Guru99RegConformation confPage=new Guru99RegConformation();
		Guru99BankLoginPage bankLoginpage=new Guru99BankLoginPage();
		homePage.sendEmailId("abc15@test.com");
		homePage.clickOnSubmit();
		assertEquals("Access details to demo site.", confPage.getHeader());
		String userID = confPage.getUserID();
//		assertEquals("mngr296761", userID);
		String password = confPage.getPassword();
//		assertEquals("ytAnesE", password);
		confPage.clickOnBankLink();
		bankLoginpage.enterUID(userID);
		bankLoginpage.enterPWD(password);	
		bankLoginpage.clickLogin();
		assertEquals("Gtpl Bank", bankLoginpage.getBankName());
		
	}
}
