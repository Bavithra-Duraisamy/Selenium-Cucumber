package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends BaseClass {

	@Given("Launch the browser")
	public void launch_the_browser() {

		// ChromeOptions instance to customize Chrome
		ChromeOptions options = new ChromeOptions();

		// Adding an argument to disable notifications
		options.addArguments("--disable-notifications");

		// Initialize ChromeDriver with the ChromeOptions
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

	}

	@Given("Load the URL")
	public void load_the_url() {
		driver.get("http://leaftaps.com/opentaps/control/main");

	}

	@Given("Enter the Username as {string}")
	public void enter_the_username_as_demo_sales_manager(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);

	}

	@Given("Enter the Password as crmsfa")
	public void enter_the_password_as_crmsfa() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");

	}

	@When("click on the Login button")
	public void click_on_the_login_button() {
		driver.findElement(By.className("decorativeSubmit")).click();

	}

	@Then("It should navigate to the next page")
	public void it_should_navigate_to_the_next_page() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		String headerTitle = driver.findElement(By.xpath("//div[@id='form']/h2")).getText();
		if (headerTitle.equalsIgnoreCase("Welcome Demo Sales Manager")) {
			System.out.println("Logged in successfully!..");
		} else {
			System.out.println("Not logged in!..");
		}

	}

	@But("It throws a validation")
	public void it_throws_a_validation() {
		System.out.println("Invalid Username!..");

	}

}
