package org.example.July.Ex_20072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab028_Radio {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void radioIsSelected() {
        driver.get("https://demo.guru99.com/test/radio.html");
        driver.getTitle();

        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
        boolean selected1 = radio1.isSelected();
        System.out.println("Radio Button 1 : " + radio1.isSelected());


        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
        boolean selected2 = radio1.isSelected();
        System.out.println("Radio Button 2 : " + radio2.isSelected());

        WebElement radio3 = driver.findElement(By.id("vfb-7-3"));
        boolean selected3 = radio1.isSelected();
        System.out.println("Radio Button 3 : " + radio3.isSelected());


        if(selected1 == false & selected2 == false & selected3 == false){
            radio1.click();
            radio2.click();
            radio3.click();

        }else {
            System.out.println("CheckBox is already selected");
        }

        System.out.println("After selecting checkbox");
        System.out.println("Radio Button 1 : " + radio3.isSelected());
        System.out.println("Radio Button 2 : " + radio3.isSelected());
        System.out.println("Radio Button 3 : " + radio3.isSelected());



    }

    @AfterTest
    public void closeBrowser() {

         driver.quit();
    }
}
