package Com.Guru99.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Guru99.BaseClass.BaseClass;

public class EditCustomer extends BaseClass {

	public EditCustomer() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	WebElement EditCustomer;
	
	@FindBy(name = "cusid")
	WebElement CustomerID;
	
	@FindBy(name = "button2")
	WebElement Submitbutton;

	public static void CustSubmit() {
		
	}

	public static void CustId() {
		
	}
}