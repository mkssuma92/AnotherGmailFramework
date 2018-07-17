package AnotherFramework.AnotherFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SentPage extends HomePage
{

	public SentPage(WebDriver driver) 
	{
		super(driver);
	}
	public void findsentEmail(String title)
	{
		WebElement tble=null;
		int count=0;
		while(count<3)
		{
			try
			{
				res.explicitwait(rep.sentemailtable);
				tble= driver.findElement(rep.sentemailtable);
				count=count+3;
			}
			catch (Exception e) 
			{
				System.out.println("exception occured in sent email table " );
				count=count+1; continue;
			}
		}		
		List<WebElement> row =tble.findElements(By.tagName("tr"));
		for(int i=0; i<row.size();i++)
		{
			List<WebElement> col=row.get(i).findElements(By.tagName("td"));
			for(int j=0; j<col.size();j++)
			{
				String text=col.get(j).getText();
				if(text.contains(title))
				{
					col.get(j).click(); break;
				}
			}
		}
	}

	public String getEmailTitle()
	{
		res.explicitwait(rep.emailtitle);
		return res.getElementText(rep.emailtitle);
	}
}
