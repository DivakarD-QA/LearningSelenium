package org.example.July.RelativeLocator;

import io.qameta.allure.Description;
import org.example.July.Ex_20072024.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab049_ToLeftOf {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();
        checkVisibility(driver, By.id("search_city"));

        WebElement search = driver.findElement(By.id("search_city"));
        search.sendKeys("INDIA" + Keys.ENTER);

        List<WebElement> table = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));

        for (WebElement l : table) {
            String s1 = driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
            String s2 = driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();
            String s3 = driver.findElement(with(By.tagName("p")).below(l)).getText();
            String s4 = driver.findElement(with(By.tagName("p")).above(l)).getText();
            System.out.println(l.getText() + " | " + s1 + " | " + s2);
            System.out.println(l.getText() + " | " + s3 + " | " + s4);
        }




    }
}
