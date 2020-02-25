package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class portalHomePage {
	
	public WebDriver driver;
	
	By logo=By.cssSelector("a[id='pv-nav-logo']");

	
	
	public portalHomePage(WebDriver driver) {
		
		this.driver=driver;
		
	}



	public boolean getlogo()
	{
		return driver.findElement(logo).isDisplayed();
		
	}
}
