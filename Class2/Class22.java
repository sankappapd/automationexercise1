package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario22;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Class22 {
	private WebDriver driver;
	private Pomscenario22 pomscenario22;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario22 = new Pomscenario22(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void scroll() {
		pomscenario22.scroll();
	}

	@Test(priority = 2)
	public void testrecommendedVisibility() {
		boolean isrecommendedVisible = pomscenario22.isrecommendedVisible();
		Assert.assertTrue(isrecommendedVisible, "RECOMENDED PRODUCTS NOT VISIBLE");
	}

	@Test(priority = 3)
	public void addingtocart() {
		pomscenario22.addtocarts();
		pomscenario22.clickcart();

	}

	@Test(priority = 4)
	public void testaddeditemsVisibility() {
		boolean isaddesitemsVisible = pomscenario22.isaddesitemsVisible();
		Assert.assertTrue(isaddesitemsVisible, "ADDED ITEMS NOT VISIBLE");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}