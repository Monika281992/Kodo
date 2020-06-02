package SearchFunctionality.kodo;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.openqa.selenium.Keys;

import elementsList.SearchElements;

public class BasicSearchFunctionality extends Base {
	
	//Validate if serach bar is visible
	@Test
	public void searchBarVisibility (){
		SearchElements se = new SearchElements(driver);
		AssertJUnit.assertTrue(se.SearchBar().isDisplayed());
	}
	
	//Validate if serach is blank at first
	@Test
	public void blankSearchBar () {
		SearchElements se = new SearchElements(driver);
		String Text = se.SearchBar().getText();
		AssertJUnit.assertTrue(Text.isEmpty());
	}
	
	//Validate search button is working
	@Test
	public void searchButtonValidation () {
		SearchElements se = new SearchElements(driver);
		se.SearchBar().sendKeys("Dress");
		se.SubmitButton().submit();
		AssertJUnit.assertTrue(se.SearchResults().isDisplayed());
    }
	
	//Validate enter button from keyboard functionality
	@Test
	public void searchButtonKeyboradValidation () {
		SearchElements se = new SearchElements(driver);
		se.SearchBar().sendKeys("Dress");
		se.SubmitButton().sendKeys(Keys.ENTER);
		AssertJUnit.assertTrue(se.SearchResults().isDisplayed());
    }
	

	

}
