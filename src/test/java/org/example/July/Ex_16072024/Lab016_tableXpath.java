package org.example.July.Ex_16072024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Lab016_tableXpath {

    @Test
    public void table() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        //edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        System.out.println(driver.getTitle());


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        //substring-before
        driver.findElement(By.xpath("//td[substring-before(text(), \" Anders\")]")).isDisplayed();

        //substring-after
        driver.findElement(By.xpath("//td[substring-after(text(), \"Centro\")]")).isDisplayed();

        // Multiple Attributes

        // Operators - AND & OR
        //And Example
        ////tag_name[@name = 'Name value' and @id = ‘ID value’]
        // //a[text()="Make Appointment" and contains(@id,"btn-make-appointment")]


        //AND
        driver.findElement(By.xpath("//a[@class=\"ga-nav\" and @title=\"CSS Tutorial\"]")).isDisplayed();

        //OR
        driver.findElement(By.xpath("//p[@class=\"intro\" or @id=\"intro\"]")).isDisplayed();



    }


}
