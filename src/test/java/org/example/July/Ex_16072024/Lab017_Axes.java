package org.example.July.Ex_16072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Lab017_Axes {

    @Test
    public void axes() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        //edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.navigate().to("https://awesomeqa.com/xpath/");
        String title = driver.getTitle();
        System.out.println(title);


        WebElement mammal = driver.findElement(By.xpath("//div[@class=\"Mammal\"]/following-sibling::div"));
        System.out.println(mammal.getText());

        WebElement child = driver.findElement(By.xpath("//div[@class=\"Mammal\"]/child::div"));
        System.out.println(child.getText());

        WebElement ancestor = driver.findElement(By.xpath("//div[@class=\"Mammal\"]/ancestor::div"));
        System.out.println(ancestor.getText());

        driver.quit();





    }
}
