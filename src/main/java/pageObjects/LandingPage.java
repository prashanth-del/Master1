package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	//By signin=By.xpath("//span[@class='pv-nav-link-with-droplist']");//cucumber
	By signin=By.xpath("//div[@class='tools']//li[4]//a[1]");//testng
	By title=By.xpath("//*[@id=\"content\"]/div/div/h2");
	By navbar=By.cssSelector("nav[class='navbar-collapse collapse']");
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement getLogin()
	{
		
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		
		return driver.findElement(navbar);
	}
	
	

}
