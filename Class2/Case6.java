package Class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom2.Pomscenario6;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case6 {
	private WebDriver driver;
	private Pomscenario6 pomscenario6;
	String path = ("C:\\Users\\SANKAPPA-PC\\eclipse-workspace\\selenium\\Excelrproject1\\src\\test\\java\\Class2\\mysql-init.txt.txt");

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/"); // Replace with your login page URL
		pomscenario6 = new Pomscenario6(driver); // Corrected initialization
	}

	@Test
	public void testHomePageVisibility() {
		boolean isHomePageVisible = pomscenario6.isHomePageVisible();
		Assert.assertTrue(isHomePageVisible, "The homepage is not visible.");
	}

	@Test(dependsOnMethods = "testHomePageVisibility")
	public void contactushelp() {
		pomscenario6.contactclick();
	}

	@Test(dependsOnMethods = "contactushelp")
	public void getintouchvisiblity() {
		boolean getintouch = pomscenario6.getintouch();
		Assert.assertTrue(getintouch, "Get In Touch not visible");
	}

	@Test(dependsOnMethods = "getintouchvisiblity")
	public void detailsinfo() {
		pomscenario6.usernamelogin("sankappa");
		pomscenario6.emailid("sankupd33@gmail.com");
		pomscenario6.subjectbmessage("regarding error message");
		pomscenario6.messageinfo("please solve this error asap");
		pomscenario6.uploadfile(path);
		pomscenario6.submitbutton();
	}

	@Test(dependsOnMethods = "detailsinfo")
	public void successmessageVisibility() {
		boolean successmessage = pomscenario6.successmessage();
		Assert.assertTrue(successmessage, "NOT SUCCESS.");
		pomscenario6.homeclick();
	}

	public void testHomePage2Visibility() {
		boolean isHomePage2Visible = pomscenario6.isHomePage2Visible();
		Assert.assertTrue(isHomePage2Visible, "The homepage is not visible.");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
