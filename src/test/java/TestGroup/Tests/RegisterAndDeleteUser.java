package TestGroup.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestGroup.Pages.AccountCreatedorDeletedConfirmationPage;
import TestGroup.Pages.EnterAccountInfoPage;
import TestGroup.Pages.LoginOrSignUpPage;
import TestGroup.Pages.PageHeaderOptions;
import TestGroup.TestComponents.BaseTest;

public class RegisterAndDeleteUser extends BaseTest{

	@Test
	public void RegisterAndDeleteUserTest() {

//Launch Browser
//Navigate to url

		
//Verify Homepage is visible successfully
		String homePagetitle = driver.getTitle();
		String expectedTitle = "Automation Exercise";
		Assert.assertTrue(homePagetitle.equalsIgnoreCase(expectedTitle));

//Click on 'Signup / Login' button
		PageHeaderOptions pageHeaderOptions = new PageHeaderOptions(driver);
		pageHeaderOptions.clickOnLoginOrSignUpButton();

//Verify 'New User Signup!' is visible
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		Boolean isVisible = loginOrSignUpPage.newUserSignUpPageDisplayed();
		Assert.assertTrue(isVisible);

//Enter name and email address		
//Click 'Signup' button
		loginOrSignUpPage.enterNameEmailandSignUp("Teja", "masinenisaiteja@gmail.com");

//Verify that 'ENTER ACCOUNT INFORMATION' is visible
		EnterAccountInfoPage enterAccountInfoPage = new EnterAccountInfoPage(driver);
		Boolean eaiTextVisible = enterAccountInfoPage.enterAccountInfoTextDisplayed();
		Assert.assertTrue(eaiTextVisible);

//Fill details: Title, Name, Email, Password, Date of birth		
//Select checkbox 'Sign up for our newsletter!'
//Select checkbox 'Receive special offers from our partners!'
		enterAccountInfoPage.enterAccountDetails("Mr.", " Patel", "TestPassword", "7", "May", "1996");

//Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number		
//Click 'Create Account button'
		String firstName = "Teja";
		String lastName = "Patel";
		enterAccountInfoPage.enterAddressInfo(firstName, lastName, "ITT", "BTM", "Bangalore", "Australia", "Telangana",
				"Hyderabad", "599872", "9876543210");
		enterAccountInfoPage.createAccount();

//Verify that 'ACCOUNT CREATED!' is visible
		AccountCreatedorDeletedConfirmationPage AccountCreatedorDeletedConfirmationPage = new AccountCreatedorDeletedConfirmationPage(
				driver);
		Boolean accountCreated = AccountCreatedorDeletedConfirmationPage.accountCreatedConfirmationDisplayed();
		Assert.assertTrue(accountCreated);

//Click 'Continue' button
		AccountCreatedorDeletedConfirmationPage.continueProcess();

//Verify that 'Logged in as username' is visible
		String loggedInUser = pageHeaderOptions.loggedInAsUser();
		String expectedUser = "Logged in as " + firstName + " " + lastName;
		Assert.assertTrue(expectedUser.equalsIgnoreCase(loggedInUser));

//Click 'Delete Account' button
		pageHeaderOptions.deleteAccount();

//Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		Boolean accountDeleted = AccountCreatedorDeletedConfirmationPage.accountDeletedConfirmationDisplayed();
		Assert.assertTrue(accountDeleted);
		AccountCreatedorDeletedConfirmationPage.continueProcess();
		System.out.println("User Successfully Deleted!");
		
	}

}
