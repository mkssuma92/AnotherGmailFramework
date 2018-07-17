package AnotherFramework.AnotherFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	ReusableMethods lib;
	Repositorys rep ;
	public LoginPage(WebDriver driver)
	{
		lib=new ReusableMethods(driver);
		rep = PageFactory.initElements(driver, Repositorys.class);
		this.driver=driver;
	}
	
	private void setEmail(String emailid)
	{
		lib.explicitwait(rep.emailid);
		lib.typetext(rep.emailid, emailid);
	}
	
	private void clickNext()
	{
		lib.workwithMutlipleLoctor(rep.nextbtn, "NEXT");
	}
	
	private void setPassword(String password)
	{
		lib.explicitwait(rep.password);
		lib.typetext(rep.password, password);
	}
	
	public String validLogin(String emailid, String password, String homepagettile)
	{
		setEmail(emailid);
		clickNext();
		setPassword(password);
		clickNext();
		lib.explicitwait(homepagettile);
		return lib.getpagetitle();
	}
	
	
	public String InvalidLogin(String emailid, String password)
	{
		setEmail(emailid);
		clickNext();
		setPassword(password);
		clickNext();
		return lib.getElementText(rep.errormsg);
	}
	
	
}
