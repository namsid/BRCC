package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public abstract class BaseTest implements IAutoConstant
{
	public WebDriver driver;
	
	static 
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		
	}

	@Parameters({"node","browser"})
	@BeforeMethod
	public void openApplication(String node, String browser) throws MalformedURLException
	{	
		//Old valaue if not runinng on grid
		//driver=new ChromeDriver();
		
		//new value if using grid 
		URL whichSystem = new URL(node);
		DesiredCapabilities whichBrowser = new DesiredCapabilities();
		whichBrowser.setBrowserName(browser);
		driver=new RemoteWebDriver(whichSystem,whichBrowser);	
		driver.manage().window().maximize();
		String URL = Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(URL);//open the browser from property file		
		//long ITO = Long.parseLong(Lib.getProperty(CONFIG_PATH, "ITO"));		
		driver.get("https://demo.actitime.com/login.do;");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void closeApplication()
	{
		driver.close();
	}
	

}
