package org.example.July.iFrame;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab050_iframe {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();


        driver.switchTo().frame("result");

        checkVisibility(driver, By.xpath("//h2[text()=\"Register With Us\"]"));

        WebElement submit = driver.findElement(By.xpath("//button[text()=\"Submit\"]"));

        submit.click();

        WebElement username_element = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement errorElement =  driver.findElement(with(By.tagName("small")).below(username_element));
        String errorText = errorElement.getText();
        Assert.assertTrue(errorElement.isDisplayed());
        Assert.assertEquals(errorText,"Username must be at least 3 characters");

    }
}
