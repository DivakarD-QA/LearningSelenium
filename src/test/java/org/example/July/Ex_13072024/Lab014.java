package org.example.July.Ex_13072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Lab014 {

    @Test

    public void testFreeTrail() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");


        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com/#/login");
        String loginTitle = driver.getTitle();
        System.out.println(loginTitle);
        Assert.assertEquals(loginTitle, "Login - VWO");

        driver.findElement(By.name("username")).sendKeys("Admin@Admin.com");
        driver.findElement(By.id("login-password")).sendKeys("Pas123");

        driver.findElement(By.id("js-login-btn")).click();

        Thread.sleep(1000);

        String err_msg = driver.findElement(By.className("notification-box-description")).getText();
        junit.framework.Assert.assertEquals(err_msg, "Your email, password, IP address or location did not match");

        WebElement trailLink = driver.findElement(By.linkText("Start a free trial"));
        trailLink.click();

        String trailTitle = driver.getTitle();
        Assert.assertEquals(trailTitle, "Get Started with Free Trial | VWO");
        System.out.println(trailTitle);


        driver.findElement(By.id("page-v1-step1-email")).sendKeys("admin@admin.com");
        driver.findElement(By.name("gdpr_consent_checkbox")).click();
        driver.findElement(By.tagName("button")).click();

//        List <WebElement> createBtn = driver.findElements(By.tagName("button"));
//        createBtn.get(0).click();

        Thread.sleep(2000);

        String invalidEmail = driver.findElement(By.className("invalid-reason")).getText();
        System.out.println(invalidEmail);
        Assert.assertEquals(invalidEmail, "An account with this email already exists. Login Here");

        Thread.sleep(1000);
        driver.quit();
    }
}
