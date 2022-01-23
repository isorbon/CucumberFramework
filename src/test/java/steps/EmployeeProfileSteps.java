package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EmployeeProfileSteps extends CommonMethods {

    @Given("user clicks on any found of employee link")
    public void user_clicks_on_any_found_of_employee_link() {
        WebElement link = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td/a"));
        click(link);
    }

    @When("user clicks on edit button in employee profile")
    public void user_clicks_on_edit_button_in_employee_profile() {
        click(addNewEmployeePage.saveButton);
    }
    @When("user enters details information")
    public void user_enters_details_information() {
        sendText(employeeProfile.licenseNo, "326933498");
        sendText(employeeProfile.ssnNo, "32973159873");
        click(employeeProfile.gender);
        selectDropDown(employeeProfile.nationality, "Ukrainian");
        sendText(employeeProfile.nickName, "Alex");
        sendText(employeeProfile.military, "Ukraine Army");
        sendText(employeeProfile.otherID, "65432892");
        click(employeeProfile.licenseExDate);
        selectDropDown(employeeProfile.selectMonth, "Sep");
        selectDropDown(employeeProfile.selectYear, "2028");
        choseDate(employeeProfile.calendar, "26");
        sendText(employeeProfile.sinNumber, "65349953102");
        selectDropDown(employeeProfile.maritalStatus, "Married");
        click(employeeProfile.dateBirth);
        selectDropDown(employeeProfile.selectMonth, "May");
        selectDropDown(employeeProfile.selectYear, "1988");
        choseDate(employeeProfile.calendar, "14");
        click(employeeProfile.checkSmoker);
    }

}
