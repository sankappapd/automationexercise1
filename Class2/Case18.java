package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario18;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case18 {
	private WebDriver driver;
	private Pomscenario18 pomscenario18;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario18 = new Pomscenario18(driver); // Corrected initialization
	}

	@Test
	public void Homepage() {
		pomscenario18.verifyHomePageIsVisible();

	}

	@Test(priority = 1, dependsOnMethods = "Homepage")
	public void womenCategories() {
		pomscenario18.verifycategoriesIsVisible();
		pomscenario18.womencategory();
		pomscenario18.womentops();

	}

	@Test(priority = 2, dependsOnMethods = "womenCategories")
	public void womentopscategory() {
		pomscenario18.verifyHwomentopsIsVisible();

	}

	@Test(priority = 3, dependsOnMethods = "womentopscategory")
	public void menCategories() {
		pomscenario18.mencategory();
		pomscenario18.menjeans();

	}

	@Test(priority = 4, dependsOnMethods = "menCategories")
	public void menjeanscategory() {
		pomscenario18.verifyHmenjeansIsVisible();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
