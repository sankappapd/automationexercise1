package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario4;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case4 {
	private WebDriver driver;
	private Pomscenario4 pomscenario4;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario4 = new Pomscenario4(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario4.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void signup() {
		pomscenario4.clicklogin();
	}

	@Test(dependsOnMethods = "signup")
	public void testloginVisibility() {
		boolean isloginaccountVisible = pomscenario4.isloginaccountVisible();
		Assert.assertTrue(isloginaccountVisible, "login to account not visible.");
	}

	@Test(dependsOnMethods = "testloginVisibility")
	public void details() {
		pomscenario4.usernamelogin("sankupd7875@gmail.com");
		pomscenario4.passwordenter("12345678");
		pomscenario4.clickloginbutton();
		pomscenario4.verifyuserlogIsVisible();
	}

	@Test(dependsOnMethods = "details")
	public void logout() {
		pomscenario4.clicklogoutbutton();
	}

	@Test(dependsOnMethods = "logout")
	public void loginpage() {
		pomscenario4.isloginVisible();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
