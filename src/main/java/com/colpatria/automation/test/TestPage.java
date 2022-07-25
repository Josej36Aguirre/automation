package com.colpatria.automation.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.apache.log4j.Appender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Jose
 */
public class TestPage {

    private WebDriver webdriver;
    WebDriverWait waitWebDriver;
    Properties properties;
    InputStream imputData = null;
    private static Logger logdata = LogManager.getLogger(TestPage.class);

    public TestPage() {
        logdata.info("Start - TestPage.TestPage");
        System.setProperty("webdriver.chrome.driver", "..\\automation\\"
                + "resources\\chromedriver.exe");
        logdata.info("Path find");
        webdriver = new ChromeDriver();
        logdata.info("CromeDriver Start..");
        waitWebDriver = new WebDriverWait(webdriver, 50);

    }

    public void goToPage() {
        logdata.info("Start - TestPage.goToPage");
        String url = "https://demoqa.com/";
        webdriver.get(url);
        webdriver.manage().window().maximize();
        goToCarElements();
        goToWebTables();
        goToButtonAdd();
        goToRegisterForm();
        goToWidgets();
        goToAlertFramWindows();
        goToAlerts();
        logdata.info("End - TestPage.goToPage");
    }

    public void goToCarElements() {
        logdata.info("Start - TestPage.goToCarElements");
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        By buttonElement = By.cssSelector(("div.card:nth-child(1) > div:nth-child(1)"));
        waitWebDriver.until(ExpectedConditions.elementToBeClickable(buttonElement));
        waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(buttonElement));
        WebElement buttonElements = webdriver.findElement(buttonElement);
        JavascriptExecutor executor = (JavascriptExecutor) webdriver;
        executor.executeScript("arguments[0].click();", buttonElements);
        logdata.info("End - TestPage.goToCarElements");
    }

    public void goToWebTables() {
        logdata.info("Start - TestPage.goToWebTables");
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        By buttonWebTables = By.id(("item-3"));
        waitWebDriver.until(ExpectedConditions.elementToBeClickable(buttonWebTables));
        waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(buttonWebTables));
        WebElement buttoWebTables = webdriver.findElement(buttonWebTables);
        JavascriptExecutor executorWebTables = (JavascriptExecutor) webdriver;
        executorWebTables.executeScript("arguments[0].click();", buttoWebTables);
        logdata.info("End - TestPage.goToWebTables");
    }

    public void goToButtonAdd() {
        logdata.info("Start - TestPage.goToButtonAdd");
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        By buttonAdd = By.id(("addNewRecordButton"));
        waitWebDriver.until(ExpectedConditions.elementToBeClickable(buttonAdd));
        waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(buttonAdd));
        WebElement buttoWebElementAdd = webdriver.findElement(buttonAdd);
        JavascriptExecutor executorButtonAdd = (JavascriptExecutor) webdriver;
        executorButtonAdd.executeScript("arguments[0].click();", buttoWebElementAdd);
        logdata.info("End - TestPage.goToButtonAdd");
    }

    public void goToRegisterForm() {
        logdata.info("Start - TestPage.goToRegisterForm");
        try {
            properties = new Properties();
            imputData = new FileInputStream("data.properties");
            properties.load(imputData);
            WebElement firstName = webdriver.findElement(By.id("firstName"));
            firstName.sendKeys(properties.getProperty("firstName"));
            WebElement lastName = webdriver.findElement(By.id("lastName"));
            lastName.sendKeys(properties.getProperty("lastName"));
            WebElement userEmail = webdriver.findElement(By.id("userEmail"));
            userEmail.sendKeys(properties.getProperty("userEmail"));
            WebElement userAge = webdriver.findElement(By.id("age"));
            userAge.sendKeys(properties.getProperty("userAge"));
            WebElement userSalary = webdriver.findElement(By.id("salary"));
            userSalary.sendKeys(properties.getProperty("userSalary"));
            WebElement userDepartment = webdriver.findElement(By.id("department"));
            userDepartment.sendKeys(properties.getProperty("userDepartment"));
            webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            By buttonSubmit = By.id(("submit"));
            waitWebDriver.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
            waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(buttonSubmit));
            WebElement buttoWebSubmit = webdriver.findElement(buttonSubmit);
            JavascriptExecutor executorButtonSubmit = (JavascriptExecutor) webdriver;
            executorButtonSubmit.executeScript("arguments[0].click();", buttoWebSubmit);

        } catch (IOException ex) {
            logdata.error((Appender) ex);
        }
        logdata.info("End - TestPage.goToRegisterForm");
    }

    public void goToWidgets() {
        logdata.info("Start - TestPage.goToWidgets");
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        By buttonWidgets = By.cssSelector("#app > div > div > div.row > "
                + "div:nth-child(1) > div > div > div:nth-child(4) > span > "
                + "div > div.header-text");
        waitWebDriver.until(ExpectedConditions.elementToBeClickable(buttonWidgets));
        waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(buttonWidgets));
        WebElement buttoWidgets = webdriver.findElement(buttonWidgets);
        JavascriptExecutor executorWidgest = (JavascriptExecutor) webdriver;
        executorWidgest.executeScript("arguments[0].click();", buttoWidgets);
        goToDatePicker();
        logdata.info("End - TestPage.goToWidgets");
    }

    public void goToDatePicker() {
        logdata.info("Start - TestPage.goToDatePicker");
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        By buttonWidgets = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/"
                + "div/div/div[4]/div/ul/li[3]/span");
        waitWebDriver.until(ExpectedConditions.elementToBeClickable(buttonWidgets));
        waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(buttonWidgets));
        WebElement buttoDatePicker = webdriver.findElement(buttonWidgets);
        JavascriptExecutor executorDataPiacker = (JavascriptExecutor) webdriver;
        executorDataPiacker.executeScript("arguments[0].click();", buttoDatePicker);
        WebElement imputDate = webdriver.findElement(By.id("datePickerMonthYearInput"));
        imputDate.click();
        WebElement selectDate = webdriver.findElement(By.xpath("//"
                + "*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/"
                + "div[2]/div[5]/div[3]"));
        selectDate.click();
        WebElement dateAndTime = webdriver.findElement(By.xpath("/html/body/"
                + "div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div/"
                + "input"));
        dateAndTime.click();
        WebElement dateAndTimeDay = webdriver.findElement(By.xpath("/html/body/"
                + "div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/"
                + "div[2]/div/div/div[2]/div[2]/div[5]/div[5]"));
        dateAndTimeDay.click();
        WebElement dateAndTimeHour = webdriver.findElement(By.xpath("/html/body/"
                + "div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/"
                + "div[2]/div/div/div[3]/div[2]/div/ul/li[61]"));
        dateAndTimeHour.click();
        logdata.info("End - TestPage.goToDatePicker");
    }

    public void goToAlertFramWindows() {
        logdata.info("Start - TestPage.goToAlertFramWindows");
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        By buttonAlertWindow = By.cssSelector("#app > div > div > div.row > "
                + "div:nth-child(1) > div > div > div:nth-child(3) > span >"
                + "div > div.header-text");
        waitWebDriver.until(ExpectedConditions.elementToBeClickable(buttonAlertWindow));
        waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(buttonAlertWindow));
        WebElement buttoWebAlertWindow = webdriver.findElement(buttonAlertWindow);
        JavascriptExecutor executorWidgest = (JavascriptExecutor) webdriver;
        executorWidgest.executeScript("arguments[0].click();", buttoWebAlertWindow);
        logdata.info("Start - TestPage.goToAlertFramWindows");
    }

    public void goToAlerts() {
        try {
            logdata.info("Start - TestPage.goToAlerts");
            webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            By buttonAlerts = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/"
                    + "div/div/div[3]/div/ul/li[2]");
            waitWebDriver.until(ExpectedConditions.elementToBeClickable(buttonAlerts));
            waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(buttonAlerts));
            WebElement buttoWebAlertWindow = webdriver.findElement(buttonAlerts);
            JavascriptExecutor executorAlerts = (JavascriptExecutor) webdriver;
            executorAlerts.executeScript("arguments[0].click();", buttoWebAlertWindow);
            WebElement buttalert = webdriver.findElement(By.id("alertButton"));
            buttalert.click();
            Alert alert = webdriver.switchTo().alert();
            Thread.sleep(1000);
            alert.accept();
            WebElement buttalertAfterFive = webdriver.findElement(By.id("timerAlertButton"));
            buttalertAfterFive.click();
            Thread.sleep(8000);
            alert.accept();
            WebElement buttAlertConfirm = webdriver.findElement(By.id("confirmButton"));
            buttAlertConfirm.click();
            Thread.sleep(1000);
            alert.accept();
            webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            By buttonAdd = By.id(("promtButton"));
            waitWebDriver.until(ExpectedConditions.elementToBeClickable(buttonAdd));
            waitWebDriver.until(ExpectedConditions.visibilityOfElementLocated(buttonAdd));
            WebElement buttoWebElementAdd = webdriver.findElement(buttonAdd);
            JavascriptExecutor executorButtonAdd = (JavascriptExecutor) webdriver;
            executorButtonAdd.executeScript("arguments[0].click();", buttoWebElementAdd);
            alert.sendKeys("Jose");
            Thread.sleep(1000);
            alert.accept();
            logdata.info("Start - TestPage.goToAlerts");
            logdata.info("Test Success");
        } catch (InterruptedException ex) {
            logdata.error(ex);
        }
    }

}
