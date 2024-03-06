package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HRAdministrationPage;
import pageObjects.LoginPage;
import testComponents.BaseTest;

public class HRAdministrationstepDefinition {
	WebDriver driver = Hooks.driver;;
	LoginPage loginpage;
	HRAdministrationPage hradminpage;

	@Given("^User landed on HRM home page (.+)$")
	public void user_landed_on_hrm_home_page_browser(String url) throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.gotoLoginPage(url);
	}

	@Then("^Login with username (.+) and password (.+)$")
	public void login_with_username_and_password(String username, String password) {
		loginpage.enterdetails(username, password);
		hradminpage = loginpage.submit();
	}

	@Then("Click on Users")
	public void click_on_users() throws InterruptedException {
		hradminpage.usersSection();
	}

	@And("Click on Add icon")
	public void click_on_add_icon() {

	}

	@Then("^Click on Add icon and enter all details in Add User window (.+) (.+) (.+) (.+) and click on Save button$")
	public void click_on_add_icon_and_enter_all_details_in_add_user_window_and_click_on_save_button(String employeename,
			String username1, String password1, String confirmpassword) throws InterruptedException {
		hradminpage.addUser(employeename, username1, password1, confirmpassword);
	}

	@Then("^Click on Filter Option and search username (.+)$")
	public void click_on_filter_option_and_search_username(String username1) throws InterruptedException {
		hradminpage.filterUsers(username1);
	}

	@Then("Verify if user is added")
	public void verify_if_user_is_added() throws InterruptedException {
		hradminpage.verifyUser();
	}

	@Then("^Delete user (.+) from Users section$")
	public void delete_user_from_users_section(String username1) {
		hradminpage.deleteUser(username1);
	}

}
