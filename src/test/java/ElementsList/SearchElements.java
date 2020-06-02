package elementsList;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchElements {
	
	
	WebDriver driver;
	public SearchElements(WebDriver driver){
	this.driver=driver; 
	PageFactory.initElements(driver, this);}
	
	   
		//Search bar
		@FindBy(id = "search_query_top") 
	    private WebElement SearchBar;
		
		public WebElement SearchBar() {
	    	return SearchBar;
	    }
		
		//SubmitButton
		@FindBy(xpath = "//button[@name='submit_search']") 
	    private WebElement SubmitButton;
		
		public WebElement SubmitButton() {
	    	return SubmitButton;
	    }

		//ProductCount
		@FindBy(xpath = "//div[@class='product-count']") 
	    private WebElement ProductCount;
		
		public WebElement ProductCount() {
	    	return ProductCount;
	    }

		//ProductClass
		@FindBy(xpath = "//body[@id='category']/div[@id='page']/div/div[@id='columns']/div/div[@id='center_column']/ul/li[1]/div[1]") 
	    private WebElement ProductClass;
		
		public WebElement ProductClass() {
	    	return ProductClass;
	    }

		//Women from menu
		@FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[contains(text(),'Women')]") 
	    private WebElement Women;
		
		public WebElement Women() {
	    	return Women;
	    }

		//Dresses from menu
		@FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[contains(text(),'Women')]//parent::li/following-sibling::li[1]") 
	    private WebElement Dresses;
		
		public WebElement Dresses() {
	    	return Dresses;
	    }

		//TShirts from menu
		@FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[contains(text(),'Women')]//parent::li/following-sibling::li[2]") 
	    private WebElement TShirts;
		

		public WebElement TShirts() {
	    	return TShirts;
	    }

		//SearchResults
		@FindBy(xpath = "//div[@id='center_column']//h1[contains(text(),'Search')]") 
	    private WebElement SearchResults;
		
		public WebElement SearchResults() {
	    	return SearchResults;
	    }

		//AlertMessage
		@FindBy(css = ".alert.alert-warning") 
	    private WebElement AlertMessage;
		
		public WebElement AlertMessage() {
	    	return AlertMessage;
	    }

		//casualDresses (women>>casualDresses)
		@FindBy(xpath = "//div[@id='block_top_menu']//ul//li//ul//li[2]//ul//li[1]") 
	    private WebElement casualDresses;
		
		public WebElement casualDresses() {
	    	return casualDresses;
	    }

		//Summer Dresses (Dresses>>Summer dresses)
		@FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[contains(text(),'Women')]//parent::li/following-sibling::li[1]//ul//li[1]") 
	    private WebElement SummerDresses;
		
		public WebElement SummerDresses() {
	    	return SummerDresses;
	    }
		
		//Product Name
		@FindBy(xpath  = "//div[@class='product-container']//div[2]//h5//a")
		private WebElement  ProductName;
		
		public WebElement ProductName() {
	    	return (WebElement) ProductName;
	    }
		
		//yellow colour 
		@FindBy(xpath = "//div[@class='color-list-container']//ul//li//a[@style='background:#F1C40F;']") 
	    private WebElement yellowColour;
		
		public WebElement yellowColour() {
	    	return yellowColour;
	    }
		
		//Black colour
		@FindBy(xpath = "//div[@class='color-list-container']//ul//li//a[@style='background:#434A54;']") 
	    private WebElement blackColour;
		
		public WebElement blackColour() {
	    	return blackColour;
	    }
		//Red colour
		@FindBy(xpath = "//div[@class='color-list-container']//ul//li//a[@style='background:#434A54;']") 
	    private WebElement redColour;
				
		public WebElement redColour() {
		return redColour;
		}
		
		
		//link
		@FindBy(xpath = "//div[@class='product-container']//div/div//div//a") 
	    private WebElement Link;
						
		public WebElement Link() {
		return redColour;
				}
		
   }


