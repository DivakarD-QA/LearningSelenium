package org.example.July.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Lab040_PageDown {

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
    public void pageDown() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(2000);
        WebElement close = driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]"));

        if(close.isDisplayed()){
            close.click();
            System.out.println("Popup closed");
        }else{
            System.out.println("No popup appear");
        }

        Actions actoins = new Actions(driver);
        actoins.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("Scroll Down");
    }
}
