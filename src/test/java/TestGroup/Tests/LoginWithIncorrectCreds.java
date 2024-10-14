package TestGroup.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestGroup.Pages.AccountCreatedorDeletedConfirmationPage;
import TestGroup.Pages.LoginOrSignUpPage;
import TestGroup.Pages.PageHeaderOptions;
import TestGroup.TestComponents.BaseTest;
import TestGroup.Utilities.ReusableMethods;

public class LoginWithIncorrectCreds extends BaseTest{

@Test
public void loginWithIncorrectUserNameAndPassWord()
{
	//update this later to remove driver. here
	Boolean homePageTitle = driver.getTitle().equalsIgnoreCase("Automation Exercise");
	Assert.assertTrue(homePageTitle);
	
	PageHeaderOptions PageHeaderOptions = new PageHeaderOptions(driver);
	PageHeaderOptions.clickOnLoginOrSignUpButton();
	
	Boolean isvisible = driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
	Assert.assertTrue(isvisible);
	LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
	loginOrSignUpPage.existinguserLogin("mike@gmail.com", "Mike123");
	
	Assert.assertTrue(loginOrSignUpPage.noUserFound());
	
}


	
	
}