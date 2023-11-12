package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario13;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case13 {
	private WebDriver driver;
	private Pomscenario13 pomscenario13;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario13 = new Pomscenario13(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario13.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2, dependsOnMethods = "testHomePageVisibility")
	public void productselect() {
		pomscenario13.productsclick();

	}

	@Test(priority = 3, dependsOnMethods = "productselect")
	public void testproductdetailsVisibility() {
		boolean isviewproductVisible = pomscenario13.isviewproductVisible();
		Assert.assertTrue(isviewproductVisible, "PRODUCT DETAILS NOT SHOWN");

	}

	@Test(priority = 4, dependsOnMethods = "testproductdetailsVisibility")
	public void quantity() {
		pomscenario13.clickIncreaseButton("4");
	}

	@Test(priority = 5, dependsOnMethods = "quantity")
	public void addcartvisible() {
		pomscenario13.addcartbutton();
		pomscenario13.viewcartitem();

	}

	@Test(priority = 6, dependsOnMethods = "addcartvisible")
	public void itemVisibilityincart() {
		boolean isitemsVisible = pomscenario13.isitemsVisible();
		Assert.assertTrue(isitemsVisible, "PRODUCT DETAILS NOT SHOWN");

	}

	@Test(priority = 7, dependsOnMethods = "itemVisibilityincart")
	public void itemquantityVisibilityincart() {
		boolean isitemsquantityVisible = pomscenario13.isitemsquantityVisible();
		Assert.assertTrue(isitemsquantityVisible, "PRODUCT DETAILS NOT SHOWN");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
