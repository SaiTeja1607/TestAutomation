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


}
