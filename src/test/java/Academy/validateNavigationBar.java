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

	public class validateNavigationBar extends base
	{
		private static Logger log =LogManager.getLogger(base.class.getName());
		@BeforeTest
		public void initialize() throws IOException
		{
			driver=intializeDriver();
			driver.get(prop.getProperty("url"));
			log.info("url is hit");
			
		}
		@Test
		public void navigationBar() throws IOException
		{
			
			LandingPage l=new LandingPage(driver);
			Assert.assertTrue(l.getNavigationBar().isDisplayed());
		
	}
		@AfterTest
		public void tearDown()
		{
			driver.close();
			driver=null;
		}
	}


