package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario24;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case24 {
	private WebDriver driver;
	private Pomscenario24 pomscenario24;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario24 = new Pomscenario24(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void Homepage() {
		pomscenario24.verifyHomePageIsVisible();

	}

	@Test(priority = 2)
	public void productselect() {
		pomscenario24.productsclick();
	}

	@Test(priority = 3, dependsOnMethods = "productselect")
	public void productaddtocart() {
		pomscenario24.addtocartitem();
		pomscenario24.viewcartclick();
		pomscenario24.checkout();
		pomscenario24.registerbutton();
	}

	@Test(priority = 4, dependsOnMethods = "productaddtocart")
	public void details1() {
		pomscenario24.usernamelogin("sankappa1");
		pomscenario24.emailid("sankupd53313837737@gmail.com");
		pomscenario24.signupbutton();
		pomscenario24.signupIsVisible();
	}

	@Test(priority = 5, dependsOnMethods = "details1")
	public void details() {
		pomscenario24.srcheck();
		pomscenario24.passwordenter("123456789");
		pomscenario24.selectdob();
		pomscenario24.selectmonth();
		pomscenario24.selectyear();
	}

	@Test(priority = 6, dependsOnMethods = "details")
	public void buttons() {
		pomscenario24.newsbutton();
		pomscenario24.offer();
	}

	@Test(priority = 7, dependsOnMethods = "buttons")
	public void address() {
		pomscenario24.fnameenter("sankappa");
		pomscenario24.lnameenter("pd");
		pomscenario24.companyenter("xxx");
		pomscenario24.address1enter("bannikodu");
		pomscenario24.address2enter("davangere");
		pomscenario24.countryselect();
		pomscenario24.stateselect("karnataka");
		pomscenario24.cityselect("harihar");
		pomscenario24.zipselect("577516");
		pomscenario24.mobile("7760022359");
		pomscenario24.createbutton();
		pomscenario24.verifyacccreatedIsVisible();
		pomscenario24.continuebutton();
		pomscenario24.verifyuserlogIsVisible();
	}

	@Test(priority = 8, dependsOnMethods = "address")
	public void checkoutitems() {
		pomscenario24.cartclick();
		pomscenario24.proceedcheckoutclick();
	}

	@Test(priority = 9, dependsOnMethods = "checkoutitems")
	public void verifysamederliveryaddress() {

		pomscenario24.verifysamedeliveryVisible();

	}

	@Test(priority = 10, dependsOnMethods = "verifysamederliveryaddress")
	public void verifysamebillingaddress() {
		pomscenario24.verifysamebillingVisible();
	}

	@Test(priority = 11, dependsOnMethods = "verifysamebillingaddress")
	public void carddata() {
		pomscenario24.cartclick();
		pomscenario24.proceedcheckoutclick();
		pomscenario24.reviewdata("delivery as soon as possible");
		pomscenario24.orderplace();

		pomscenario24.cardnamedata("sankappa");
		pomscenario24.cardnumberdata("7760022359");
		pomscenario24.cvvdata("333");
		pomscenario24.expiraydate("2");
		pomscenario24.yeardate("2026");
		pomscenario24.paybutton();

	}

	@Test(priority = 12, dependsOnMethods = "carddata")
	public void orderconfirmvisible() {
		boolean orderconfirms = pomscenario24.orderconfirms();
		Assert.assertTrue(orderconfirms, "ORDER IS NOT PLACED");

	}

	@Test(priority = 13, dependsOnMethods = "orderconfirmvisible")
	public void invoicedown() {

		pomscenario24.downloadinvoice();
		pomscenario24.continuehomebutton();

	}

	@Test(priority = 14, dependsOnMethods = "invoicedown")
	public void verifylastdetails() {
		pomscenario24.deletebutton();
		pomscenario24.verifyuserdeleteIsVisible();
		pomscenario24.continue2homebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
