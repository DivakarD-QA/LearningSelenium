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

public class Lab019 {

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

        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        System.out.println(driver.getTitle());

        WebElement searchBox = driver.findElement(By.cssSelector("input[id=\"gh-ac\"]"));
        searchBox.sendKeys("macmini");

        WebElement searchBtn = driver.findElement(By.cssSelector("input[id=\"gh-btn\"]"));
        searchBtn.click();
        Thread.sleep(1000);

        List<WebElement> productTitle = driver.findElements(By.cssSelector(".s-item__title"));
        List<WebElement> productPrice = driver.findElements(By.cssSelector(".s-item__price"));

//        for(WebElement title : productTitle) {
//            System.out.println(title.getText());
//        }
//
//        for (WebElement price : productPrice){
//
//                System.out.println(price.getText());
//            }


//        Advanced way to control
        // // Ensure both lists are of the same size to avoid IndexOutOfBoundsException

        int size = Math.min(productTitle.size(), productPrice.size());
        System.out.println("Total no.of products : " + size);
        for (int i=0 ; i < size; i++){
            System.out.println("Product Title : " + productTitle.get(i).getText() + " || " + "Product Price : " + productPrice.get(i).getText());
            System.out.println();
        }


        // img[title*="Flip"] - contains
        // img[title^="Flip"] - starts-wiht
        // img[title$="Flip"] - end-with
        // div.first > span:nth-child(2n+1)
        // div.first > span


        //contains
        WebElement rasberry = driver.findElement(By.cssSelector("img[alt*=\"berry\"]"));
        rasberry.isDisplayed();

        //Starts-with
        WebElement rasberryS = driver.findElement(By.cssSelector("img[alt^=\"Ras\"]"));
        rasberryS.isDisplayed();

        //Ends-With
        WebElement rasberryE = driver.findElement(By.cssSelector("img[alt$=\" Pi\"]"));
        rasberryE.isDisplayed();





    }



    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }


}
