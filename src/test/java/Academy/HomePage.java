package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	private static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=intializeDriver();
		log.info("driver is initialized");
	}
	@Test(dataProvider ="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getemail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		log.info(text);
		lp.getLogin().click();
		log.info("login button is clicked");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="restricted-user";
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456789";
		data[1][2]="non-restricted user";
		
		return data;
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}

}
