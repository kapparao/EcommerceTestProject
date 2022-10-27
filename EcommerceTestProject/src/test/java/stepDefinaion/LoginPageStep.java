package stepDefinaion;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageStep {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	// static String title = "Login Page";

	@Given("User should be in Login Page")
	public void user_should_be_in_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		String title = loginpage.getpageTitle();
		System.out.println("Login Page Title: " + title);
		Assert.assertTrue(title.contains("Login - My Store"));

	}

	@And("User able to Enter userName {string}")
	public void user_able_to_enter_user_name(String Emailaddress) {

		loginpage.enterUserName(Emailaddress);

	}

	@And("User able to Enter password {string}")
	public void user_able_to_enter_password(String Password) {

		loginpage.enterPassword(Password);
	}

	@When("User Click the Signin button")
	public void user_click_the_signin_button() {

		loginpage.clickLoginButton();

	}

	@Then("User should Land the My account Page")
	public void user_should_land_the_my_account_page() {

		String title = loginpage.getpageTitle();
		System.out.println("Page Title: " + title);
		Assert.assertTrue(title.contains("My account - My Store"));

	}

}
