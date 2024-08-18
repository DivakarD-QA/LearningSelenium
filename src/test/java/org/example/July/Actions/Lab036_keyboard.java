package org.example.July.Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab036_keyboard {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }
    @Test(groups = "QA")
    @Description("Test Case Description")
    public void keyboard(){
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);

        WebElement firstName = driver.findElement(By.cssSelector("input[name=\"firstname\"]"));
        firstName.sendKeys("testingacademy");

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstName, "testingacademy")
                .keyUp(Keys.SHIFT).build().perform();

        WebElement link = driver.findElement(By.xpath("//a[normalize-space()=\"Click here to Download File\"]"));
        //link.click();

        actions.click(link).build().perform();


    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
