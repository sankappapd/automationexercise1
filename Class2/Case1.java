package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case1 {

    private WebDriver driver;
    private Pomscenario1 pomscenario1;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://automationexercise.com/"); // Replace with your login page URL
        pomscenario1 = new Pomscenario1(driver); // Corrected initialization
    }

    @Test
    public void Homepage() {
        pomscenario1.verifyHomePageIsVisible();
        
       }
    @Test
    public void signuptest() {
    	pomscenario1.clicklogin();
    	pomscenario1.verifysignupIsVisible();
    	pomscenario1.usernamelogin("sankappa1");
        pomscenario1.emailid("sankupd335@gmail.com");
        pomscenario1.signupbutton();
        pomscenario1.signupIsVisible();
        
       }
    @Test(dependsOnMethods="signuptest")
    public void details() {
    	pomscenario1.srcheck();
    	pomscenario1.passwordenter("123456789");
    	pomscenario1.selectdob();
    	pomscenario1.selectmonth();
    	pomscenario1.selectyear();
    }
    @Test(dependsOnMethods="details")
    public void buttons() {
    	pomscenario1.newsbutton();
    	pomscenario1.offer();
    }
    @Test(dependsOnMethods="buttons")
    public void address() {
    	pomscenario1.fnameenter("sankappa");
    	pomscenario1.lnameenter("pd");
    	pomscenario1.companyenter("xxx");
    	pomscenario1.address1enter("bannikodu");
    	pomscenario1.address2enter("davangere");
    	pomscenario1.countryselect();
    	pomscenario1.stateselect("karnataka");
    	pomscenario1.cityselect("harihar");
    	pomscenario1.zipselect("577516");
    	pomscenario1.mobile("7760022359");
    	pomscenario1.createbutton();
    	pomscenario1.verifyacccreatedIsVisible();
    	pomscenario1.continuebutton();
    	pomscenario1.verifyuserlogIsVisible();
    	pomscenario1.deletebutton();
    	pomscenario1.verifyuserdeleteIsVisible();
    	pomscenario1.lastcontinuebutton();
    }
  
    @AfterTest
    public void tearDown() {
        driver.quit();
        
    }
    
}
