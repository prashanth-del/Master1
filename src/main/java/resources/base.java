package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class base {
	public Properties prop;
	public static WebDriver driver;
	public WebDriver intializeDriver() throws IOException
	{
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Anshi Akhil\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Anshi Akhil\\\\Downloads\\\\selenium\\\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(browserName=="firefox")
		{
			System.out.println("Not Initialized, add gecho driver");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	public void getScreenshots(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C://tests//"+result+"screenshot.png"));
	}

}
