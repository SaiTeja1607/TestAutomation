package TestGroup.Pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestGroup.Utilities.ReusableMethods;

public class ContactUsPage extends ReusableMethods{

	WebDriver driver;
	public ContactUsPage(WebDriver driver) {		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//h2[text()='Get In Touch']")
WebElement getInTouch;

@FindBy(css="input[name='name']")
WebElement nameField;

@FindBy(name="email")
WebElement emailField;

@FindBy(xpath="//input[@name='subject']")
WebElement subjextField;

@FindBy(id="message")
WebElement enterMessage;

@FindBy(xpath="//input[@name='submit']")
WebElement submitButton;

@FindBy(className="alert-success")
List<WebElement> successMessage;

public boolean getinTouchVisible()
{
	return webElementisDisplayed(getInTouch);
}
	

public void enterDetailsandSubmit()
{
	enterDataInTextField(nameField, "Test name");
	enterDataInTextField(emailField, "Testundef@tests.com");
	enterDataInTextField(subjextField, "Test subject");
	enterDataInTextField(enterMessage, "Hi, this is a test message");
	performClick(submitButton);
}

public boolean successMessageisVisible()
{
List<String> message =	successMessage.stream().limit(1).map(s-> s.getText()).collect(Collectors.toList());
 return   message.get(0).contains("Success");
    
 }

}


