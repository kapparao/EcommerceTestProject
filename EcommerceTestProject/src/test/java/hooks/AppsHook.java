package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilePackage.ConfigReader;

public class AppsHook {

	private DriverFactory df;
	private WebDriver driver;
	private ConfigReader cr;
	Properties prop;

	@Before(order = 0)
	public void getPropertie() {

		cr = new ConfigReader();
		prop = cr.initProp();

	}

	@Before(order = 1)
	public void launchBrowser() {

		String browserName = prop.getProperty("browser");
		df = new DriverFactory();
		driver = df.initDriver(browserName);

	}

	
	  @After(order = 0) public void quitBrowser() {
	  
	  driver.quit(); }
	 

	@After(order = 1)
	public void tearDown(Scenario sc) {

		if (sc.isFailed()) {

			String screenShotName = sc.getName().replaceFirst(" ", "_");

			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			sc.attach(sourcePath, "image/png", screenShotName);

		}

	}

}
