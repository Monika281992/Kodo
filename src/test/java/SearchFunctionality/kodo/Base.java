package SearchFunctionality.kodo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.cucumber.messages.internal.com.google.protobuf.Method;

public class Base {

	
		
		public static WebDriver driver;
		static String chromedriverpath = "//Users//monikachaudhary//Downloads//chromedriver_2";    //set chromedriver path
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


