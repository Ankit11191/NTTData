package PageObjectModel.NTTData.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObjectModel.NTTData.base.BrowserSetup;
import PageObjectModel.NTTData.context.PublicContext;

public class GoogleExample extends BrowserSetup {
	@Test
	public void callGoogle() {
		PublicContext.driver.findElement(By.name("Selenium"));
	}
}
