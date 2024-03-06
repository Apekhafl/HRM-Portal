package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	private WebElement name;

	@FindBy(id = "txtPassword")
	private WebElement pwd;

	@FindBy(css = "button[type='submit']")
	private WebElement loginbtn;

	public void gotoLoginPage(String url) {
		driver.get(url);
	}

	public void enterdetails(String username, String password) {
		name.sendKeys(username);
		pwd.sendKeys(password);
	}

	public HRAdministrationPage submit() {
		loginbtn.click();
		HRAdministrationPage hradmin = new HRAdministrationPage(driver);
		return hradmin;
	}
}
