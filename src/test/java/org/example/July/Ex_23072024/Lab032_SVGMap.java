package org.example.July.Ex_23072024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab032_SVGMap {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }


    @Test
    public void svgMap(){
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);
        System.out.println(driver.getTitle());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        List<WebElement> state_list = driver.findElements(By.xpath("//*[name()=\"svg\"]/*[local-name()=\"g\"][7]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"path\"]"));

        for (WebElement state : state_list){
            System.out.println(state.getAttribute("aria-label"));
            if(state.getAttribute("aria-label").contains("Tamil Nadu  ")){
                state.click();
            }
        }


    }

    @AfterTest
    public void closeBrowser(){
        // driver.quit();
    }
}
