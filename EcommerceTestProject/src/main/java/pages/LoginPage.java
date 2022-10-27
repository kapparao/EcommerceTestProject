package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By forgotPassword = By.linkText("Forgot your password?");
	private By createMailAddress = By.id("email_create");
	private By createAnAccount = By.id("SubmitCreate");
	private By signin = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public String getpageTitle() {

		return driver.getTitle();
	}

	public boolean isForgotPasswordLink() {

		return driver.findElement(forgotPassword).isDisplayed();
	}

	public void enterUserName(String Emailaddress) {

		driver.findElement(emailId).sendKeys(Emailaddress);

	}

	public void enterPassword(String Password) {

		driver.findElement(password).sendKeys(Password);

	}

	public void clickLoginButton() {

		driver.findElement(signin).click();
	}

}
