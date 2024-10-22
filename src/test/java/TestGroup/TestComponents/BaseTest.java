package TestGroup.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import TestGroup.Pages.ContactUsPage;
import TestGroup.Pages.EnterAccountInfoPage;
import TestGroup.Pages.LoginOrSignUpPage;
import TestGroup.Pages.PageHeaderOptions;

public class BaseTest {

	public WebDriver driver;
	
	

	public WebDriver initializeDriver(String url) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\masineni.s.teja\\eclipse-workspace\\TestAutomation\\src\\main\\java\\TestGroup\\TestResources\\TestResources.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.equals("firefix")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(url);
		return driver;

	}

	@BeforeMethod
	public void goToWebsite() throws IOException {
		initializeDriver("https://automationexercise.com/");
	}

	public void CreateUser(String name, String email,String gender, String fullName, String password, String date, String month, String year, String firstName, String lastName, String companyName, String area, String city, String country, String state,
			String district, String zip, String phone)
	{
		
		PageHeaderOptions pageHeaderOptions = new PageHeaderOptions(driver);
		pageHeaderOptions.clickOnLoginOrSignUpButton();
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.enterNameEmailandSignUp(name, email);
		EnterAccountInfoPage enterAccountInfoPage = new EnterAccountInfoPage(driver);
		enterAccountInfoPage.enterAccountDetails(gender, fullName, password, date, month, year);
		enterAccountInfoPage.enterAddressInfo(firstName, lastName, companyName, area, city, country, state,
				district, zip, phone);
		enterAccountInfoPage.createAccount();
		
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
