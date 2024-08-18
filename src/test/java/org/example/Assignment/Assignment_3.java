package org.example.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment_3 {

    @Test
    public void driver() throws InterruptedException {
//        Selenium Mini Project #3
//
//        Open the URL - https://www.idrive360.com/enterprise/login
//        Enter the username, password
//        Verify that Trial is fnished and current URL also
//        Add a logic to add Allure Screen for the Trail end.
//        augtest_040823@idrive.com
//        123456

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "IDrive® 360 - Sign in to your account");

        String landingURL = driver.getCurrentUrl();
        Assert.assertEquals(landingURL,"https://www.idrive360.com/enterprise/login");

        String signInTxt = driver.findElement(By.className("id-maincnt-title")).getText();
        System.out.println(signInTxt);
        Assert.assertEquals(signInTxt, "Sign in to IDrive® 360");
        driver.findElement(By.linkText("Create new account")).isDisplayed();
        driver.findElement(By.linkText("Forgot Password?")).isDisplayed();
        driver.findElement(By.linkText("Single Sign On (SSO)")).isDisplayed();

        driver.findElement(By.id("username")).sendKeys("augtest_040823@idrive.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.id("frm-btn")).click();



// Find the element by its locator (e.g., id, name, CSS selector, etc.)
        By profile = (By.id("profileAccount"));

// Create an instance of WebDriverWait with a timeout value
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

// Wait until the element is visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(profile));

// Now you can interact with the element
        element.isDisplayed();
        System.out.println(element.getText());

        driver.findElement(By.id("upgrade")).isDisplayed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.idrive360.com/enterprise/account?upgradenow=true");

        driver.findElement(By.linkText("A")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"Profiledrp-dwn\"]/ul/li[2]/a")).click();
        System.out.println("Clicking Logout");

        Thread.sleep(2000);
        Assert.assertEquals(signInTxt, "Sign in to IDrive® 360");

        driver.quit();
    }
}
