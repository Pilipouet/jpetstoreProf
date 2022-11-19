package jpetstore.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCatalogue {
	
	@FindBy (xpath = "//a[text()='Sign In']")
	public WebElement signIn;
	
	@FindBy (id = "WelcomeContent")
	public WebElement welcome;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	public WebElement signOut;
	
}