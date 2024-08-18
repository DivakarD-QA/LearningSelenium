package org.example.July.Ex_23072024;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab036_FlipkartMouseHover {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    // org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found in the current frame
    // mouse hover


    @Test
    public void powerBank() throws InterruptedException {

        driver.get("https://www.flipkart.com/");
        checkVisibility(driver, By.xpath("//img[@alt=\"Electronics\"]"));

        driver.findElement(By.xpath("//span[text()=\"Electronics\"]")).click();

        checkVisibility(driver, By.xpath("//span[@class=\"TSD49J\"][text()=\"Electronics\"]"));

        WebElement electronics = driver.findElement(By.xpath("//span[@class=\"TSD49J\"][text()=\"Electronics\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(electronics).perform();

        checkVisibility(driver, By.cssSelector("div[class='wZsanD'] a[title='Power Banks']"));
        driver.findElement(By.cssSelector("div[class='wZsanD'] a[title='Power Banks']")).click();

        checkVisibility(driver, By.xpath("//h1[normalize-space()=\"Power Banks\"]"));

        Boolean powerBank_Text =driver.findElement( By.xpath("//h1[normalize-space()=\"Power Banks\"]")).isDisplayed();
        if(powerBank_Text){
            System.out.println("Power Bank text is present");
        }else {
            System.out.println("Power Bank text is not present");
        }

        WebElement high =  driver.findElement(By.xpath("//div[normalize-space()=\"Price -- High to Low\"]"));
        high.click();


        List<WebElement> products = driver.findElements(By.xpath("//a[@class=\"wjcEIp\"][text()]"));
        List<WebElement> price = driver.findElements(By.cssSelector("div[class=\"Nx9bqj\"]"));

//org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found in the current frame


        int size = Math.min(products.size(), price.size());
        System.out.println("Total no.of products : " + size);
        for (int i=0 ; i < size; i++){

             try {
                 System.out.println("Product Title : " + products.get(i).getText() + " || " + "Product Price : " + price.get(i).getText());
                 System.out.println();
             } catch (StaleElementReferenceException st){

                 List<WebElement> products2 = driver.findElements(By.xpath("//a[@class=\"wjcEIp\"][text()]"));
                 List<WebElement> price2 = driver.findElements(By.cssSelector("div[class=\"Nx9bqj\"]"));

                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 //scroll
                 js.executeScript("window.scrollBy(0,250)");
                 System.out.println("Product Title " + i + " : " + products2.get(i).getText() + " || " + "Product Price : " + price2.get(i).getText());
                 System.out.println();
             }
        }

        }



    @AfterTest
    public void closeBrowser(){
      // driver.quit();
    }
}

