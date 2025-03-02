package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjectClass extends BasePage {

	public LoginPageObjectClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


@FindBy(xpath="//input[@id='username']") WebElement user_name;
@FindBy(xpath="//input[@id='password']") WebElement password;
@FindBy(xpath="//button[@type='submit']") WebElement submitButton;


public void setUserName(String user)
{
	user_name.sendKeys(user);
}
public void setPassword(String pwd)
{
	password.sendKeys(pwd);
}

public void clickSubmit()
{
	submitButton.click();
}

}
