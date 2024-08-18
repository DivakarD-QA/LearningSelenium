package org.example.July.Ex_20072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab022 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void explicitWait(){

        driver.get("https://app.vwo.com/#/login");
        String loginTitle = driver.getTitle();
        System.out.println(loginTitle);
        Assert.assertEquals(loginTitle, "Login - VWO");

        driver.findElement(By.name("username")).sendKeys("TestQ4@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("VWOtest4");

        driver.findElement(By.id("js-login-btn")).click();



        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-qa=\"lufexuloga\"]")));

        WebElement userName = driver.findElement(By.cssSelector("span[data-qa=\"lufexuloga\"]"));
        Assert.assertEquals(userName.getText(), "Test Q4");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-qa*=\"active-test\"]")));
        WebElement activeTest = driver.findElement(By.cssSelector("span[data-qa*=\"active-test\"]"));
        activeTest.isDisplayed();



    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
