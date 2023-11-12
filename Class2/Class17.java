package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario17;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Class17 {
	 private WebDriver driver;
	    private Pomscenario17 pomscenario17;

	    @BeforeTest
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("https://automationexercise.com/"); // Replace with your login page URL
	        pomscenario17 = new Pomscenario17(driver); // Corrected initialization
	    }

	    @Test
	    public void Homepage() {
	        pomscenario17.verifyHomePageIsVisible();
	        
	       }
	    
	    @Test(dependsOnMethods="Homepage")
	    public void productaddtocart() {
	    	pomscenario17.addtocartitem();
	    	pomscenario17.viewcartclick();
	    	}
	    
	    @Test(dependsOnMethods="productaddtocart")
	    public void removefromcart() {
	    	pomscenario17.removeitems();
	    	}
	    
	    @Test(dependsOnMethods="removefromcart")
	    public void removeverify() {
	        pomscenario17.removedsuccess();
	        
	       }
	    
	    
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	        
	    }
	    
	    
	    
	    
	    
	    
}
