package Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
   public WebDriver driver;
    public Properties p;
    public Logger logger;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String br) throws IOException {
        System.out.println("Received browser parameter: " + br);

        FileInputStream file = new FileInputStream(".//src/test/resources/config.properties");
        p = new Properties();
        p.load(file);
        logger = LogManager.getLogger(this.getClass());

        if (br.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            
            // ✅ Fix: Use ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");  // Run without UI
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
        }
        if (br.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            
            // ✅ Fix: Use EdgeOptions
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");

            driver = new EdgeDriver(options);
        }

        driver.get(p.getProperty("appurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
