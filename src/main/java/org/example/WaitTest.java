package org.example;
import org.openqa.selenium.WebElement;
import  org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.openqa.selenium.support.ui.ExpectedConditions;
import  java.time.Duration;


public class WaitTest {
    public static void main(String[] args){

        WebDriver driver  = new ChromeDriver();

        //implicit wait - ek bar likho pure code me chal jaye gi
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));  //   . means iska

        driver.get("https://www.saucedemo.com");


        //Explicit Wait:
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("user-name")));

        username.sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        // Check karo
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}


