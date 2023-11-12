package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario23;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case23 {
	private WebDriver driver;
	private Pomscenario23 pomscenario23;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario23 = new Pomscenario23(driver); // Corrected initialization
	}

	@Test
	public void Homepage() {
		pomscenario23.verifyHomePageIsVisible();

	}

	@Test
	public void signuptest() {
		pomscenario23.clicklogin();
		pomscenario23.verifysignupIsVisible();
		pomscenario23.usernamelogin("sankappa1");
		pomscenario23.emailid("sankupd433@gmail.com");
		pomscenario23.signupbutton();
		pomscenario23.signupIsVisible();

	}

	@Test(dependsOnMethods = "signuptest")
	public void details() {
		pomscenario23.srcheck();
		pomscenario23.passwordenter("123456789");
		pomscenario23.selectdob();
		pomscenario23.selectmonth();
		pomscenario23.selectyear();
	}

	@Test(dependsOnMethods = "details")
	public void buttons() {
		pomscenario23.newsbutton();
		pomscenario23.offer();
	}

	@Test(dependsOnMethods = "buttons")
	public void address() {
		pomscenario23.fnameenter("sankappa");
		pomscenario23.lnameenter("pd");
		pomscenario23.companyenter("xxx");
		pomscenario23.address1enter("bannikodu");
		pomscenario23.address2enter("davangere");
		pomscenario23.countryselect();
		pomscenario23.stateselect("karnataka");
		pomscenario23.cityselect("harihar");
		pomscenario23.zipselect("577516");
		pomscenario23.mobile("7760022359");
		pomscenario23.createbutton();
		pomscenario23.verifyacccreatedIsVisible();
		pomscenario23.continuebutton();
		pomscenario23.verifyuserlogIsVisible();
	}

	@Test(dependsOnMethods = "address")
	public void productselect() {
		pomscenario23.productsclick();
	}

	@Test(dependsOnMethods = "productselect")
	public void productaddtocart() {
		pomscenario23.addtocartitem();
		pomscenario23.viewcartclick();
		pomscenario23.checkout();
	}

	@Test(dependsOnMethods = "productaddtocart")
	public void verifysamederliveryaddress() {

		pomscenario23.verifysamedeliveryVisible();

	}

	@Test(dependsOnMethods = "verifysamederliveryaddress")
	public void verifysamebillingaddress() {
		pomscenario23.verifysamebillingVisible();
	}

	@Test(dependsOnMethods = "verifysamebillingaddress")
	public void verifylastdetails() {
		pomscenario23.deletebutton();
		pomscenario23.verifyuserdeleteIsVisible();
		pomscenario23.continuehomebutton();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
