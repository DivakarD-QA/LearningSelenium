package org.example.July.WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.example.July.Ex_20072024.WaitHelper.checkVisibility;

public class Lab044_NewWindow_Iterator {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void newWindow() throws InterruptedException {
        driver.get("https://app.vwo.com/#/analyze/osa/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        checkVisibility(driver, By.xpath("//h2[normalize-space()=\"Heatmaps & Clickmaps\"]"));

        String parent_window = driver.getWindowHandle();
        System.out.println("Parent Window : " + parent_window);

        List<WebElement> heatmaps = driver.findElements(By.xpath("//img[@data-qa=\"danawobuqa\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(heatmaps.get(1)).click().build().perform();


        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Set : " + windowHandles);

        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            System.out.println("Child :" + childWindow);
            if (!parent_window.equalsIgnoreCase((childWindow))) {
                driver.switchTo().window(childWindow);
                String pageTitle = driver.getTitle();
            Assert.assertEquals(pageTitle, "Job Ready Automation Tester Blueprint with JAVA By Pramod Dutta");

        }
    }
    }
}

