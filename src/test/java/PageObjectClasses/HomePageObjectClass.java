package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjectClass extends BasePage{

	public HomePageObjectClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//h4[text()='Welcome to the Secure Area. When you are done click logout below.']") WebElement homepageText;
@FindBy(xpath="//i[text()=' Logout']") WebElement logoutButton;

public boolean getHomepageText()
{
	boolean text =homepageText.isDisplayed();
	return text;
}

public void clickLogout()
{
	logoutButton.click();
}


}
