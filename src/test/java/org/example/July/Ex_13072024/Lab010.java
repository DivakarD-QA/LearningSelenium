package org.example.July.Ex_13072024;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab010 {
    public static void main(String[] args) throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        // Browser - Headless (No UI) or full mode
        // 1.Headless - No UI, performance good, fast execution
        // 2. Full Mode - UI, performance lag, >100

        // Options - Browser  - start maximize, add extension, add options or param


//        options.addArguments("--window-size=800,600");

        options.addArguments("--start-maximized");
        options.addArguments("--guest");

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("183.89.43.108:8080");
        options.setCapability("proxy", proxy);

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.flipkart.com");
        driver.manage().window().minimize();
        driver.quit();

    }
}
