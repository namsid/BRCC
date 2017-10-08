package generic;

public interface IAutoConstant 
{
	String CHROME_KEY = "webdriver.chrome.driver";
	String CHROME_VALUE = "./driver/chromedriver.exe";
	
	String GECKO_KEY = "webdriver.gecko.driver";
	String GECKO_VALUE = "./driver/geckodriver.exe";
	// we are telling the path of configuration file where ./means current project
	String CONFIG_PATH ="./config.properties";
	String XLPATH="./data/input.xlsx";
	

}
