package org.example.July.Ex_18072024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.dnd.DragSource;
import java.util.List;

public class Lab020 {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);

    }

    @Test(groups = "QA")
    @Description("Searching macmini in ebay")
    public void searchEbay() throws InterruptedException {

        driver.get("https://www.flipkart.com/");
        System.out.println(driver.getTitle());


        // img[title*="Flip"] - contains
        // img[title^="Flip"] - starts-wiht
        // img[title$="Flip"] - end-with
        // div.first > span:nth-child(2n+1)
        // div.first > span


        //contains
        WebElement rasberry = driver.findElement(By.cssSelector("img[title*=\"ipka\"]"));
        rasberry.isDisplayed();

        //Starts-with
        WebElement rasberryS = driver.findElement(By.cssSelector("img[alt^=\"Gro\"]"));
        rasberryS.isDisplayed();

        //Ends-With
        WebElement rasberryE = driver.findElement(By.cssSelector("img[title*=\"kart\"]"));
        rasberryE.isDisplayed();





    }



    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }


}
