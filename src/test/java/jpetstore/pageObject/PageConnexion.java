package jpetstore.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageConnexion {
	
	@FindBy (name = "username")
	public WebElement username;
	
	@FindBy (name = "password")
	public WebElement password;
	
	@FindBy (name = "signon")
	public WebElement login;
	
}