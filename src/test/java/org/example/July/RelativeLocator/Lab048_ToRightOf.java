package org.example.July.RelativeLocator;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab048_ToRightOf {
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
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();
        WebElement years = driver.findElement(By.xpath("//span[normalize-space()=\"Years of Experience\"]"));
        driver.findElement(with(By.id("exp-4")).toRightOf(years)).click();
        driver.findElement(RelativeLocator.with(By.id("sex-0")).above(years)).click();
        driver.findElement(with(By.id("exp-0")).near(years)).click();
        driver.findElement(with(By.id("datepicker")).below(years)).sendKeys("12");





    }
}
