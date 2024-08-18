package org.example.July.Ex_11072024;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

@Test
public class Lab001 {
    public static void main(String[] args) throws InterruptedException {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        Thread.sleep(1000);
        driver.quit();


        // Selenium Flow
        // 1. Create SessionID - q09876q789e8wq89we87
        // Client - Java(Program)
        // Server - Webdriver Edge - Command W3C -> Edge browser
        // 2. Session -> Run the commands - GET -> GET Method w3c Protocol
        // 3. EdgeDriver (Server) -> Tell the Edge Browser
        // 4. Open a Fresh copy of the Edge Browser and
        // Open the URL - https//sdet.live
        // 5. Driver - Command (POST) Request - Shutdown the browser. SessionID == null


    }
}
