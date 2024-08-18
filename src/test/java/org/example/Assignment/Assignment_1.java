package org.example.Assignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Assignment_1 {

    //    [Assignment] - Automating the Login Page of VWO.com
//    Fetch the locators - https://app.vwo.com/
//    Create a Maven project and add TestNG.
//    Add the Allure Report (Allure TestNG)
//    Automate the two Test cases of VWO.com
//    Valid Username and Valid Password
//    Verify name on dashboard page.
//    Run them and share results.
//    Push the code to github.com
//    Git repo - ReadMe.md a Screen shot of allure.

    @Test
    public void loginVWOPositive() throws InterruptedException, IOException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        chromeOptions.addArguments("--start-maximized");


        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com/#/login");
        String loginTitle = driver.getTitle();
        System.out.println(loginTitle);
        Assert.assertEquals(loginTitle, "Login - VWO");

        driver.findElement(By.name("username")).sendKeys("TestQ4@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("VWOtest4");

        driver.findElement(By.id("js-login-btn")).click();

        Thread.sleep(5000);
        String dashboardTxt = driver.findElement(By.className("page-heading")).getText();
        System.out.println(dashboardTxt);
        Assert.assertEquals(dashboardTxt,"Dashboard");
        Thread.sleep(1000);

        String name = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div[1]/p/span[1]")).getText();
        System.out.println("User Name : " + name);
        Assert.assertEquals(name, "Test Q4");

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/java/org/example/Assignment/VWO_Dashboard.png"));


        driver.quit();


    }

}
