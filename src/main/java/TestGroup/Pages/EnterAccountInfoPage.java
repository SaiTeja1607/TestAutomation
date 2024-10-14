package TestGroup.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestGroup.Utilities.ReusableMethods;

public class EnterAccountInfoPage extends ReusableMethods{

	WebDriver driver;
	public EnterAccountInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Page Objects
@FindBy(xpath="//b[text()='Enter Account Information']")	
WebElement eaiText;

@FindBy(xpath="//div[@class='radio-inline']")
List<WebElement> genders;

@FindBy(id="name")
WebElement enterName;
	
@FindBy(id="password")
WebElement enterPassword;

@FindBy(id="days")
WebElement selectDOBDate;

@FindBy(id="months")
WebElement selectDOBMonth;

@FindBy(id="years")
WebElement selectDOBYear;

@FindBy(xpath="//label[text()='Sign up for our newsletter!']")
WebElement newsLetterSignUpCheckbox;

@FindBy(xpath="//label[text()='Receive special offers from our partners!']")
WebElement receiveSpecialOffersCheckbox;

@FindBy(id="first_name")
WebElement enterFirstName;

@FindBy(id="last_name")
WebElement enteLastName;

@FindBy(id="company")
WebElement enterCompanyName;

@FindBy(id="address1")
WebElement enterAddr1;

@FindBy(id="address2")
WebElement enterAddr2;

@FindBy(id="country")
WebElement selectCountry;

@FindBy(id="state")
WebElement enterState;

@FindBy(id="city")
WebElement enterCity;

@FindBy(id="zipcode")
WebElement enterZip;

@FindBy(id="mobile_number")
WebElement enterMobileNum;

@FindBy(css="button[data-qa='create-account']")
WebElement createAccountButton;
	
//Action Methods	
	
public Boolean enterAccountInfoTextDisplayed()
{
Boolean eaiTextVisible =	eaiText.isDisplayed();
return eaiTextVisible;
}

public void enterAccountDetails(String yourGender, String updateName, String password, String selectDate, String selectMonth, String selectYear)
{
	//select gender
	for (int i = 0; i < genders.size(); i++) {
		String gender = genders.get(i).getText();
		if (gender.equalsIgnoreCase(yourGender)) {
			genders.get(i).click();
		}
	}
	
	performActionsOnTextField(enterName, updateName);
	
	enterDataInTextField(enterPassword, password);
	
	selectFromDropdown(selectDOBDate, selectDate);

	selectFromDropdown(selectDOBMonth, selectMonth);
	
	selectFromDropdown(selectDOBYear, selectYear);
	
	performClick(newsLetterSignUpCheckbox);
	
	performClick(receiveSpecialOffersCheckbox);
	
}

public void enterAddressInfo(String firstName,String lastName,String enterCompany,String Addr1,String Addr2,String country,String state,String city,String zipcode,String mobNum)
{
	enterDataInTextField(enterFirstName, firstName);
	enterDataInTextField(enteLastName, lastName);
	enterDataInTextField(enterCompanyName, enterCompany);
	enterDataInTextField(enterAddr1, Addr1);
	enterDataInTextField(enterAddr2, Addr2);
	selectFromDropdown(selectCountry, country);
	enterDataInTextField(enterState, state);
	enterDataInTextField(enterCity, city);
	enterDataInTextField(enterZip, zipcode);
	enterDataInTextField(enterMobileNum, mobNum);
	
	
	
	
			
}

public void createAccount()
{
	createAccountButton.click();
}
	
	
	
	
}
