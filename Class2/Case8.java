package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario8;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case8 {
	private WebDriver driver;
	private Pomscenario8 pomscenario8;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); 
		pomscenario8 = new Pomscenario8(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario8.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2)
	public void productselect() {
		pomscenario8.productsclick();
		
	}

	@Test(priority = 3)
	public void isproductsnameVisibility() {
		boolean isproductsVisible = pomscenario8.isproductsVisible();
		Assert.assertTrue(isproductsVisible, "NAME NOT VISIBLE.");
	}

	@Test(priority = 4)
	public void firstproductview() {
		pomscenario8.firstproductname();
	}

	@Test(priority = 5)
	public void isproductsbrandVisibility() {
		boolean isproductnameVisible = pomscenario8.isproductnameVisible();
		Assert.assertTrue(isproductnameVisible, "PRODUCT NAME NOT VISIBLE");
	}

	@Test(priority = 6)
	public void isproductscategoryVisibility() {
		boolean isproductscategoryVisible = pomscenario8.isproductscategoryVisible();
		Assert.assertTrue(isproductscategoryVisible, "CATEGORY NOT VISIBLE");
	}

	@Test(priority = 7)
	public void isproductsrateVisibility() {
		boolean isproductsrateVisible = pomscenario8.isproductsrateVisible();
		Assert.assertTrue(isproductsrateVisible, "RATE NOT VISIBLE");
	}

	@Test(priority = 8)
	public void isproductsavailabileVisibility() {
		boolean isproductsavailableVisible = pomscenario8.isproductsavailableVisible();
		Assert.assertTrue(isproductsavailableVisible, "AVAILABILITY NOT VISIBLE");
	}

	@Test(priority = 9)
	public void isproductsconditionVisibility() {
		boolean isproductsconditionVisible = pomscenario8.isproductsconditionVisible();
		Assert.assertTrue(isproductsconditionVisible, "CONDITION NOT VISIBLE");
	}

	@Test(priority = 10)
	public void isproductsVisibility() {
		boolean isproductsbrandVisible = pomscenario8.isproductsbrandVisible();
		Assert.assertTrue(isproductsbrandVisible, "BRAND NOT VISIBLE");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
