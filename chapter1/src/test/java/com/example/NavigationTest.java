package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class NavigationTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        System.setProperty("chrome.driver",
                "./src/test/resources/drivers/chromedriver");
        
        ChromeOptions chromeOptinons = new CrhomeOptions();
        chromeOptions.setHeadless(true);

        driver = new ChromeDriver();
    }

    @Test
    public void navigateToAUrl() {

        driver.get("http://demo-store.seleniumacademy.com/");

       // Assert.assertEquals(driver.getTitle(), "Madison Island");
    }

    @AfterMethod
    public void afterMethod() {
    	
        driver.quit();
    }

}
