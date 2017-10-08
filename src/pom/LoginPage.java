package pom;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.IAutoConstant;
import generic.Lib;

public class LoginPage 
{
	// declaring all the elements of the page
	
	@FindBy(id = "username")
	private WebElement UnTB;
	
	@FindBy(name="pwd")
	private WebElement PwTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//span[@class = 'errormsg']")
	private WebElement errorMSG;
	
	// Creating constructor of a class 
	
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String Un)
	{
		UnTB.sendKeys(Un);
		
	}
	
	public void setPassword(String Pwd)
	{
		PwTB.sendKeys(Pwd);
	}
	
	
	public void setInUserName()
	{	
		String iUN = Lib.getProperty(IAutoConstant.CONFIG_PATH, "InUN");
		UnTB.sendKeys(iUN);
		
	}
	
	public void setInPassword()
	{	
		String iPwd = Lib.getProperty(IAutoConstant.CONFIG_PATH, "InPWD");
		PwTB.sendKeys(iPwd);
	}
	
	public void clickLogin()
	{
		loginBTN.click();
	}
	
	public void errorMessageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait =  new WebDriverWait(driver,10);
		try
		{ 
			wait.until(ExpectedConditions.visibilityOf(errorMSG));
			Reporter.log("Pass:Error message is displayed",true);
		}
		
		catch(Exception e)
		{
			Reporter.log("Fail: Error message is not displayed", true);
			Assert.fail();// will make test case fail in TestNg
		}
	}
	
	
	
}
