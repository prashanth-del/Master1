package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefinition extends base {

	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {

		driver = intializeDriver();

	}

	@Given("Navigate to {string} Site")
	public void navigate_to_Site(String string) {

		driver.get(string);

	}

	@Given("Click on login link in home page to land on Secure sign in page")
	public void click_on_login_link_in_home_page_to_land_on_Secure_sign_in_page() {

		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		;

	}

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		{

			LoginPage lp = new LoginPage(driver);
			lp.getemail().sendKeys(username);
			lp.getPassword().sendKeys(password);
			lp.getLogin().click();

		}
	}

	@Then("Verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {

		portalHomePage p = new portalHomePage(driver);
		Assert.assertTrue(p.getlogo());

	}

	@And("^close the browsers$")
	public void close_the_browsers() throws Throwable {
		driver.quit();
	}

}
