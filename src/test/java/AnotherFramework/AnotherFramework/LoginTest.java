package AnotherFramework.AnotherFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		BaseTest basetest = new BaseTest();
		driver=basetest.selectBrowser(UtilConstants.browsername, UtilConstants.baseurl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	@Test(description="valid login with valid credentials")
	public void test1()
	{
		LoginPage loginpage = new LoginPage(driver);
		String title=loginpage.validLogin(UtilConstants.username, UtilConstants.password, UtilConstants.homepagetitle);
		Assert.assertTrue(title.contains(UtilConstants.homepagetitle),"fail to login");
	}
	
	@Test(description="valid login with Invalid credentials")
	public void test2()
	{
		LoginPage loginpage = new LoginPage(driver);
		String err=loginpage.InvalidLogin(UtilConstants.username, UtilConstants.wrongpassword);
		Assert.assertTrue(err.contains("Wrong password"),"might some error in page or logged in");
	}
	
	
	
}
