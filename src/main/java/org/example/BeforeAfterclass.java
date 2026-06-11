package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterclass {

    WebDriver driver;

    // Sirf ek baar — Class shuru hone se pehle
    @BeforeClass
    public void startTesting() {
        System.out.println("🚀 Testing Shuru!");
        System.out.println("=================");
    }

    // Har test se pehle
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        System.out.println("🌐 Browser Khula!");
    }

    // Test 1
    @Test
    public void loginTest() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        System.out.println("✅ Login Test Done!");
    }



    // Test 2
    @Test
    public void titleTest() {
        String title = driver.getCurrentUrl();
        System.out.println("✅ Title: " + title );
    }

    // Har test ke baad
    @AfterMethod
    public void teardown() {
        driver.quit();
        System.out.println("❌ Browser Band!");
    }

    // Sirf ek baar — Class khatam hone ke baad
    @AfterClass
    public void endTesting() {
        System.out.println("=================");
        System.out.println("🏁 Testing Khatam!");
    }
}