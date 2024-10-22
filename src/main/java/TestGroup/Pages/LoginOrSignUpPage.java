package TestGroup.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestGroup.Utilities.ReusableMethods;

public class LoginOrSignUpPage extends ReusableMethods{
	
	WebDriver driver;
	public LoginOrSignUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//Page Objects
@FindBy(xpath="//h2[text()='New User Signup!']")
WebElement newUserSignUpText;

@FindBy(css = "input[name=email]:nth-child(2)")
WebElement existingUserEmail;

@FindBy(name = "password")
WebElement existingUserPassword;

@FindBy(name="name")
WebElement newUserNameField;

@FindBy(css="input[name='email']:nth-child(3)")
WebElement newUserEmailField;

@FindBy(xpath="//button[text()='Signup']")
WebElement signUpButton;

@FindBy(xpath="//button[text()='Login']")
WebElement loginButton;

@FindBy(xpath="//p[text()='Your email or password is incorrect!']")
WebElement incorrectEmailorPWD;


@FindBy(xpath="//p[text()='Email Address already exist!']")
WebElement emailExists;

//Action Methods

public boolean newUserSignUpPageDisplayed()

//Action Methods


{
	Boolean isVisible = webElementisDisplayed(newUserSignUpText);
	return isVisible;
}

public void enterNameEmailandSignUp(String newUserName, String newUserEmail)
{
	enterDataInTextField(newUserNameField, newUserName);
	enterDataInTextField(newUserEmailField, newUserEmail);
	performClick(signUpButton);
	}

public void existinguserLogin(String existUserEmail, String existUserPwd)
{

	enterDataInTextField(existingUserEmail,existUserEmail);
	enterDataInTextField(existingUserPassword, existUserPwd);
	performClick(loginButton);
}

public boolean noUserFound()
{
return incorrectEmailorPWD.isDisplayed();
	
}


public boolean emailAlreadyExists()
{
	return emailExists.isDisplayed();
	}




}
