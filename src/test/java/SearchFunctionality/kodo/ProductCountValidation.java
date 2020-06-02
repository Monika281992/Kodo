//Validate count shown is equal to number of displayed item
package SearchFunctionality.kodo;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import elementsList.SearchElements;


public class ProductCountValidation extends Base {
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";	
	

	//On one step click
	
	@Test 
	public void clickWomen () throws InterruptedException  {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.Women().click();
		int expectedCount = driver.findElements(By.xpath(productContainer)).size();
		String count = se.ProductCount().getText();
		char items = count.charAt(17);    
		int DisplayCount= Character.getNumericValue(items);
		AssertJUnit.assertEquals(DisplayCount, expectedCount);
	}
	@Test 
	public void clickDress () throws InterruptedException  {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.Dresses().click();
		int expectedCount = driver.findElements(By.xpath(productContainer)).size();
		String count = se.ProductCount().getText();
		char items = count.charAt(17);   
		int DisplayCount= Character.getNumericValue(items);
		AssertJUnit.assertEquals(DisplayCount, expectedCount);
	}
	
	@Test 
	public void clickTShirts () throws InterruptedException  {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.TShirts().click();
		int expectedCount = driver.findElements(By.xpath(productContainer)).size();
		String count = se.ProductCount().getText();
		char items = count.charAt(17);    
		int DisplayCount= Character.getNumericValue(items);
		AssertJUnit.assertEquals(DisplayCount, expectedCount);
	}
	
	//Validation by entering data into search bar
	@Test (dataProvider= "getdata")
	public void searchElement (String Category) throws InterruptedException  {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(Category);
		se.SubmitButton().submit();
		int productcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(productcount);
		String count = se.ProductCount().getText();
		//System.out.println(count);
		char items = count.charAt(17);    
		int DisplayCount= Character.getNumericValue(items);
		//System.out.println(DisplayCount);
		AssertJUnit.assertEquals(DisplayCount, productcount);
	}
	
	//Validation by hover on element and then click
	@Test 
	public void hoverWomen () throws InterruptedException  {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
    	actions.moveToElement((WebElement) se.Women()).perform();
    	se.casualDresses().click();
    	int expectedCount = driver.findElements(By.xpath(productContainer)).size();
    	String count = se.ProductCount().getText();
    	char items = count.charAt(17);    
		int DisplayCount= Character.getNumericValue(items);
		AssertJUnit.assertEquals(DisplayCount, expectedCount);
}
	@Test 
	public void hoverDresses () throws InterruptedException  {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
    	actions.moveToElement((WebElement) se.Dresses()).perform();
    	se.SummerDresses().click();
    	int expectedCount = driver.findElements(By.xpath(productContainer)).size();
        //System.out.println(expectedCount);
    	String count = se.ProductCount().getText();
    	char items = count.charAt(17);    
		int DisplayCount= Character.getNumericValue(items);
		AssertJUnit.assertEquals(DisplayCount, expectedCount);
}
	//validation from hover to click and by entering product in search bar
	@Test         ///expected to fail
	public void hoverAndEnterProduct () throws InterruptedException  {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
    	actions.moveToElement((WebElement) se.Women()).perform();
    	se.casualDresses().click();
    	int hovreCount = driver.findElements(By.xpath(productContainer)).size();
    	System.out.println(hovreCount);
    	se.SearchBar().clear();
		se.SearchBar().sendKeys("Casual Dress");
		se.SubmitButton().submit();
		int enterCount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(enterCount);
    	AssertJUnit.assertEquals(hovreCount, enterCount);
		
}
	
	
	@AfterMethod
    public void afterEachMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
	
	
	@DataProvider(name = "getdata")
    public String[][] correctName() {
        return new String[][] {
                {"Dress"},
                {"T-shirts"}
        };}

}
