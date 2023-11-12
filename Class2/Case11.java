package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario11;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case11 {
	private WebDriver driver;
	private Pomscenario11 pomscenario11;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario11 = new Pomscenario11(driver); // Corrected initialization
	}

	@Test(priority = 1)
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario11.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");

	}

	@Test(priority = 2)
	public void scrolljs() {
		pomscenario11.cartbutton();
		pomscenario11.scroll();
		pomscenario11.emailid("sankupd33@gmail.com");
		pomscenario11.arrowbutton();
	}

	@Test(priority = 3)
	public void testemailsuccessPageVisibility() {
		boolean issuccessfulemailVisible = pomscenario11.issuccessfulemailVisible();
		Assert.assertTrue(issuccessfulemailVisible, "SUBSCRIPTION NOT SUCCESSFUL.");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
