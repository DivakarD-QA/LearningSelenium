package org.example.July.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab042_uploadFile {
    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void uploadFile() throws InterruptedException {
        driver.get("https://awesomeqa.com/selenium/upload.html");
        checkVisibility(driver, By.xpath("//h2[contains(text(), \"File Upload\")]"));


        WebElement choose = driver.findElement(By.id("fileToUpload"));
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        //choose.sendKeys(dir + "\\src\\test\\java\\org\\example\\July\\Actions\\toUpload.html");
        choose.sendKeys("C:\\Users\\DIVAKAR D\\OneDrive\\Pictures\\Saved Pictures\\Thor.jpg");

        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();

    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
