package org.example.July.Ex_23072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab033_DynamicTable {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }


    @Test
    public void dynamicTableHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        checkVisibility(driver, By.xpath("//h5[text()=\"Login\"]"));
        System.out.println(driver.getTitle());

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //Explicit wait
        checkVisibility(driver, By.xpath("//span[text()=\"Dashboard\"]"));

        driver.findElement(By.xpath("//span[text()=\"PIM\"]")).click();

        //Explicit Wait
        checkVisibility(driver, By.xpath("//h5[text()=\"Employee Information\"]"));
        checkVisibility(driver, By.xpath("//span[@class=\"oxd-text oxd-text--span\"]"));


        List<WebElement> table_status = driver.findElements(By.xpath("//div[@class='oxd-table-card']/*[name()=\"div\"]/*[name()=\"div\"][6]/*[name()='div'][text()]"));



        for(WebElement s : table_status) {

            List<WebElement> list = new ArrayList<>();
            int index = list.indexOf(table_status);
            System.out.println("Index : " + index);
            System.out.println(s.getText());

            List<WebElement> name = s.findElements(By.xpath("//div[@class='oxd-table-card']/*[name()=\"div\"]/*[name()=\"div\"][3]/*[name()='div'][text()]"));
            System.out.println("Name : " + name.get(index).getText());
        }


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
