package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario16;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Class16 {
	private WebDriver driver;
	private Pomscenario16 pomscenario16;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario16 = new Pomscenario16(driver); // Corrected initialization
	}

	@Test
	public void Homepage() {
		pomscenario16.verifyHomePageIsVisible();

	}

	@Test
	public void signuptest() {
		pomscenario16.clicklogin();
		pomscenario16.verifysignupIsVisible();
	}

	@Test(dependsOnMethods = "signuptest")
	public void details() {
		pomscenario16.usernamelogin("sankupd7875@gmail.com");
		pomscenario16.passwordenter("12345678");
		pomscenario16.clickloginbutton();
		pomscenario16.verifyuserlogIsVisible();

	}

	@Test(dependsOnMethods = "details")
	public void productaddtocart() {
		pomscenario16.addtocartitem();
		pomscenario16.viewcartclick();
		pomscenario16.checkout();
	}

	@Test(dependsOnMethods = "productaddtocart")
	public void carddata() {
		pomscenario16.reviewdata("delivery as soon as possible");
		pomscenario16.orderplace();

		pomscenario16.cardnamedata("sankappa");
		pomscenario16.cardnumberdata("7760022359");
		pomscenario16.cvvdata("333");
		pomscenario16.expiraydate("2");
		pomscenario16.yeardate("2026");
		pomscenario16.paybutton();

	}

	@Test(dependsOnMethods = "carddata")
	public void orderconfirmvisible() {
		boolean orderconfirms = pomscenario16.orderconfirms();
		Assert.assertTrue(orderconfirms, "The homepage is not visible.");

	}

	@Test(dependsOnMethods = "orderconfirmvisible")
	public void verifylastdetails() {
		pomscenario16.deletebutton();
		pomscenario16.verifyuserdeleteIsVisible();
		pomscenario16.continuehomebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
