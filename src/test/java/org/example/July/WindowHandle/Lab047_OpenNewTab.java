package org.example.July.WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab047_OpenNewTab {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--guest");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void WindowType(){
        driver.get("https://www.flipkart.com/");
        checkVisibility(driver, By.xpath("//input[@name=\"q\"]"));
        String First_Tab = driver.getWindowHandle();
        System.out.println(First_Tab);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.in/");
        checkVisibility(driver, By.id("nav-logo-sprites"));
        String Second_Tab = driver.getWindowHandle();
        System.out.println(Second_Tab);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        checkVisibility(driver, By.xpath("//h3[text()=\"Drag and Drop\"]"));
        String Second_Window = driver.getWindowHandle();
        System.out.println(Second_Window);

        driver.switchTo().window(Second_Tab);
        WebElement amazonSearch = driver.findElement(By.id("twotabsearchtextbox"));
        if(amazonSearch.isDisplayed()){
            System.out.println("User navigated to amazon screen ");
        }else {
            System.out.println("User not able to navigate to amazon tab");
        }

        driver.switchTo().window(Second_Window);
        WebElement drag =driver.findElement(By.xpath("//h3[text()=\"Drag and Drop\"]"));
        if(drag.isDisplayed()){
            System.out.println("User navigated to drag and drop screen ");
        }else {
            System.out.println("User not able to navigate to drag and drop tab");
        }


        driver.switchTo().window(First_Tab);
        WebElement flipkart_search = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        if(flipkart_search.isDisplayed()){
            System.out.println("User navigated to flipkart screen ");
        }else {
            System.out.println("User not able to navigate to flipkart tab");
        }



    }
    @AfterTest
    public void closeBrowser(){
         driver.quit();
    }

}
