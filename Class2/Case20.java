package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario20;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case20 {
	private WebDriver driver;
	private Pomscenario20 pomscenario20;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario20 = new Pomscenario20(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void PRODUCTSbutton() {
		pomscenario20.PRODUCTS();
	}

	@Test(priority = 2, dependsOnMethods = "PRODUCTSbutton")
	public void VERIFYPOLOPRODUCTS() {
		pomscenario20.verifyallproductsIsVisible();

	}

	@Test(priority = 3, dependsOnMethods = "VERIFYPOLOPRODUCTS")
	public void productsinput() {
		pomscenario20.searchitem("jeans");
		pomscenario20.PRODUCTSsearch();

	}

	@Test(priority = 4, dependsOnMethods = "productsinput")
	public void productssearchverify() {
		pomscenario20.verifsearchedproductsIsVisible();

	}

	@Test(priority = 4, dependsOnMethods = "productssearchverify")
	public void Addingitemstocart() {
		pomscenario20.additems1tocart();
		pomscenario20.continue1();
		pomscenario20.additems2tocart();
		pomscenario20.continue2();
		pomscenario20.additems3tocart();
		pomscenario20.viewcart();

	}

	@Test(priority = 5, dependsOnMethods = "Addingitemstocart")
	public void logindetails() {
		pomscenario20.clicklogin();
		pomscenario20.usernamelogin("sankupd33@gmail.com");
		pomscenario20.passwordenter("123456789");
		pomscenario20.clickloginbutton();
		pomscenario20.lastcart();
	}

	@Test(priority = 6, dependsOnMethods = "logindetails")
	public void verifyallitemsincart() {
		pomscenario20.verifyallitemsIsVisible();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
