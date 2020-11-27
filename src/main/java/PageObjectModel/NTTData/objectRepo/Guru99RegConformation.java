package PageObjectModel.NTTData.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjectModel.NTTData.context.PublicContext;

public class Guru99RegConformation {

	public Guru99RegConformation() {
		PageFactory.initElements(PublicContext.driver, this);
	}

	@FindBy(xpath = "//table//td/h2")
	WebElement header;
	@FindBy(xpath = "//table/tbody/tr[4]/td[2]")
	WebElement UserID;
	@FindBy(xpath = "//table/tbody/tr[5]/td[2]")
	WebElement password;
	@FindBy(linkText = "Bank Project")
	WebElement bankProjectLink;

	public String getHeader() {
		return header.getText();
	}

	public String getUserID() {
		return UserID.getText();
	}

	public String getPassword() {
		return password.getText();
	}
	public void clickOnBankLink() {
		bankProjectLink.click();
	}

}
