package org.example.July.Ex_23072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab030_DynamicTable {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }


    @Test
    public void dynamicTable(){

        driver.get("https://awesomeqa.com/webtable1.html");
        System.out.println(driver.getTitle());
        WebElement table = driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));

        System.out.println(table.getText());
        System.out.println(" --------------- ");

       List<WebElement> table_row = table.findElements(By.tagName("tr"));

        for(int i=0; i<table_row.size(); i++){

            List<WebElement> table_Col = table_row.get(i).findElements(By.tagName("td"));
            List<WebElement> table_head = table_row.get(i).findElements(By.tagName("th"));

            for (WebElement h : table_head){
                System.out.println( "Row : " + i);
                System.out.println(h.getText());
            }
            for(WebElement c : table_Col) {
            System.out.println(c.getText());
        }

        }

    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
