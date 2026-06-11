package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DependsDemo {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        System.out.println("🚀 Browser Khula!");
    }

    // Step 1 — Pehle Login
    @Test
    public void loginTest() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        System.out.println("1️⃣ Login Ho Gaya!");
    }

    // Step 2 — Login ke baad Search
    @Test(dependsOnMethods = "loginTest")
    public void searchTest() {
        driver.findElement(
                        By.className("inventory_item_name"))
                .click();
        System.out.println("2️⃣ Product Dekha!");
    }

    // Step 3 — Search ke baad Cart
    @Test(dependsOnMethods = "searchTest")
    public void cartTest() {
        driver.findElement(
                        By.className("btn_inventory"))
                .click();
        System.out.println("3️⃣ Cart Mein Dala!");
    }

    // Step 4 — Cart ke baad Checkout
    @Test(dependsOnMethods = "cartTest")
    public void checkoutTest() {
        driver.findElement(By.className("shopping_cart_link"))
                .click();

        driver.findElement(
                        By.id("checkout"))
                .click();

    }

    @AfterClass
    public void teardown() {
        driver.quit();
        System.out.println("❌ Browser Band!");
    }
}