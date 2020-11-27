package PageObjectModel.NTTData.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjectModel.NTTData.context.PublicContext;

public class Guru99HomePage {
	public Guru99HomePage() {
		PageFactory.initElements(PublicContext.driver, this);
	}

	@FindBy(name = "emailid")
	WebElement emailId;
	@FindBy(name = "btnLogin")
	WebElement submit;

	public void sendEmailId(String id) {
		emailId.sendKeys(id);
	}

	public void clickOnSubmit() {
		submit.click();
	}
}
