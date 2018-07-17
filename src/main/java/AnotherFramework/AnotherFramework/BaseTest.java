package AnotherFramework.AnotherFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest 
{
	public	WebDriver driver;	
	public WebDriver selectBrowser(String browsername, String baseurl)
	{
		browsername=browsername.toLowerCase();
		switch(browsername)
		{
		case "chrome": 
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver= new ChromeDriver();driver.get(baseurl);
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("", "");
			driver= new FirefoxDriver();driver.get(baseurl);
			break;
		case "ie":
			System.setProperty("", "");
			driver= new InternetExplorerDriver();driver.get(baseurl);
			break;
		default : System.out.println("invalid browser");  System.exit(0);break;
		}
		return driver;
	}
}
