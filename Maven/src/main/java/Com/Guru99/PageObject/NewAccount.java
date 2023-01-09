package Com.Guru99.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Guru99.BaseClass.BaseClass;

public class NewAccount extends BaseClass{

	public NewAccount() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	WebElement NewAccount;
	
	@FindBy(name = "cusid")
	WebElement CustomerID;
	
	@FindBy(name = "inideposit")
	WebElement Deposit;
	
	@FindBy(name = "button2")
	WebElement Submitbutton;
	
	public void Account() {
		NewAccount.click();
	}
	public void AccountNumber(String Number) {
		CustomerID.sendKeys(Number);
	}
	public void AccountDeposit(String Value) {
		Deposit.sendKeys(Value);
	}
	public void Submit() {
		Submitbutton.click();
	}
}