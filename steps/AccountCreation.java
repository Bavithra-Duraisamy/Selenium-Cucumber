package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreation extends BaseClass {

	@Given("Load the {string}")
	public void load_the(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Given("Enter the username as {string}")
	public void enter_the_username_as(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);

	}

	@Given("Enter the password as {string}")
	public void enter_the_password_as(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);

	}

	@Given("Click on the Login button")
	public void click_on_the_login_button() {
		driver.findElement(By.id("Login")).click();

	}

	@Given("Toggle the main menu")
	public void toggle_the_main_menu() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	}

	@Given("Click view All and click Sales from App Launcher")
	public void click_view_all_and_click_sales_from_app_launcher() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		subMenu = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement sales = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='slds-truncate' and text()='Sales']")));
		subMenu.click(sales).perform();

	}

	@Given("Click on Accounts tab")
	public void click_on_accounts_tab() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Accounts' and @class='slds-truncate']")));
		WebElement accountsTab = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[text()='Accounts' and @class='slds-truncate']")));
		driver.executeScript("arguments[0].click();", accountsTab);

	}

	@Given("Click on New button")
	public void click_on_new_button() {
		driver.findElement(By.xpath("//div[@title='New']")).click();

	}

	@Given("Enter {string} as account name")
	public void enter_as_account_name(String yourName) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(yourName);

	}

	@Given("Select Ownership as Public")
	public void select_ownership_as_public() {

		WebElement statusDropdown = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
		driver.executeScript("arguments[0].click();", statusDropdown);

		WebElement statusValue = driver.findElement(By.xpath("//span[text()='Public']"));
		driver.executeScript("arguments[0].click();", statusValue);

	}

	@When("Click save and verify Account name")
	public void click_save_and_verify_account_name() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

	}

	@Then("New account should be created")
	public void new_account_should_be_created() {

		boolean toaster = driver.findElement(By.xpath("//div[contains(@class,'toastContent')]")).isDisplayed();
		String accName = driver.findElement(By.xpath("//span[contains(@class,'toastMessage ')]/a/div")).getText();
		if (toaster) {
			System.out.println("Success confirmation is displayed!.. and the account name is: " + accName);
		} else {
			System.out.println("Success confirmation is not displayed!..");
		}

	}
	
	@Then("Quit the browser")
	public void quit_the_browser() {
	   driver.quit();
	}

}
