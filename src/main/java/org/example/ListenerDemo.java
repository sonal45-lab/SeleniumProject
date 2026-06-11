package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class) // ← Yahan!
public class ListenerDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void validLoginTest() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        System.out.println("Login kiya!");
    }

    @Test
    public void validLoginTest1() {
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button"))
                .click();
        System.out.println("Login kiya!");
    }

    @Test
    public void failTest() {
        driver.findElement(By.id("wrong-id"))
                .click();
    }

    @Test(dependsOnMethods = "failTest")
    public void skipTest() {
        System.out.println("Skip!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}