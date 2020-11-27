package PageObjectModel.NTTData.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageObjectModel.NTTData.context.PublicContext;

public class Guru99BankLoginPage {

	public Guru99BankLoginPage() {
		PageFactory.initElements(PublicContext.driver, this);
	}

	@FindBy(name="uid")
	WebElement uid;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	@FindBy(className = "barone")
	WebElement bankName;
	
	public void enterUID(String uID)
	{
		uid.sendKeys(uID);
	}

	public void enterPWD(String pwd)
	{
		password.sendKeys(pwd);
	}

	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public String getBankName()
	{
		return bankName.getText();
	}

}
