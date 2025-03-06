package Testcases;

import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
	WebDriver driver;
	public Properties p;
	public Logger logger;
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		System.out.println("Received browser parameter: " + br);
	FileInputStream file =new FileInputStream(".//src/test/resources/property");
	p=new Properties();
	p.load(file);
	logger=LogManager.getLogger(this.getClass());
	if(br.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
	}
	if(br.equalsIgnoreCase("edge"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new EdgeDriver();
	}
	
	driver.get(p.getProperty("appurl"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
