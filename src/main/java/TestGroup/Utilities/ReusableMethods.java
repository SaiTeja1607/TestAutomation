package TestGroup.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ReusableMethods {
	WebDriver driver;
	
	public ReusableMethods(WebDriver driver) {
		super();

		this.driver=driver;
	}

	public boolean webElementisDisplayed(WebElement element)
	{
		Boolean webElementIsDisplayed = element.isDisplayed();
		return webElementIsDisplayed;
	
	}
	
	public void enterDataInTextField(WebElement element, String data)
	{
		element.sendKeys(data);
	}
	
	public void selectFromDropdown(WebElement element, String data)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(data);
	}
	
	public void performActionsOnTextField(WebElement element, String data)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().sendKeys(data).build().perform();
	}
	
	public void performClick(WebElement element)
	{
		element.click();
	}
	
	public void takeScreenshot() throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		 File src = ss.getScreenshotAs(OutputType.FILE);
		 File dest = new File("C:\\Users\\masineni.s.teja\\eclipse-workspace\\SeleniumFramework\\test-output\\Default suite\\Screenshots\\screenshot.png");
		FileUtils.copyFile(src, dest);
		
	}
	
	public void getTitleOfPage()
	{
		driver.getTitle();
	}
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
		
	}
}
