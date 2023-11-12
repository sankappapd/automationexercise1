package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario2;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case2 {
	private WebDriver driver;
	private Pomscenario2 pomscenario2;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario2 = new Pomscenario2(driver); // Corrected initialization
	}

	@Test

	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario2.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void signup() {
		pomscenario2.clicklogin();
	}

	@Test(dependsOnMethods = "signup")
	public void testloginVisibility() {
		boolean isloginaccountVisible = pomscenario2.isloginaccountVisible();
		Assert.assertTrue(isloginaccountVisible, "login to account not visible.");
	}

	@Test(dependsOnMethods = "testloginVisibility")
	public void details() {
		pomscenario2.usernamelogin("sankupd33@gmail.com");
		pomscenario2.passwordenter("123456789");
		pomscenario2.clickloginbutton();
		pomscenario2.verifyuserlogIsVisible();
		pomscenario2.deletebutton();
		pomscenario2.verifyuserdeleteIsVisible();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
