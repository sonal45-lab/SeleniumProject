package org.example;
import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.By;
import  org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static  void main(String[] args)
            throws  InterruptedException{

        WebDriver drive = new ChromeDriver();
        drive.get("https://www.saucedemo.com");

        WebElement username = drive.findElement(By.id("user-name"));
        username.sendKeys("standard_user");


        WebElement password = drive.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = drive.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(3000);
        System.out.println("URL: " + drive.getCurrentUrl());
      //  System.out.println("page Titale :" + drive.getTitle());

        drive.quit();



    }



}
