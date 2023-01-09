package Com.Guru99.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;
import Com.Guru99.BaseClass.BaseClass;
import Com.Guru99.PageObject.EditCustomer;
import Com.Guru99.PageObject.LoginPage;

public class EditCustomerTest extends BaseClass {
	@Test
	public void AddnewCutomer() throws InterruptedException, IOException {
		
		EditCustomer.CustId();
		logger.info("15691");
		EditCustomer.CustSubmit();
		logger.info("Click on submit button");
	}
}