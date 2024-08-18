package org.example.July.Ex_20072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab027_checkbox {


    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.getTitle();

        checkVisibility(driver, By.xpath("//h3[text()=\"Checkboxes\"]"));

        WebElement header = driver.findElement(By.xpath("//h3[text()=\"Checkboxes\"]"));
        header.isDisplayed();

        List<WebElement> check = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        Thread.sleep(2000);
        check.get(1).click();

        check.get(0).click();
        Thread.sleep(2000);
        check.get(1).click();

        Thread.sleep(2000);
    }

    @Test
    public void checkBoxIsSelected() {
        driver.get("https://demo.guru99.com/test/radio.html");
        driver.getTitle();

        WebElement check1 = driver.findElement(By.id("vfb-6-0"));
        boolean selected1 = check1.isSelected();
        System.out.println("CheckBox 1 : " + check1.isSelected());

        WebElement check2 = driver.findElement(By.id("vfb-6-1"));
        boolean selected2 = check2.isSelected();
        System.out.println("CheckBox 2 : " + check2.isSelected());

        WebElement check3 = driver.findElement(By.id("vfb-6-2"));
        boolean selected3 = check3.isSelected();
        System.out.println("CheckBox 3 : " + check3.isSelected());

        if(selected1 == false & selected2 == false & selected3 == false){
            check1.click();
            check2.click();
            check3.click();

        }else {
            System.out.println("CheckBox is already selected");
        }

        System.out.println("After selecting checkbox");

        System.out.println("CheckBox 1 : " + check1.isSelected());
        System.out.println("CheckBox 2 : " + check2.isSelected());
        System.out.println("CheckBox 3 : " + check3.isSelected());



    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }
}
