package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    // universal method to open two browsers
    public void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

        // call initializer class here
        initializePageObjects();
    }

    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    public static void selectDropDown(WebElement dropDown, String visibleText){
        Select select = new Select(dropDown);
        select.selectByVisibleText(visibleText);
    }

    public static void choseDate(List<WebElement> dates, String dateNumber){
        for (WebElement date:dates) {
            String dateText = date.getText();
            if (dateText.equals(dateNumber)){
                date.click();
            }
        }
    }


    // post condition close browser
    public static void closeBrowser() {
        driver.quit();
    }





    //  take a screenshot
    public static void takeScreenShot(String folderName, String fileName) {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File sourceFile = screen.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/" + folderName + "/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
