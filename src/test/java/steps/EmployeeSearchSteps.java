package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.EmployeeListPage;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {

    @When("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
      //  DashboardPage dash = new DashboardPage();
       // WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
       // click(dash.PimOption);
       jsClick(dash.PimOption);
       // dash.PimOption.click();

      //  WebElement employeeListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        click(dash.employeeListButton);
       // dash.employeeListButton.click();
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
      //  EmployeeListPage employeeListPage = new EmployeeListPage();
       // WebElement searchByID = driver.findElement(By.id("empsearch_id"));
        sendText(employeeListPage.idEmployeeSearch, "24303000");
       // employeeListPage.idEmployeeSearch.sendKeys("23638000");
    }

    @And("user clicks on search button")
    public void user_clicks_on_search_button() {
       // EmployeeListPage employeeListPage = new EmployeeListPage();
        // WebElement searchButton = driver.findElement(By.id("searchBtn"));
        click(employeeListPage.searchButton);
       // employeeListPage.searchButton.click();
    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("Information is displayed on page");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
      //  EmployeeListPage employeeListPage = new EmployeeListPage();
      //  WebElement name = driver.findElement(By.id("empsearch_employee_name_empName"));
      //  employeeListPage.empSearchStepByName.sendKeys("XYZT");
        sendText(employeeListPage.empSearchStepByName, "XYZT");
    }
}