package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddNewEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.*;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
      //  DashboardPage dash = new DashboardPage();
        //  WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(dash.PimOption);
       // dash.PimOption.click();
    }

    @When("user clicks on Add employee button")
    public void user_clicks_on_add_employee_button() {
       // DashboardPage dash = new DashboardPage();
        // WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        click(dash.addEmployeeButton);
        // dash.addEmployeeButton.click();
    }

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
      //  AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();
        //   WebElement firstName = driver.findElement(By.id("firstName"));
        sendText(addNewEmployeePage.firstName, "Nammar");
       // addNewEmployeePage.firstName.sendKeys("Nammar");
        // WebElement lastName = driver.findElement(By.id("lastName"));
        sendText(addNewEmployeePage.lastName, "MS");
       // addNewEmployeePage.lastName.sendKeys("MS");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
      //  AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();
        // WebElement saveButton = driver.findElement(By.id("btnSave"));
        click(addNewEmployeePage.saveButton);
       // addNewEmployeePage.saveButton.click();
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {
       // AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();
        // WebElement firstNameloc = driver.findElement(By.id("firstName"));
       // addNewEmployeePage.firstName.sendKeys(firstName);
        sendText(addNewEmployeePage.firstName, firstName);
        // WebElement middleNameLoc = driver.findElement(By.id("middleName"));
       // addNewEmployeePage.middleName.sendKeys(middleName);
        sendText(addNewEmployeePage.middleName, middleName);
        // WebElement lastNameLoc = driver.findElement(By.id("lastName"));
       // addNewEmployeePage.lastName.sendKeys(lastName);
        sendText(addNewEmployeePage.lastName, lastName);
    }

    @When("user enters direct data {string} {string} and {string}")
    public void user_enters_direct_data_and(String firstName, String middleName, String lastName) {
       // AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();
        // WebElement firstNameloc = driver.findElement(By.id("firstName"));
       // addNewEmployeePage.firstName.sendKeys(firstName);
        sendText(addNewEmployeePage.firstName, firstName);
        // WebElement middleNameLoc = driver.findElement(By.id("middleName"));
       // addNewEmployeePage.middleName.sendKeys(middleName);
        sendText(addNewEmployeePage.middleName, middleName);
        // WebElement lastNameLoc = driver.findElement(By.id("lastName"));
       // addNewEmployeePage.lastName.sendKeys(lastName);
        sendText(addNewEmployeePage.lastName, lastName);
    }

    @When("user add multiple employees and verify they are added")
    public void user_add_multiple_employees_and_verify_they_are_added(DataTable dataTable) throws InterruptedException {

      //  AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> emp : employeeNames) {
            String firstNameValue = emp.get("firstName");
            String middleNameValue = emp.get("middleName");
            String lastNameValue = emp.get("lastName");

            //   WebElement firstNameloc = driver.findElement(By.id("firstName"));
           // addNewEmployeePage.firstName.sendKeys(firstNameValue);
            sendText(addNewEmployeePage.firstName, firstNameValue);
            //   WebElement middleNameLoc = driver.findElement(By.id("middleName"));
            // addNewEmployeePage.middleName.sendKeys(middleNameValue);
            sendText(addNewEmployeePage.middleName, middleNameValue);
            //   WebElement lastNameLoc = driver.findElement(By.id("lastName"));
           // addNewEmployeePage.lastName.sendKeys(lastNameValue);
            sendText(addNewEmployeePage.lastName, lastNameValue);
            //  WebElement saveButton = driver.findElement(By.id("btnSave"));
           // addNewEmployeePage.saveButton.click();
            click(addNewEmployeePage.saveButton);

            // Assertions in Homework

            WebElement empPic = driver.findElement(By.cssSelector("img#empPic"));

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(empPic));
            Assert.assertTrue(empPic.isDisplayed());
            System.out.println("The employee has been added");

            Thread.sleep(2000);

            // to come back again on add employee screen because hooks and background works just one time
          //  DashboardPage dash = new DashboardPage();
            // WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
           // dash.addEmployeeButton.click();
            click(dash.addEmployeeButton);
            Thread.sleep(2000);

        }
    }

    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employee(String sheetName) throws InterruptedException {

      //  AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();

        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        Iterator<Map<String, String>> iter = newEmployees.iterator();
        // it checks whether we have element or not
        while (iter.hasNext()) {
            // it returns the Key and value for employees
            Map<String, String> mapNewEmp = iter.next();

            //  WebElement firstNameLoc = driver.findElement(By.id("firstName"));
           // addNewEmployeePage.firstName.sendKeys(mapNewEmp.get("FirstName"));
            sendText(addNewEmployeePage.firstName, mapNewEmp.get("FirstName"));
            //  WebElement lastNameLoc = driver.findElement(By.id("lastName"));
           // addNewEmployeePage.lastName.sendKeys(mapNewEmp.get("LastName"));
            sendText(addNewEmployeePage.lastName, mapNewEmp.get("LastName"));
            //  WebElement middleNameLoc = driver.findElement(By.id("middleName"));
          //  addNewEmployeePage.middleName.sendKeys(mapNewEmp.get("MiddleName"));
            sendText(addNewEmployeePage.middleName, mapNewEmp.get("MiddleName"));

            //WebElement empId = driver.findElement(By.id("employeeId"));
            String empIdValue = addNewEmployeePage.empIdLoc.getAttribute("value");

            //  WebElement photo = driver.findElement(By.id("photofile"));
           // addNewEmployeePage.photograph.sendKeys(mapNewEmp.get("Photograph"));
            sendText(addNewEmployeePage.photograph, mapNewEmp.get("Photograph"));

            //  WebElement checkBox = driver.findElement(By.id("chkLogin"));
            if (!addNewEmployeePage.checkbox.isSelected()) {
               // addNewEmployeePage.checkbox.click();
                click(addNewEmployeePage.checkbox);
            }

            //  WebElement username = driver.findElement(By.id("user_name"));
            //  WebElement password = driver.findElement(By.id("user_password"));
            //  WebElement confirmPassword = driver.findElement(By.id("re_password"));

            // addNewEmployeePage.createUsername.sendKeys(mapNewEmp.get("Username"));
            sendText(addNewEmployeePage.createUsername, mapNewEmp.get("Username"));
           // addNewEmployeePage.createPassword.sendKeys(mapNewEmp.get("Password"));
            sendText(addNewEmployeePage.createPassword, mapNewEmp.get("Password"));
           // addNewEmployeePage.rePassword.sendKeys(mapNewEmp.get("Password"));
            sendText(addNewEmployeePage.rePassword, mapNewEmp.get("Password"));

            // WebElement saveButton = driver.findElement(By.id("btnSave"));
           // addNewEmployeePage.saveButton.click();
            click(addNewEmployeePage.saveButton);

            Thread.sleep(5000);

            //Assertions in Homework
            //grab emp id while adding the employee
            //search it in the employee list

          //  DashboardPage dash = new DashboardPage();
            //  WebElement empList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
           // dash.employeeListButton.click();
            click(dash.employeeListButton);

         //   EmployeeListPage employeeListPage = new EmployeeListPage();
          //  WebElement searchEmp = driver.findElement(By.id("empsearch_id"));
           // employeeListPage.idEmployeeSearch.sendKeys(empIdValue);
            sendText(employeeListPage.idEmployeeSearch, empIdValue);
            //  WebElement searchButton = driver.findElement(By.id("searchBtn"));
           // employeeListPage.searchButton.click();
            click(employeeListPage.searchButton);

            //use for loop to compare the values
            List<WebElement> empList = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));

            for (int i = 0; i < empList.size(); i++) {
                String rowText = empList.get(i).getText();
                System.out.println(rowText);

                String expectedData = empIdValue + " " + mapNewEmp.get("FirstName") + " " + mapNewEmp.get("MiddleName")
                        + " " + mapNewEmp.get("LastName");
                System.out.println(expectedData);

                Assert.assertEquals(expectedData, rowText);
            }

            Thread.sleep(3000);

            //to come back again on add employee screen because hooks and background works just one time
            // WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
          //  dash.addEmployeeButton.click();
            click(dash.addEmployeeButton);
            Thread.sleep(3000);

        }

    }

}
