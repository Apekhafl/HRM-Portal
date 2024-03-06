package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.LoginPage;
import pageObjects.LoginPage;

public class BaseTest {
	public static WebDriver driver;
	public LoginPage lp;

	public static WebDriver initializeApp() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//resources//Global.properties");
		prop.load(file);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/Apeksha/Documents/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.msedgedriver.driver", "/Users/Apeksha/Documents/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
}
