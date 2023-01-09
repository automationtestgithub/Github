package Com.Guru99.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.Guru99.BaseClass.BaseClass;
import Com.Guru99.PageObject.LoginPage;

public class LoginPageTest extends BaseClass {

	@Test
	public void LoginTest() throws IOException, InterruptedException{
		//initialization(baseURL);
	
		initialization();
		
	    logger.info("URL is open");
		LoginPage LP = new LoginPage();

		LP.Setusername(username);
		logger.info("Enter username");

		LP.SetPassword(password);
		logger.info("Enter Password");
        LP.Clickbtn();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {	
			logger.info("Get Title");
			System.out.println("Passed");
		}
		
		else {		
			getScreenshotAs("LoginPageTest");
			Assert.assertTrue(false);
		}
	}
}