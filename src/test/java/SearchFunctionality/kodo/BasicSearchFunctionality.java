package SearchFunctionality.kodo;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import ElementsList.SearchElements;

public class BasicSearchFunctionality extends Base {
	
	//Validate if serach bar is visible
	@Test
	public void searchBarVisibility (){
		SearchElements se = new SearchElements(driver);
		Assert.assertTrue(se.SearchBar().isDisplayed());
	}
	
	//Validate if serach is blank at first
	@Test
	public void blankSearchBar () {
		SearchElements se = new SearchElements(driver);
		String Text = se.SearchBar().getText();
		Assert.assertTrue(Text.isEmpty());
	}
	
	//Validate search button is working
	@Test
	public void searchButtonValidation () {
		SearchElements se = new SearchElements(driver);
		se.SearchBar().sendKeys("Dress");
		se.SubmitButton().submit();
		Assert.assertTrue(se.SearchResults().isDisplayed());
    }
	
	//Validate enter button from keyboard functionality
	@Test
	public void searchButtonKeyboradValidation () {
		SearchElements se = new SearchElements(driver);
		se.SearchBar().sendKeys("Dress");
		se.SubmitButton().sendKeys(Keys.ENTER);
		Assert.assertTrue(se.SearchResults().isDisplayed());
    }
	

	

}
