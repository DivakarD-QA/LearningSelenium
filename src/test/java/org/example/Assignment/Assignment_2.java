package org.example.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.SortedMap;

import static java.awt.SystemColor.text;

public class Assignment_2 {
//    open the url - https://katalon-demo-cura.herokuapp.com/
//    click on the make appoinment button
//    verify that url changes - assert
//            time.sleep(3)
//    enter the username, password
//    next page verify the current url
//    make appoinment text on the web page.

@Test
     public void curaLogin() throws InterruptedException {

    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--guest");
    edgeOptions.addArguments("--start-maximized");

    WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://katalon-demo-cura.herokuapp.com/");
    String title = driver.getTitle();
    System.out.println(title);
    Assert.assertEquals(title, "CURA Healthcare Service");
    Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

    driver.findElement(By.id("btn-make-appointment")).click();

    Thread.sleep(3000);

    String loginText = driver.findElement(By.className("lead")).getText();
    System.out.println(loginText);
    Assert.assertEquals(loginText,"Please login to make appointment.");

    String loginURL = driver.getCurrentUrl();
    Assert.assertEquals(loginURL, "https://katalon-demo-cura.herokuapp.com/profile.php#login");

    // Find the input element by its locator (e.g., id, name, CSS selector, etc.)
    WebElement getUserName = driver.findElement(By.cssSelector("input.form-control[placeholder='Username']"));

// Get the value of the input element
    String demoUserName = getUserName.getAttribute("value");

    // Find the input element by its locator (e.g., id, name, CSS selector, etc.)
    WebElement getPassword = driver.findElement(By.cssSelector("input.form-control[placeholder='Password']"));

// Get the value of the input element
    String demoPassword = getPassword.getAttribute("value");


    System.out.println("UserName : " + demoUserName + " | Password : " + demoPassword);

    driver.findElement(By.id("txt-username")).sendKeys(demoUserName);
    driver.findElement(By.id("txt-password")).sendKeys(demoPassword);
    Thread.sleep(1000);
    driver.findElement(By.id("btn-login")).click();


    String makeApp = driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/div/h2")).getText();
    Assert.assertEquals(makeApp, "Make Appointment");
    System.out.println(makeApp);
    Thread.sleep(1000);
    driver.quit();

}
}
