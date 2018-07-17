package AnotherFramework.AnotherFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods 
{
	WebDriver driver;
	WebDriverWait wait;
	public ReusableMethods(WebDriver driver)
	{
		wait = new WebDriverWait(driver, 30);
		this.driver=driver;
	}

	public void typetext(By locator, String text)
	{
		driver.findElement(locator).sendKeys(text);
	}

	public void clickElement(By locator)
	{
		driver.findElement(locator).click();
	}

	public void clearElement(By locator)
	{
		driver.findElement(locator).clear();
	}

	public String getElementText(By locator)
	{
		return driver.findElement(locator).getText();
	}

	public String getpagetitle()
	{
		return driver.getTitle();
	}

	public void explicitwait(By locator)
	{		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void explicitwait(By locator, WebElement ifrequired)
	{	
		WebElement x=driver.findElement(locator);
		wait.until(ExpectedConditions.elementToBeClickable(x));
	}

	public void explicitwait(String title)
	{	
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void explicitwait(String value, By locator)
	{	
		wait.until(ExpectedConditions.textToBe(locator, value));
	}

	public void selectdropdownItems(By locator, By commonlocator, String value)
	{
		clickElement(locator);
		int count=0;
		while(count<3)
		{
			try
			{
				List<WebElement> list1 =driver.findElements(commonlocator);
				for (WebElement var : list1) 
				{
					if(var.getText().equals(value))
					{
						var.click();
						count=count+3;
						break;
					}
				}
			}
			catch (Exception e) {
				System.out.println("exception in select dropdown " + e);
				count = count+1; continue;
			}
		}
	}
	
	public void workwithMutlipleLoctor(By commonlocator, String value)
	{		
		int count=0;
		while(count<3)
		{
			try
			{
				List<WebElement> list1 =driver.findElements(commonlocator);
				for (WebElement var : list1) 
				{
					System.out.println(var.getText());
					if(var.getText().contains(value))
					{
						var.click();
						count=count+3;
						break;
					}
				}
			}
			catch (Exception e) {
				System.out.println("exception in workwithMutlipleLoctor " + e);
				count = count+1; continue;
			}
		}
	}
}