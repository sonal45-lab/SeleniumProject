package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class priority {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    // Pehle login hoga
    @Test(priority = 1)
    public void loginTest() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        System.out.println("1️⃣ Login Test!");
    }

    // Doosra title check hoga
    @Test(priority = 2)
    public void titleTest() {
        String title = driver.getTitle();
        System.out.println("2️⃣ Title: " + title);
    }

    // Teesra URL check hoga
    @Test(priority = 3)
    public void urlTest() {
        String url = driver.getCurrentUrl();
        System.out.println("3️⃣ URL: " + url);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}