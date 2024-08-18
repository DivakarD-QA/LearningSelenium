package org.example.July.Ex_16072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Lab015_Xpath {

    @Test
    public void testXpath(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        //edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        System.out.println(driver.getTitle());

//       Default Locator Strategy - ID,  Name, Class - Unique - Super Good.
        // Xpath or CSS Selector Strategy
        //  Which is good, xpath or css Selector?
        //  Css Selectors -> little fast, Nowdays since more ram - xpath  == css selector
        // Xpath -> , css Seelctor -
        // 25Test - mixture, it depends - sometimes xpath easy -

        // Xpath or Css Selector - converted to each vice -
        // Css Selector - Css Engine - little fast to find the element

        // What is XPath?
        // XPath is a query language.
        // for selecting nodes from an XML document.
        // HTML -> xml type of document - tag based - A
        // XPath was defined by the World Wide Web Consortium.
        // All the major browsers understand and supports it. W3C

        // Type of Xpath

        // Absolute Xpath - Full Xpath - Type #1
        // /html/body/div[2]/div[1]/div[2]/div/div[1]/div/div/div[3]/form[1]/ul/li[1]/div/input
        // It is too long -
        // prone to change - any change in div or html - Axpath will  work
        // no BODY USe THIS


        // Relative Xpath (with Query)
        // Core Logic - //tagName[@attribute='value']
        // Selenium -id -?
        // || //input[@id="js-login-confirm-email"]


//        WebElement fullXpath = driver.findElement(By.xpath("/html/body/header/div/a"));
//        fullXpath.click();

//        WebElement normalXpath = driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]"));
//        normalXpath.click();

          WebElement tagnameXpath = driver.findElement(By.xpath("//a[@id=\"btn-make-appointment\"]"));
          tagnameXpath.click();

        // Strategy to find the elements
        // id="txt-username" - Unique
        // name="username" - Unique
        // class="form-control" - Not Unique - Find multiple - useless
        // Link - Partial - Since it is not a  a chane , we can't use
        // Relative Xpath  ||
        // Functions
        //  Axes
        // Multiple Attributes - make it unique
        // Css Selectors


        List<WebElement> username_element = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username_element.get(1).sendKeys("John Doe");

        // Xpath Functions
        // Where they are useful? - dynamic text or elements
        // They are usefull when in the value - some constant and some dynamic
        //  title = "pramod_2323"
        // starts-with -> pramod, contains - Partial Match

        // //img[contains(@title,"Flip")]

        // //img[starts-with(@title,"Flip")]
        // substring-after

        // normalize-space = remove the  title= " pramod "

        //a[text()="Make Appointment"] - Exact Match


       driver.findElement(By.xpath(" //p[@class=\"lead\"]")).isDisplayed();
       // contains and text()
       driver.findElement(By.xpath(" //p[contains(text(),\"Please login to\")]")).isDisplayed();

       //contains
       WebElement password = driver.findElement(By.xpath("//input[contains(@name, \"pass\")]"));
       password.sendKeys("ThisIsNotAPassword");

       //starts-with
       driver.findElement(By.xpath("//a[starts-with(@id, \"menu\")]")).click();

        // ends-with
      // driver.findElement(By.xpath(""));

        //* -> Select all the nodes - Select * from all element in html; all elemts
        //input -> Select all input box - select inputs from all the in html - all inputs
        //input[@title="flipkart"] = select input from all the html where title = flipkart; =1
        //input[text()="flipkart"] = select input from all the html where text() = flipkart; =1




    }


}
