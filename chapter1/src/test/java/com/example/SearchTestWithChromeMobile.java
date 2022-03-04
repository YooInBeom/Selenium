package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTestWithChromeMobile {

    WebDriver driver;

@BeforeMethod
 public void setup() {
	
	System.setProperty("chrome.drriver",
			"./src/test/resources/drivers/chromedriver");
	
    Map<String, Object> deviceMetrics = new HashMap<>();
    deviceMetrics.put("width", 411);
    deviceMetrics.put("height", 823);
    deviceMetrics.put("pixelRatio", 3.0);


    Map<String, Object> mobileEmulation = new HashMap<>();
    mobileEmulation.put("deviceMetrics", deviceMetrics);
    mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 6.0; "
    		+ "Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) "
    		+ "Chrome/98.0.4758.109 Mobile Safari/537.36");

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

    driver = new ChromeDriver(chromeOptions);
    driver.get("http://demo-store.seleniumacademy.com/");
 }
@Test
 public void searchProduct() {

    WebElement lookingGlassIcon =
            driver.findElement(By
                    .cssSelector("a.skip-search span.icon"));

    lookingGlassIcon.click();


    WebElement searchBox = driver.findElement(By.name("q"));

    searchBox.sendKeys("Phones");

    WebElement searchButton =
            driver.findElement(By.className("search-button"));

    searchButton.click();

    assertThat(driver.getTitle())
            .isEqualTo("Search results for: 'Phones'");
 }

@AfterMethod
 public void tearDown() {
    driver.quit();
 }
}
