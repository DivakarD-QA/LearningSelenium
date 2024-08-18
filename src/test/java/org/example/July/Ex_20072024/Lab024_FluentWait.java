package org.example.July.Ex_20072024;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab024_FluentWait {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void fluentWait(){
        driver.get("https://app.vwo.com/#/login");
        String loginTitle = driver.getTitle();
        System.out.println(loginTitle);
        Assert.assertEquals(loginTitle, "Login - VWO");

        driver.findElement(By.name("username")).sendKeys("TestQ4@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("VWOtest4");

        driver.findElement(By.id("js-login-btn")).click();


        //Fluent Wait
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)) //5 Times
                .ignoring(NoSuchElementException.class);

        WebElement username = wait.until(driver -> driver.findElement(By.cssSelector("[data-qa='lufexuloga']")));


        System.out.println("Logged in User details -> " + username.getText());


        Assert.assertEquals(username.getText(), "Test Q4");
    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
