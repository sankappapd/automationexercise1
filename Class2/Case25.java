package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario25;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case25 {
	private WebDriver driver;
    private Pomscenario25 pomscenario25;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

        driver.get("https://automationexercise.com/"); // Replace with your login page URL
        pomscenario25 = new Pomscenario25(driver); // Corrected initialization
    }

    @Test(priority=1)
    public void Homepage() {
        pomscenario25.verifyHomePageIsVisible();
        
       }

@Test(priority=2)
public void scrolljs() {
	pomscenario25.scroll();
	pomscenario25.clickup();
}
@Test(priority=3)
public void verifyhometext() {
	pomscenario25.verifyengineertextIsVisible();
}
	
	
@AfterTest
public void tearDown() {
    driver.quit();
    
}
	
	
	
	
	
	
	
}
