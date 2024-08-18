package org.example.July.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab038_MakeMyTrip {
    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
//        edgeOptions.addArguments("--guest");
//        edgeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void makeMyTrip() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(2000);
        WebElement close = driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]"));

        if(close.isDisplayed()){
            close.click();
            System.out.println("Popup closed");
        }else{
            System.out.println("No popup appear");
        }



        checkVisibility(driver, By.xpath("//input[@id=\"fromCity\"]"));

        WebElement origin = driver.findElement(By.xpath("//input[@id=\"fromCity\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(origin).click().sendKeys(origin, "Chennai").build().perform();

        List<WebElement> origin_list = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));

        for(WebElement list : origin_list){
            if(list.getText().contains("Chennai")){
                list.click();
                break;
            }
        }

        WebElement search = driver.findElement(By.xpath("//a[text()=\"Search\"]"));
        if(search.isEnabled()){
            search.click();
        }

        Thread.sleep(1000);

        WebElement GotIt = driver.findElement(By.xpath("//button[text()=\"OKAY, GOT IT!\"]"));
        if(GotIt.isDisplayed()){
            GotIt.click();
            System.out.println("Clicking on Got IT button");
        }else {
            System.out.println("No popup appear");
        }
        checkVisibility(driver, By.xpath("//span[contains(text(),\"Flights from\")]"));


        List<WebElement> flightList = driver.findElements(By.xpath("//div[@class=\"makeFlex align-items-center gap-x-10 airline-info-wrapper\"]"));
        for (WebElement list : flightList){
            System.out.println(list.getText());
        }



    }

    @AfterTest
    public void closeBrowser(){
        //driver.quit();
    }
}
