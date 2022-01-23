package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("verify all the dashboard tabs")
    public void verify_all_the_dashboard_tabs(DataTable dataTable) {
       // DashboardPage dash = new DashboardPage();

        List<String> expectedTabs = dataTable.asList();

        //    List<WebElement> dashboardTabs = driver.findElements(By.xpath("//*[@class='menu']/ul/li"));
        List<String> actualTabs = new ArrayList<>();

        for (WebElement ele : dash.dashboardTabs) {
            actualTabs.add(ele.getText());
        }
        System.out.println(expectedTabs); // coming from feature file
        System.out.println(actualTabs);  // coming from application

        // Assertion
        Assert.assertEquals(expectedTabs, actualTabs);
        System.out.println("All values of tabs are equal and my test case is passed");
    }
}
