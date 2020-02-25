package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base
{
	private static Logger log =LogManager.getLogger(base.class.getName());
@BeforeTest
public void initialize() throws IOException
{
	driver=intializeDriver();
	driver.get(prop.getProperty("url"));
}
	@Test
	public void titleBar() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		log.info("title is confirmed");
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}