package Com.Guru99.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Guru99.BaseClass.BaseClass;
import Com.Guru99.PageObject.AddCustomerPage;
import Com.Guru99.PageObject.LoginPage;
import net.bytebuddy.utility.RandomString;

public class NewCustomerTest extends BaseClass{

@Test
	public void AddNewCustomer() throws InterruptedException, IOException {
     	logger.info("URL is opened");

		LoginPage LP=new LoginPage();
		
		LP.Setusername(username);
		logger.info("Enter username");

		LP.SetPassword(password);
		logger.info("Enter Passsword");

		LP.Clickbtn();
		
		Thread.sleep(1000);
		
		AddCustomerPage Addcust =new AddCustomerPage();
		
		Addcust.ClickaddNewCustomer();
		logger.info("Clcik on addnew customer tab");

		Thread.sleep(1000);
		
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		Addcust.ClickaddNewCustomer();
		logger.info("Clcik on addnew customer tab");

		Addcust.Custname("Mayuri");
		logger.info("Enter customer name");

		Addcust.CustGender();
		logger.info("Select gender");

		Addcust.Custdob("26", "04", "1999");
		logger.info("Select DOB");

		Thread.sleep(2000);

		Addcust.CustAddress("Gadhmandir");
		logger.info("Enter Address");

		Addcust.CustCity("Ramtek");
		logger.info("Select city");

		Addcust.CustState("MH");
		logger.info("Select State");

		Addcust.CustPinno("411017");
		logger.info("Select Pinno");

		Addcust.CustMobile("8180942640");	
		logger.info("Enter mobile number");

		String Random = RandomString.make(6);
         //gfhfhf@gmail.com
		//fedsfb@gamil.com
		String email =Random+"@gmail.com";
		Addcust.CustEmail(email);
		logger.info("Enter email address");

		Addcust.CustPassword("TWINKLE");
		logger.info("Enter password");
		Thread.sleep(2000);

		Addcust.CustSubmit();
		logger.info("Click on submit button");

		Thread.sleep(2000);

		boolean Test=driver.findElement(By.xpath("//p[contains(text(),'Customer Registered Successfully!!!')]")).isDisplayed();
		Assert.assertTrue(Test);
		if(Test=true) {
			logger.info("User created");
			AssertJUnit.assertTrue(true);		
		}
		else {					
			logger.info("User creation failed");
			getScreenshotAs("Addcustomer");
			AssertJUnit.assertTrue(false);
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