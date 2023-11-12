package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario21;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case21 {
	private WebDriver driver;
	private Pomscenario21 pomscenario21;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario21 = new Pomscenario21(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void PRODUCTSbutton() {
		pomscenario21.PRODUCTS();
	}

	@Test(priority = 2, dependsOnMethods = "PRODUCTSbutton")
	public void VERIFYPOLOPRODUCTS() {
		pomscenario21.verifyallproductsIsVisible();
		pomscenario21.viewPRODUCTS();

	}

	@Test(priority = 3, dependsOnMethods = "VERIFYPOLOPRODUCTS")
	public void verifyreview() {
		pomscenario21.verifiswritereviewvisibleIsVisible();
		pomscenario21.nametoreview("sankappa");
		pomscenario21.emailtoreview("sankupd33@gmail");
		pomscenario21.descriptiontoreview("quality of the product is awesome");
		pomscenario21.submit();
	}

	@Test(priority = 4, dependsOnMethods = "verifyreview")
	public void reviewsuccessmessage() {
		pomscenario21.verifysuccessreviewIsVisible();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
