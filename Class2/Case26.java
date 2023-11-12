package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario26;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case26 {
	private WebDriver driver;
	private Pomscenario26 pomscenario26;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario26 = new Pomscenario26(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void Homepage() {
		pomscenario26.verifyHomePageIsVisible();

	}

	@Test(priority = 2)
	public void scrolljs() {
		pomscenario26.scroll();
	}

	@Test(priority = 3)
	public void subscriptionverify() {
		pomscenario26.verifysubscriptionIsVisible();

	}

	@Test(priority = 4)
	public void verifyhometext() {
		pomscenario26.clickup();
		pomscenario26.verifyengineertextIsVisible();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
