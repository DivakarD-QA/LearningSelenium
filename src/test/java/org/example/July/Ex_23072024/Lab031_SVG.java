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

public class Lab031_SVG {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void svg(){
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        System.out.println(driver.getTitle());

        // svg - Scalable vector graphics
        // svg, path , cicle, polygon
        // svg -> path -> g - shapes.

        //  //*[local-name()='svg']
        //  //*[name()='svg']  , contains(), text(), name()

        driver.findElement(By.name("q")).sendKeys("Macmini");
        List<WebElement> svg = driver.findElements(By.xpath("//*[name()=\"svg\"]"));
        svg.get(0).click();

    }

    @AfterTest
    public void closeBrowser(){
       // driver.quit();
    }
}
