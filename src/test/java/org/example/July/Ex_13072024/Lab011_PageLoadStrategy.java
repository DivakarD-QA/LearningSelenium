package org.example.July.Ex_13072024;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.nio.file.Watchable;

public class Lab011_PageLoadStrategy {
    public static void main(String[] args) {

        EdgeOptions edgeOptions = new EdgeOptions();

        // will wait for only few elements
//        edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        //will not wait for elements
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        //will wait for all elements
//        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
        driver.getTitle();
        driver.quit();



    }
}
