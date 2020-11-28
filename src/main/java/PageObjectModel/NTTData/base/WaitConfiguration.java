package PageObjectModel.NTTData.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjectModel.NTTData.context.PublicContext;

public class WaitConfiguration {
	public void applyWait(WebElement element)
	{
		PublicContext.driverWait=new WebDriverWait(PublicContext.driver, 15);
		PublicContext.driverWait.until(ExpectedConditions.stalenessOf(element));
	}
	
	public static void applySleep(int sec)
	{
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
