package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.LoginPage;

public class InvalidLogin extends BaseTest
{	
	//enter invalid Un
	@Test(priority=2)
	public void testInvalidLogin()
	{
	LoginPage l1 = new LoginPage(driver);
	//l1.setUserName("user");
	l1.setInUserName();
	
	//enter invalid password
	//l1.setPassword("xyz");
	l1.setInPassword();
	//click on login button
	l1.clickLogin();
	//verify that error message is displayed
	
	l1.errorMessageIsDisplayed(driver);
	
	}
	
	
}
