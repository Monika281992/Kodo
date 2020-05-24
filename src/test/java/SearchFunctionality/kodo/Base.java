package SearchFunctionality.kodo;

import org.openqa.selenium.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

	
		
		public static WebDriver driver;
		static String chromedriverpath = "//Users//monikachaudhary//Downloads//chromedriver";
		String URL = "http://automationpractice.com/index.php";
	    
		public  Base () 
			 
			{
			
			   if (Platform.MAC!= null) {
				    System.setProperty("webdriver.chrome.driver", chromedriverpath);
				    driver = new  ChromeDriver();}
			   else if (Platform.WINDOWS!= null) {
				    System.setProperty("webdriver.chrome.driver", chromedriverpath);
				    driver = new  ChromeDriver();}
			   else if (Platform.LINUX!= null) {
				    System.setProperty("webdriver.chrome.driver", chromedriverpath);
				    driver = new  ChromeDriver();}
			  
			   }
			@BeforeTest
			public void  browserinitiate () {
				driver.get(URL);
				
			}
			@AfterTest 
			public void broserclose (){
				driver.close();
			}

	}


