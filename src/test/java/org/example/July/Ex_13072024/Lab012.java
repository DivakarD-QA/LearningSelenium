package org.example.July.Ex_13072024;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Lab012 {


        @Test
    public void testVWONegative(){
            //        **Project #1 - TC ( Negative) - Invalid username, pass - Error message**
//
//        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
//        2. **Find the Email id** and enter the email as admin@admin.com
//        3. **Find the pass inputbox** and enter passwrod as admin.
//        4. Find and Click on the submit button
//        5. Verify that the error message is shown "Your email, password, IP address or location did not match"
//

            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--guest");


            WebDriver driver = new EdgeDriver(edgeOptions);
            driver.get("https://app.vwo.com/#/login");
            driver.getTitle();
            Assert.assertEquals(driver.getTitle(), "Login - VWO");
            Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

            driver.findElement(By.id("login-username")).sendKeys("admin@admin.com");
            driver.findElement(By.id("login-password")).sendKeys("password123");
            driver.findElement(By.id("js-login-btn")).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String err_msg = driver.findElement(By.className("notification-box-description")).getText();
            Assert.assertEquals(err_msg, "Your email, password, IP address or location did not match");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
            driver.quit();
        }


}
