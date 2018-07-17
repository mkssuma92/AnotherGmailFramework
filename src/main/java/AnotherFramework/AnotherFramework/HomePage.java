package AnotherFramework.AnotherFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	ReusableMethods res;
	Repositorys rep ;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		res = new ReusableMethods(driver);
		rep = PageFactory.initElements(driver, Repositorys.class);
	}

	public void clickcomposeEmailbttn()
	{
		int count=0;
		while(count<3)
		{
			try
			{
				res.clickElement(rep.componselink);
				res.explicitwait(rep.sendlink);
				count=count+3;
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in compose email " );
				count=count+1; continue;
			}
		}


	}

	public void clicksentEmailbttn()
	{
		int count=0;
		while(count<3)
		{
			try
			{
				res.clickElement(rep.sentemaillink);
				res.explicitwait("Sent");
				count=count+3;
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in sent email " );
				count=count+1; continue;
			}
		}
	}

	public void clickdraftEmailbtn()
	{
		int count=0;
		while(count<3)
		{
			try
			{
				res.clickElement(rep.draftllink);
				res.explicitwait("Drafts");
				count=count+3;
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in sent email " );
				count=count+1; continue;
			}
		}
	}
}
