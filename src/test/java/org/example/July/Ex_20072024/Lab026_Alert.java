package org.example.July.Ex_20072024;

import junit.framework.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.example.July.Ex_20072024.WaitHelper.checkAlertIsPresent;


public class Lab026_Alert {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void alert(){
        // Alert Box

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());

        WebElement okAlert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        okAlert.click();

        checkAlertIsPresent(driver);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.cssSelector("p[id=\"result\"]"));
        Assert.assertEquals(result.getText(), "You successfully clicked an alert");

        WebElement confirmAlert = driver.findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]"));
        confirmAlert.click();

        checkAlertIsPresent(driver);

        alert.dismiss();
        Assert.assertEquals(result.getText(), "You clicked: Cancel");

        confirmAlert.click();
        checkAlertIsPresent(driver);
        alert.accept();
        Assert.assertEquals(result.getText(), "You clicked: Ok");

        WebElement promptAlert = driver.findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]"));
        promptAlert.click();
        checkAlertIsPresent(driver);

        alert.dismiss();
        Assert.assertEquals(result.getText(), "You entered: null");

        promptAlert.click();
        checkAlertIsPresent(driver);

        alert.sendKeys("Divakar");
        alert.accept();
        Assert.assertEquals(result.getText(), "You entered: Divakar");




    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }

}
