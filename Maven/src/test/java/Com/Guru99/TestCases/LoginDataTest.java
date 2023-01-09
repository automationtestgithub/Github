package Com.Guru99.TestCases;


import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Guru99.BaseClass.BaseClass;
import Com.Guru99.PageObject.LoginPage;
import Com.Guru99.Utilities.XLUtils;

public class LoginDataTest extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void LoginData(String user, String Pwd) throws InterruptedException, IOException {

		logger.info("URL is open");
		LoginPage LP1 = new LoginPage();

		LP1.Setusername(user);
		logger.info("Enter username");

		LP1.SetPassword(Pwd);
		logger.info("Enter Password");

		LP1.Clickbtn();

		if (Isalertpresent() == true) {
			driver.switchTo().alert().accept(); // popup close
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("Login failed");
			getScreenshotAs("TestDataFailed");
			
		} else {

			Assert.assertTrue(true);
			logger.info("Login passed");
			LP1.Logoutapplication();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
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

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String Path = System.getProperty("user.dir") + "/src/main/java/Com/internetbanking/TestData/9July.xlsx";
		int rownum = XLUtils.getRowCount(Path, "Sheet1");
		int Colcount = XLUtils.getCellCount(Path, "Sheet1", 1);

		String logindata[][] = new String[rownum][Colcount];
	
		for (int i = 1; i <= rownum; i++) {
			
			for (int j = 0; j < Colcount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(Path, "Sheet1", i, j);     
			}
		}
		return logindata;
	}
}