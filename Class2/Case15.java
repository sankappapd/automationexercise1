package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario15;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case15 {

	private WebDriver driver;
	private Pomscenario15 pomscenario15;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario15 = new Pomscenario15(driver); // Corrected initialization
	}

	@Test
	public void Homepage() {
		pomscenario15.verifyHomePageIsVisible();

	}

	@Test
	public void signuptest() {
		pomscenario15.clicklogin();
		pomscenario15.verifysignupIsVisible();
		pomscenario15.usernamelogin("sankappa1");
		pomscenario15.emailid("sankupd001@gmail.com");
		pomscenario15.signupbutton();
		pomscenario15.signupIsVisible();

	}

	@Test(dependsOnMethods = "signuptest")
	public void details() {
		pomscenario15.srcheck();
		pomscenario15.passwordenter("123456789");
		pomscenario15.selectdob();
		pomscenario15.selectmonth();
		pomscenario15.selectyear();
	}

	@Test(dependsOnMethods = "details")
	public void buttons() {
		pomscenario15.newsbutton();
		pomscenario15.offer();
	}

	@Test(dependsOnMethods = "buttons")
	public void address() {
		pomscenario15.fnameenter("sankappa");
		pomscenario15.lnameenter("pd");
		pomscenario15.companyenter("xxx");
		pomscenario15.address1enter("bannikodu");
		pomscenario15.address2enter("davangere");
		pomscenario15.countryselect();
		pomscenario15.stateselect("karnataka");
		pomscenario15.cityselect("harihar");
		pomscenario15.zipselect("577516");
		pomscenario15.mobile("7760022359");
		pomscenario15.createbutton();
		pomscenario15.verifyacccreatedIsVisible();
		pomscenario15.continuebutton();
		pomscenario15.verifyuserlogIsVisible();
	}

	@Test(dependsOnMethods = "address")
	public void productaddtocart() {
		pomscenario15.addtocartitem();
		pomscenario15.viewcartclick();
		pomscenario15.checkout();
	}

	@Test(dependsOnMethods = "productaddtocart")
	public void carddata() {
		pomscenario15.reviewdata("delivery as soon as possible");
		pomscenario15.orderplace();

		pomscenario15.cardnamedata("sankappa");
		pomscenario15.cardnumberdata("7760022359");
		pomscenario15.cvvdata("333");
		pomscenario15.expiraydate("2");
		pomscenario15.yeardate("2026");
		pomscenario15.paybutton();

	}

	@Test(dependsOnMethods = "carddata")
	public void orderconfirmvisible() {
		boolean orderconfirms = pomscenario15.orderconfirms();
		Assert.assertTrue(orderconfirms, "The homepage is not visible.");

	}

	@Test(dependsOnMethods = "orderconfirmvisible")
	public void verifylastdetails() {
		pomscenario15.deletebutton();
		pomscenario15.verifyuserdeleteIsVisible();
		pomscenario15.continuehomebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
