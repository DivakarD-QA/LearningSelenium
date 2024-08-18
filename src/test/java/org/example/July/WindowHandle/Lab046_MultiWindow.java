package org.example.July.WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Lab046_MultiWindow {
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
    driver.get("https://omayo.blogspot.com/");


        String parent_window = driver.getWindowHandle();
        System.out.println(parent_window);

        WebElement selenium_link = driver.findElement(By.id("selenium143"));
        selenium_link.click();

        WebElement new_Window = driver.findElement(By.linkText("Open a popup window"));
        new_Window.click();

        Set<String> window_handles = driver.getWindowHandles();
        System.out.println("Set : " + window_handles);
        for (String handles : window_handles){
            driver.switchTo().window(handles);
            try {
                String  text = driver.findElement(By.xpath("//h3[text()=\"New Window\"]")).getText();
               WebElement selenium_img = driver.findElement(By.id("Header1_headerimg"));
                System.out.println(text);
                driver.quit();
                break;

//                if(text.isDisplayed()) {
//                    System.out.println(text.getText());
//
//                }
//                else if (selenium_img.isDisplayed()) {
//                    System.out.println("New Tab is opened");
//                }


            }catch (Exception e){
                e.printStackTrace();
                driver.close();
            }
        }

    }
}
