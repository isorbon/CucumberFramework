package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeeProfile extends CommonMethods {

    @FindBy(id = "personal_txtLicenNo") public WebElement licenseNo;
    @FindBy(id = "personal_txtNICNo") public WebElement ssnNo;
    @FindBy(id = "personal_optGender_1") public WebElement gender;
    @FindBy(css = "select#personal_cmbNation") public WebElement nationality;
    @FindBy(id = "personal_txtEmpNickName") public WebElement nickName;
    @FindBy(id = "personal_txtMilitarySer") public WebElement military;
    @FindBy(id = "personal_txtOtherID") public WebElement otherID;
    @FindBy(css = "input#personal_txtLicExpDate") public WebElement licenseExDate;
    @FindBy(css = "select.ui-datepicker-month") public WebElement selectMonth;
    @FindBy(css = "select.ui-datepicker-year") public WebElement selectYear;
    @FindBy(xpath = "//*[@class='ui-datepicker-calendar']/tbody/tr/td") public List<WebElement> calendar;
    @FindBy(id = "personal_txtSINNo") public WebElement sinNumber;
    @FindBy(css = "select#personal_cmbMarital") public WebElement maritalStatus;
    @FindBy(css = "input#personal_DOB") public WebElement dateBirth;
    @FindBy(id = "personal_chkSmokeFlag") public WebElement checkSmoker;

    public EmployeeProfile(){
        PageFactory.initElements(driver, this);
    }



}
