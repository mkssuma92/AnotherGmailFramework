package AnotherFramework.AnotherFramework;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomepageScenario 
{
	WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		BaseTest basetest = new BaseTest();
		driver=basetest.selectBrowser(UtilConstants.browsername, UtilConstants.baseurl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void teardown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(description="compose email - send")
	public void test1()
	{
		LoginPage loginpage = new LoginPage(driver);
		String title=loginpage.validLogin(UtilConstants.username, UtilConstants.password,UtilConstants.homepagetitle);
		Assert.assertTrue(title.contains(UtilConstants.homepagetitle));
		
		HomePage homepage = new HomePage(driver);
		homepage.clickcomposeEmailbttn();
		
		ComposePage compose = new ComposePage(driver);
		compose.composemaildata(UtilConstants.to, UtilConstants.sub, UtilConstants.body);
		
		homepage.clicksentEmailbttn();
		SentPage sendemail= new SentPage(driver);
		sendemail.findsentEmail(UtilConstants.sub);
		String t= sendemail.getEmailTitle();
		Assert.assertTrue(t.contains(UtilConstants.sub), "fail to find email");
	}
}
