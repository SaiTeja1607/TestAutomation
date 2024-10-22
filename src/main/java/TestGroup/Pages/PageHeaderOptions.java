package TestGroup.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestGroup.Utilities.ReusableMethods;

public class PageHeaderOptions extends ReusableMethods{
	
	WebDriver driver;
	public PageHeaderOptions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//Page Objects	
@FindBy(xpath="//a[@href='/login']")
WebElement signUpOrLoginButton;

@FindBy(xpath="//i[@class='fa fa-user']/parent::a")
WebElement loggedinUserInfo;

@FindBy(partialLinkText="Delete Account")
WebElement deleteAccount;

@FindBy(xpath="//a[@href='/logout']")
WebElement logOutButton;

@FindBy(css="a[href='/contact_us']")
WebElement contactUsButton;

@FindBy(linkText="Home")
WebElement homeButton;

//Action Methods


public void clickOnLoginOrSignUpButton()
{
	performClick(signUpOrLoginButton);	
	
}

public String loggedInAsUser()
{
	String loggedInUser =	loggedinUserInfo.getText();
	System.out.println(loggedInUser);
	return loggedInUser;
}

public void deleteAccount() 
{
	performClick(deleteAccount);
}

public void logOutUser()
{
	performClick(logOutButton);
}

public void clickOnContactUsButton()
{
	performClick(contactUsButton);
}

public void clickOnHomeButton()
{
performClick(homeButton);	
}

}
