package org.example.July.ShadowDOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab034 {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void shadowDOM() throws InterruptedException {
        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //scroll

//        js.executeScript("window.scrollBy(0,250)");


        // scroll to div
        WebElement scrollTo = driver.findElement(By.xpath("//div[@id=\"userName\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", scrollTo);

        checkVisibility(driver, By.xpath("//div[@id=\"userName\"]"));

        WebElement link = driver.findElement(By.id("userName")).getShadowRoot().findElement(By.cssSelector("#kils"));
        link.isDisplayed();
        System.out.println(link.getText());

        //using javascript
        WebElement inputboxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
        inputboxPizza.sendKeys("Farmhouse");


        // using gerShadow method
//        WebElement pizza = driver.findElement(By.id("userName")).getShadowRoot().findElement(By.cssSelector("#app2")).getShadowRoot().findElement(By.cssSelector("#pizza"));
//        pizza.sendKeys("Margrita");

        Thread.sleep(3000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
