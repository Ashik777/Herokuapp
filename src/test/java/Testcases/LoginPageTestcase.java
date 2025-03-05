package Testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectClasses.HomePageObjectClass;
import PageObjectClasses.LoginPageObjectClass;

public class LoginPageTestcase extends BaseTestClass {
	

	@Test
	public void loginTest()
	{
		logger.info("Launching the browser");
		LoginPageObjectClass login = new LoginPageObjectClass(driver);
		login.setUserName(p.getProperty("username"));
		logger.info("entered user name");
		login.setPassword(p.getProperty("password"));
		logger.info("entered password");
		login.clickSubmit();
		logger.info("Clicked on submit button");
	 HomePageObjectClass home= new HomePageObjectClass(driver);
	boolean homepagetext_Status= home.getHomepageText();
	
	if(homepagetext_Status==true)
	{
		logger.info(homepagetext_Status+"home page text");
		Assert.assertTrue(true);
	}
}
}