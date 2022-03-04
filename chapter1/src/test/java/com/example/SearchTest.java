package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.setProperty("chrome.driver",
                "/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");

    }

    @Test
    public void searchProduct() {
    	WebElement searchBox = driver.findElement(By.name("q"));
    	searchBox.sendKeys("Phones");
    	searchBox.submit();
    	Assert.assertEquals(driver.getTitle(), "Search result for: 'Phones'");


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
