package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario7;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Class7 {
	private WebDriver driver;
	private Pomscenario7 pomscenario7;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario7 = new Pomscenario7(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario7.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test
	public void Testcase() {
		pomscenario7.testcaseclick();
	}

	public void testtestcaseVisibility() {
		boolean istestcasePageVisible = pomscenario7.istestcasePageVisible();
		Assert.assertTrue(istestcasePageVisible, "The homepage is not visible.");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
