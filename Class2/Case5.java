package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario5;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case5 {
	private WebDriver driver;
	private Pomscenario5 pomscenario5;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario5 = new Pomscenario5(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario5.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void signup() {
		pomscenario5.clicklogin();
	}

	@Test(dependsOnMethods = "signup")
	public void ISNEWUSERSIGNUPVisibility() {
		boolean NEWUSERSignupvisible = pomscenario5.NEWUSERSignupvisible();
		Assert.assertTrue(NEWUSERSignupvisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "ISNEWUSERSIGNUPVisibility")
	public void details() {
		pomscenario5.usernamelogin("sankappa1");
		pomscenario5.emailid("sankupd333@gmail.com");
		pomscenario5.signupbutton();
	}

	@Test(dependsOnMethods = "details")
	public void emailalreadyexist() {
		boolean erroraemailexist = pomscenario5.erroraemailexist();
		Assert.assertTrue(erroraemailexist, "Email Address already exist!");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
