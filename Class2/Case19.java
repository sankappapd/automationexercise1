package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario19;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case19 {
	private WebDriver driver;
	private Pomscenario19 pomscenario19;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario19 = new Pomscenario19(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void POLOPRODUCTS() {
		pomscenario19.PRODUCTS();
		pomscenario19.poloPRODUCTS();

	}

	@Test(priority = 2, dependsOnMethods = "POLOPRODUCTS")
	public void VERIFYPOLOPRODUCTS() {
		pomscenario19.verifypolobrandPageIsVisible();

	}

	@Test(priority = 3, dependsOnMethods = "VERIFYPOLOPRODUCTS")
	public void HMPRODUCTS() {
		pomscenario19.hmPRODUCTS();

	}

	@Test(priority = 4, dependsOnMethods = "HMPRODUCTS")
	public void verifyHMPRODUCTS() {
		pomscenario19.verifyhmbrandPageIsVisible();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
