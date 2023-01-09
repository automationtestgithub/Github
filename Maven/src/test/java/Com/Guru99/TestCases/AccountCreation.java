package Com.Guru99.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Guru99.BaseClass.BaseClass;
import Com.Guru99.PageObject.LoginPage;
import Com.Guru99.PageObject.NewAccount;
import Com.Guru99.Configuration.ReadConfigiration;

public class AccountCreation extends BaseClass{
	ReadConfigiration readconfig = new ReadConfigiration();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	@Test
public void AddNewAccount() throws InterruptedException, IOException {
	logger.info("URL is opened");

    LoginPage LP=new LoginPage();

	LP.Setusername(username);
	logger.info("Enter username");

	LP.SetPassword(password);
	logger.info("Enter Passsword");

	LP.Clickbtn();
	
	NewAccount NewAcount = new NewAccount();
	
	NewAcount.Account();
	Thread.sleep(2000);
	logger.info("Click on NewAccount tab");

	driver.navigate().refresh();
	NewAcount.Account();
     
	NewAcount.AccountNumber("79274");
	logger.info("Enter Customer nuuber");

	Thread.sleep(2000);
	
	NewAcount.AccountDeposit("3000");
	logger.info("Enter deposit value");
	NewAcount.Submit();
	logger.info("Clcik on submit button");
	
	boolean Test=driver.findElement(By.xpath("//p[@class=\"heading3\"]")).isDisplayed();

	if(Test==true) {
		
		logger.info("Account created");

		Assert.assertTrue(true);
	}
	else {
		getScreenshotAs("NewAccount");
		logger.info("Account creatation failed");
		Assert.assertTrue(false);

	}
	}
	public boolean Isalertpresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}