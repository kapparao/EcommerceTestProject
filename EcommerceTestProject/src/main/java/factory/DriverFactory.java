package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tl = new ThreadLocal<>();

	public WebDriver initDriver(String browserName) {

		System.out.println("Requested Browser is... " + browserName);

		if (browserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			tl.set(new ChromeDriver());

		} else if ((browserName.equalsIgnoreCase("Firefox"))) {

			WebDriverManager.firefoxdriver().setup();

			tl.set(new FirefoxDriver());

		} else if ((browserName.equalsIgnoreCase("Edge"))) {

			WebDriverManager.edgedriver().setup();

			tl.set(new EdgeDriver());

		} else {

			System.out.println("Enter the vaild Browser...");

		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

		return getDriver();

	}

	public static synchronized WebDriver getDriver() {

		return tl.get();

	}
}
