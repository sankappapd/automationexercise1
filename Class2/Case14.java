package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario14;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case14 {

	private WebDriver driver;
	private Pomscenario14 pomscenario14;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario14 = new Pomscenario14(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario14.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2)
	public void productselect() {
		pomscenario14.productsclick();
	}

	@Test(priority = 3, dependsOnMethods = "productselect")
	public void productaddtocart() {
		pomscenario14.addtocartitem();
		pomscenario14.viewcartclick();
		pomscenario14.checkout();
		pomscenario14.registerbutton();
	}

	@Test(priority = 4, dependsOnMethods = "productaddtocart")
	public void details1() {
		pomscenario14.usernamelogin("sankappa1");
		pomscenario14.emailid("sankupd533137737@gmail.com");
		pomscenario14.signupbutton();
		pomscenario14.signupIsVisible();
	}

	@Test(dependsOnMethods = "details1")
	public void details() {
		pomscenario14.srcheck();
		pomscenario14.passwordenter("123456789");
		pomscenario14.selectdob();
		pomscenario14.selectmonth();
		pomscenario14.selectyear();
	}

	@Test(dependsOnMethods = "details")
	public void buttons() {
		pomscenario14.newsbutton();
		pomscenario14.offer();
	}

	@Test(dependsOnMethods = "buttons")
	public void address() {
		pomscenario14.fnameenter("sankappa");
		pomscenario14.lnameenter("pd");
		pomscenario14.companyenter("xxx");
		pomscenario14.address1enter("bannikodu");
		pomscenario14.address2enter("davangere");
		pomscenario14.countryselect();
		pomscenario14.stateselect("karnataka");
		pomscenario14.cityselect("harihar");
		pomscenario14.zipselect("577516");
		pomscenario14.mobile("7760022359");
		pomscenario14.createbutton();
		pomscenario14.verifyacccreatedIsVisible();
		pomscenario14.continuebutton();
		pomscenario14.verifyuserlogIsVisible();
	}

	@Test(dependsOnMethods = "address")
	public void carddata() {
		pomscenario14.cartclick();
		pomscenario14.proceedcheckoutclick();
		pomscenario14.reviewdata("delivery as soon as possible");
		pomscenario14.orderplace();

		pomscenario14.cardnamedata("sankappa");
		pomscenario14.cardnumberdata("7760022359");
		pomscenario14.cvvdata("333");
		pomscenario14.expiraydate("2");
		pomscenario14.yeardate("2026");
		pomscenario14.paybutton();

	}

	@Test(dependsOnMethods = "carddata")
	public void orderconfirmvisible() {
		boolean orderconfirms = pomscenario14.orderconfirms();
		Assert.assertTrue(orderconfirms, "ORDER IS NOT PLACED");

	}

	@Test(dependsOnMethods = "orderconfirmvisible")
	public void verifylastdetails() {
		pomscenario14.deletebutton();
		pomscenario14.verifyuserdeleteIsVisible();
		pomscenario14.continuehomebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}