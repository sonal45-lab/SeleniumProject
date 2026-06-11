package org.example;
import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.By;
import  org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AssertionTest {
    public static  void main(String[] args) {

        WebDriver drive = new ChromeDriver();


        drive.get("https://www.saucedemo.com");

        WebElement username = drive.findElement(By.id("user-name"));
        username.sendKeys("standard_user");


        WebElement password = drive.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

      //  WebElement log = drive.findElement(By.xpath("//input[@id='user-name'])");
        WebElement loginButton = drive.findElement(By.id("login-button"));
        loginButton.click();

      //  Thread.sleep(3000);

        String actualUrl = drive.getCurrentUrl();
        String exceptedUrl = "https://www.saucedemo.com/inventory.html";

        if(actualUrl.equals(exceptedUrl))
        {
            System.out.println("login succes");
        }
        else {
            System.out.println("login is  not  success");
        }

        System.out.println("Tilte : " + drive.getTitle());

        drive.quit();



    }



}
//*[@id="user-name"]