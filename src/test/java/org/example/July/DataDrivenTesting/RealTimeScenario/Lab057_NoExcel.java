package org.example.July.DataDrivenTesting.RealTimeScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab057_NoExcel {

    // Get the data from script and use it
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    WebDriver driver;

    @Test(dataProvider = "loginData")
    public void testDataDriven(String id, String email, String password, String expectedResult) {
        driver.get("https://app.vwo.com");
        WebElement emailElement = driver.findElement(By.id("login-username"));
        emailElement.clear();
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.id("login-password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        driver.findElement(By.id("js-login-btn")).click();

        if (expectedResult.equalsIgnoreCase("Valid")) {
            String text = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]")).getText();
            System.out.println(text);
            Assert.assertEquals(text,"Test Q4");
            driver.findElement(By.xpath("//img[@data-qa=\"user-image\"]")).click();
            driver.findElement(By.xpath("//li[@data-qa=\"logout-btn\"]")).click();
        }
        if (expectedResult.equalsIgnoreCase("InValid")) {
            WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(error_message));
            Assert.assertTrue(error_message.isDisplayed());
            Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");

        }
    }


    @DataProvider(name = "loginData")
    public Object[][] testData(){
        return new Object[][]{
                {"TD1", "TestQ4@gmail.com", "VWOtest4", "Valid"},
                {"TD2", "TestQ4@gmail.com", "VWOtest45", "InValid"},
                {"TD3", "TestQ4@gmail.com", "VWOtest4", "Valid"},

        };
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
