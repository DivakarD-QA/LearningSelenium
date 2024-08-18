package org.example.July.WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab043_NewWindow {
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
    public void newWindow(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement opening = driver.findElement(By.xpath("//h3[contains(text(), \"Opening\")]"));
        checkVisibility(driver, By.xpath("//h3[contains(text(), \"Opening\")]"));

        String parent_window = driver.getWindowHandle();
        System.out.println("First Window : " + parent_window);
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle : windowHandles){
            driver.switchTo().window(handle);
            System.out.println(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("User navigated to new window");
            }
        }

        driver.switchTo().window(parent_window);
        if (opening.isDisplayed()){
            System.out.println("User navigated to First window");
        }else {
            System.out.println("User is not in First window");
        }




    }


    @AfterTest
    public void closeBrowser(){
       // driver.quit();
    }
}
