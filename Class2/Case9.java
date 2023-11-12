package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario9;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case9 {
	private WebDriver driver;
	private Pomscenario9 pomscenario9;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario9 = new Pomscenario9(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario9.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2)
	public void productselect() {
		pomscenario9.productsclick();
	}

	@Test(priority = 3)
	public void isproductsnameVisibility() {
		boolean isproductsVisible = pomscenario9.isproductsVisible();
		Assert.assertTrue(isproductsVisible, "NAME NOT VISIBLE.");
	}

	@Test(priority = 4)
	public void search1() {
		pomscenario9.Searchitem("jeans");
		pomscenario9.searchclick();
	}

	@Test(priority = 4)
	public void issearchedproductVisibility() {
		boolean issearchedproductsVisible = pomscenario9.issearchedproductsVisible();
		Assert.assertTrue(issearchedproductsVisible, "SEARCHED PRODUCTS NOT VISIBLE.");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
