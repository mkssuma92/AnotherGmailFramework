package AnotherFramework.AnotherFramework;

import org.openqa.selenium.By;

public class Repositorys 
{
	// Login page
	public final By emailid = By.name("identifier");
	public final By nextbtn = By.cssSelector(".RveJvd.snByac");
	public final By password = By.name("password");
	public final By errormsg=By.xpath("//div[contains(text(),'Wrong')]");
	public final By header=By.xpath("//h1");
	

	// home page
	public final By componselink=By.xpath("//div[text()='COMPOSE']");
	public final By sentemaillink=By.xpath("//a[@href='https://mail.google.com/mail/u/0/#sent']");
	public final By draftllink=By.xpath("//div[text()='Drafts']");
	
	// compose page
	public final By sendlink=By.xpath("//div[text()='Send']");
	public final By tofield1=By.name("to");
	public final By subfield=By.name("subjectbox");
	public final By msgbodyfield=By.xpath("//div[@aria-label='Message Body']");
	
	
	// sent page
	public final By sentemailtable=By.xpath("//div[@role='main']/div[3]/div[1]/div[1]/table[1]");
	public final By emailtitle = By.xpath("//table[@role='presentation']/tr[1]/td[1]/div[2]/div[1]/div[2]/div[1]/h2[1]");
	
}
