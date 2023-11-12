package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario3;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case3 {
	private WebDriver driver;
	private Pomscenario3 pomscenario3;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario3 = new Pomscenario3(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario3.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void signup() {
		pomscenario3.clicklogin();
	}

	@Test(dependsOnMethods = "signup")
	public void testloginVisibility() {
		boolean isloginaccountVisible = pomscenario3.isloginaccountVisible();
		Assert.assertTrue(isloginaccountVisible, "login to account not visible.");
	}

	@Test(dependsOnMethods = "testloginVisibility")
	public void details() {
		pomscenario3.usernamelogin("sankupd33@gmail.cm");
		pomscenario3.passwordenter("123456789");
		pomscenario3.clickloginbutton();

	}

	@Test(dependsOnMethods = "testloginVisibility")
	public void emailorpasswordincorrect() {
		boolean emailerror = pomscenario3.emailerror();
		Assert.assertTrue(emailerror, "login successful");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
