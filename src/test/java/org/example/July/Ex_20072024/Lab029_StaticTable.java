package org.example.July.Ex_20072024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab029_StaticTable {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    @Test
    public void staticTable(){
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);
        System.out.println(driver.getTitle());

        // Print all the data in the table. - P1
        // Halen belong to which country  - P2

        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        //table[@id="customers"]/tbody/tr[i]/td[j]
        // i = 1 to 7
        // j = 1 to 3

        //table[@id="customers"]/tbody/tr[2]/td[]

        String first_path = "//table[@id=\"customers\"]/tbody/tr[";
        String second_path = "]/td[";
        String third_path = "]";



        for(int i = 2; i<=row; i++){
            for(int j=1; j<=col; j++) {
                String dynamic_path = first_path + i + second_path + j + third_path;
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                //System.out.println(data);
            if(data.contains("Yoshi Tannamuri")){
                String company_path= driver.findElement(By.xpath(dynamic_path + "/preceding-sibling::td")).getText();
                String country_path= driver.findElement(By.xpath(dynamic_path + "/following-sibling::td")).getText();

                System.out.println("Company Name is : " + company_path);
                System.out.println("Country Name is : " + country_path);

            }

            }
        }







    }


    @AfterTest
    public void closeBrowser() {

        //driver.quit();
    }
}
