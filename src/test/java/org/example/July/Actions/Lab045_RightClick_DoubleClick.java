package org.example.July.Actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab045_RightClick_DoubleClick {
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
    public void rightClick() throws InterruptedException {

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClick = driver.findElement(By.xpath("//span[text()=\"right click me\"]"));
        Actions action = new Actions(driver);
        action.contextClick(rightClick).build().perform();

        WebElement edit = driver.findElement(By.xpath("//span[text()=\"Edit\"]"));
        edit.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement doubleClick = driver.findElement(By.xpath("//button[text()=\"Double-Click Me To See Alert\"]"));
        action.doubleClick(doubleClick).build().perform();
        Thread.sleep(1000);
        alert.accept();


    }
}
