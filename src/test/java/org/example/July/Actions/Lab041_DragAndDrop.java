package org.example.July.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab041_DragAndDrop {
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
    public void dragAndDrop(){
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        checkVisibility(driver, By.xpath("//h3[text()='Drag and Drop']"));

        WebElement from = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='column-b']"));

        Actions action = new Actions(driver);

        //using dragand drop
        //action.dragAndDrop(from, to).build().perform();

        action.clickAndHold(from).moveToElement(to).release(to).build().perform();
    }
}
