package steps.practice;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSteps extends CommonMethods {

    @Given("user opens browser and navigated to HRMS")
    public void user_opens_browser_and_navigated_to_hrms() {
        openBrowserAndLaunchApplication();
    }

    @Given("user is logged in as an admin")
    public void user_is_logged_in_as_an_admin() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys(ConfigReader.getPropertyValue("username"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys(ConfigReader.getPropertyValue("password"));
        driver.findElement(By.id("btnLogin")).click();
    }

    @Given("user is on employee list page")
    public void user_is_on_employee_list_page() {
        driver.findElement(By.cssSelector("a#menu_pim_viewPimModule")).click();
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        driver.findElement(By.cssSelector("input#empsearch_id")).sendKeys("26087A");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        driver.findElement(By.cssSelector("input#searchBtn")).click();
    }

    @Then("user see employee in the employee table")
    public void user_see_employee_in_the_employee_table() {
        WebElement foundEmp = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr"));
        System.out.println(foundEmp.getText());
    }
}
