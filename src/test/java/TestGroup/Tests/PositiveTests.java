package TestGroup.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import TestGroup.Pages.AccountCreatedorDeletedConfirmationPage;
import TestGroup.Pages.ContactUsPage;
import TestGroup.Pages.EnterAccountInfoPage;
import TestGroup.Pages.LoginOrSignUpPage;
import TestGroup.Pages.PageHeaderOptions;
import TestGroup.TestComponents.BaseTest;

public class PositiveTests extends BaseTest {

	
@Test
public void verifyLoginWithCorrectCreds()
{
	//update this later to remove driver. here
	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Automation Exercise"));
	PageHeaderOptions pageHeaderOptions = new PageHeaderOptions(driver);
	pageHeaderOptions.clickOnLoginOrSignUpButton();
	Boolean isvisible = driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
	Assert.assertTrue(isvisible);
	AccountCreatedorDeletedConfirmationPage AccountCreatedorDeletedConfirmationPage = new AccountCreatedorDeletedConfirmationPage(driver);
	String existingUserEmail= "Tejas@gmail.com";
	String existingUserPassword = "Test#111";
	LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
	loginOrSignUpPage.existinguserLogin(existingUserEmail, existingUserPassword);
	String firstName = "Test";
	String lastName = "Name";
	
	try{
	if(loginOrSignUpPage.noUserFound())
	{
		CreateUser("Test", existingUserEmail, "Mr.", " Name", existingUserPassword, "8", "April", "2002", firstName, lastName, "TSG", "HSR", "Blr", "India", "Karnataka",
			"Bangalore", "560098", "9876543456");
		AccountCreatedorDeletedConfirmationPage.continueProcess();
		pageHeaderOptions.logOutUser();
		loginOrSignUpPage.existinguserLogin(existingUserEmail, existingUserPassword);
	}}
	catch
	( Exception e)
			{ }
	
	//if(driver.getTitle().equalsIgnoreCase("Automation Exercise - Signup / Login"))
	String loggedInUser = pageHeaderOptions.loggedInAsUser();
	String expectedUser = "Logged in as " + firstName + " " + lastName;
	Assert.assertTrue(expectedUser.equalsIgnoreCase(loggedInUser));
	
	pageHeaderOptions.deleteAccount();
	
	Boolean isDisplayed = AccountCreatedorDeletedConfirmationPage.accountDeletedConfirmationDisplayed();
	Assert.assertTrue(isDisplayed);
	}

@Test(retryAnalyzer = TestGroup.TestComponents.Retry.class)
public void logOutUser()
{
	 PageHeaderOptions pageHeaderOptions = new PageHeaderOptions(driver);
	 LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
	 
	Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Automation Exercise"));
	
	pageHeaderOptions.clickOnLoginOrSignUpButton();
	Boolean isvisible = driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
	Assert.assertTrue(isvisible);
	AccountCreatedorDeletedConfirmationPage AccountCreatedorDeletedConfirmationPage = new AccountCreatedorDeletedConfirmationPage(driver);
	String existingUserEmail= "Tejas@gmail.com";
	String existingUserPassword = "Test#111";
	
	loginOrSignUpPage.existinguserLogin(existingUserEmail, existingUserPassword);
	String firstName = "Test";
	String lastName = "Name";
	
	try{
	if(loginOrSignUpPage.noUserFound())
	{
		CreateUser("Test", existingUserEmail, "Mr.", " Name", existingUserPassword, "8", "April", "2002", firstName, lastName, "TSG", "HSR", "Blr", "India", "Karnataka",
			"Bangalore", "560098", "9876543456");
		AccountCreatedorDeletedConfirmationPage.continueProcess();
		pageHeaderOptions.logOutUser();
		loginOrSignUpPage.existinguserLogin(existingUserEmail, existingUserPassword);
	}}
	catch
	( Exception e)
			{ }
	
	//if(driver.getTitle().equalsIgnoreCase("Automation Exercise - Signup / Login"))
	String loggedInUser = pageHeaderOptions.loggedInAsUser();
	String expectedUser = "Logged in as " + firstName + " " + lastName;
	Assert.assertTrue(expectedUser.equalsIgnoreCase(loggedInUser));
	pageHeaderOptions.logOutUser();
	String currentPageTitle = driver.getTitle();
	Assert.assertTrue(currentPageTitle.equalsIgnoreCase("Automation Exercise - Signup / Login"));
}

	@Test
	public void contactUsForm()
	{
		PageHeaderOptions pageHeaderOptions = new PageHeaderOptions(driver);
		
		 ContactUsPage contactUsPage = new ContactUsPage(driver);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Automation Exercise"));
		pageHeaderOptions.clickOnContactUsButton();
		Assert.assertTrue(contactUsPage.getinTouchVisible());
		contactUsPage.enterDetailsandSubmit();
		contactUsPage.acceptAlert();
		Assert.assertTrue(contactUsPage.successMessageisVisible());
		pageHeaderOptions.clickOnHomeButton();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Automation Exercise"));
		
	}
	
}