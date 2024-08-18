package org.example.July.Ex_20072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class Lab025_dropdown {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void dropDown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());

        WebElement select_dropdown = driver.findElement(By.cssSelector("select[id=\"dropdown\"]"));

        Select select = new Select(select_dropdown);
        select.selectByIndex(1);
        Thread.sleep(2000);
        select.selectByValue("2");
        Thread.sleep(2000);
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);



    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }

}
