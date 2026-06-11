package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupsDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    // Smoke + Login group
    @Test(groups = {"smoke", "login"})
    public void validLoginTest() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        System.out.println("✅ Valid Login!");
    }

    // Login group
    @Test(groups = {"login"})
    public void invalidLoginTest() {
        driver.findElement(By.id("user-name"))
                .sendKeys("wrong_user");
        driver.findElement(By.id("password"))
                .sendKeys("wrong_pass");
        driver.findElement(By.id("login-button"))
                .click();
        System.out.println("❌ Invalid Login!");
    }

    // Smoke + regression group
    @Test(groups = {"smoke", "regression"})
    public void titleTest() {
        String title = driver.getTitle();
        System.out.println("📝 Title: " + title);
    }

    // Regression group
    @Test(groups = {"regression"})
    public void urlTest() {
        String url = driver.getCurrentUrl();
        System.out.println("🔗 URL: " + url);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}