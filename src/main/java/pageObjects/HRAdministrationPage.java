package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.HRMUtilities;

public class HRAdministrationPage extends HRMUtilities {
	WebDriver driver;
	String employee;

	public HRAdministrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='HR Administration']")
	WebElement hrAdmin;

	@FindBy(css = ".top-level-menu-item.active")
	WebElement users;

	@FindBy(css = "a[class='btn-floating btn-large waves-effect waves-light'] i[class='material-icons']")
	WebElement add;

	@FindBy(id = "selectedEmployee_value")
	WebElement employeeName;

	@FindBy(id = "user_name")
	WebElement username;

	@FindBy(className = "angucomplete-title")
	WebElement dynamicdropdown;

	@FindBy(id = "modal-holder")
	WebElement modelContainer;

	@FindBy(xpath = "//button[@aria-owns='bs-select-1']")
	WebElement dropdownESSRole;

	@FindBy(xpath = "//span[text()='Default ESS']")
	WebElement selectdropdownESSRole;

	@FindBy(xpath = "//button[@aria-owns='bs-select-2']")
	WebElement dropdownSupervisorRole;

	@FindBy(xpath = "//button[@aria-owns='bs-select-3']")
	WebElement dropdownAdminRole;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(id = "confirmpassword")
	WebElement confirmpwd;

	@FindBy(css = ".btn.btn-secondary")
	WebElement savebtn;

	@FindBy(css = ".btn.btn-close")
	WebElement closebtn;

	@FindBy(css = ".dropdown-menu.inner show")
	WebElement dropdownOptions;

	@FindBy(xpath = "//i[contains(text(),'oxd_filter')]")
	WebElement filter;

	@FindBy(id = "systemuser_uname_filter")
	WebElement uname;

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement search;

	@FindBy(xpath = "(//td[@name='listField.name']/ng-include/span) [3]")
	WebElement usertable;

	@FindBy(xpath = "//label[starts-with(@for, 'checkbox_list0_')]")
	WebElement checkbox;

	@FindBy(css = ".material-icons.icons-color.orange-text")
	WebElement editicon;

	@FindBy(xpath = "//a[contains(text(),'Selected')]")
	WebElement deleteSelected;

	@FindBy(css = ".btn.btn-text-danger")
	WebElement deletebtn;

	public void usersSection() throws InterruptedException {
		hrAdmin.click();
		TimeUnit.SECONDS.sleep(10);
	}

	public void addUser(String employeename, String username1, String password1, String confirmpassword)
			throws InterruptedException {
		waitForElementToAppear(add);
		add.click();
		waitForElementToAppear(employeeName);
		employeeName.sendKeys(employeename);
		waitForElementToAppear(dynamicdropdown);
		dynamicdropdown.click();
		employee = employeeName.getAttribute("value");
		username.sendKeys(username1);
		pwd.sendKeys(password1);
		confirmpwd.sendKeys(confirmpassword);
		TimeUnit.SECONDS.sleep(2);
		savebtn.click();
		closebtn.click();
	}

	public void filterUsers(String username1) throws InterruptedException {
		filter.click();
		uname.sendKeys(username1);
		search.click();
	}

	public void verifyUser() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		waitForElementToAppear(usertable);
		Assert.assertEquals(usertable.getText(), employee);
	}

	public void deleteUser(String username1) {
		waitForElementToAppear(checkbox);
		checkbox.click();
		editicon.click();
		waitForElementToBeClickable(deleteSelected);
		deletebtn.click();
	}
}
