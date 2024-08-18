package org.example.July.Actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab037_SpiceJet {

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
    public void ActionsClick() throws InterruptedException {
        driver.get("https://www.spicejet.com/");

        checkVisibility(driver, By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
        WebElement source = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
        source.isDisplayed();
        Actions actions = new Actions(driver);
        actions.moveToElement(source).click().sendKeys("MAA").build().perform();

        WebElement destination = driver.findElement(By.xpath("//input[@data-focusvisible-polyfill='true']"));
        actions.moveToElement(destination).sendKeys("BHO").build().perform();

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
