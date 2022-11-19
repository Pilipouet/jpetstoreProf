package jpetstore.testCases;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jpetstore.outils.Nav;
import jpetstore.pageObject.PageCatalogue;
import jpetstore.pageObject.PageConnexion;

public class Connexion extends Nav {
	
	PageCatalogue page_catalogue = PageFactory.initElements(driver, PageCatalogue.class);
	PageConnexion page_connexion = PageFactory.initElements(driver, PageConnexion.class);
	
	@Given("un navigateur est ouvert")
	public void un_navigateur_est_ouvert() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "./rsc/geckodriver.exe");
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "./rsc/chromedriver.exe");
//		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@When("je suis sur url")
	public void je_suis_sur_url() throws Throwable {
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	}

	@When("je clique sur le lien de connexion")
	public void je_clique_sur_le_lien_de_connexion() throws Throwable {
		page_catalogue.signIn.click();
	}

	@When("rentre le Username {string}")
	public void rentre_le_Username(String username) throws Throwable {
		page_connexion.username.clear();
		page_connexion.username.sendKeys(username);
		
	}

	@When("rentre le Password {string}")
	public void rentre_le_Password(String password) throws Throwable {
		page_connexion.password.clear();
		page_connexion.password.sendKeys(password);
	}

	@When("je clique sur login")
	public void je_clique_sur_login() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		page_connexion.login.click();
//		WebElement signonButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("signon")));
//		signonButton.click();
	}

	@Then("utilisateur ABC est connecte")
	public void utilisateur_ABC_est_connecte() throws Throwable {
		assertEquals("Erreur sur la présence du bouton Sign Out","Sign Out",page_catalogue.signOut.getText());		
	}

	@Then("je peux lire le message accueil {string}")
	public void je_peux_lire_le_message_accueil(String message) {
		assertEquals("Message d'accueil erroné",message,page_catalogue.welcome.getText());
	}
	
}