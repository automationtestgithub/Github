package Com.Guru99.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Guru99.BaseClass.BaseClass;

public class LoginPage extends BaseClass{

  public LoginPage() 
  {
	  PageFactory.initElements(driver,this);
  }
  
  @FindBy(name = "uid")
  public WebElement Username;
  
  @FindBy(xpath = "//input[@name=\"password\"]")
  public WebElement Password;
  
  @FindBy(name = "btnLogin")
  public WebElement LoginBtn;
  
  @FindBy(xpath = "//a[contains(text(),'Log out')]")
  public WebElement Logout;
  
  public void Setusername(String Uname) 
  {
	  Username.sendKeys(Uname);
  }
  
  public void SetPassword(String Pwd) 
  {  
	  Password.sendKeys(Pwd);
  }
  
  public void Clickbtn() 
  {
	  LoginBtn.click();  
  }
  
  public void Logoutapplication() 
  {
	  Logout.click();
  }
}