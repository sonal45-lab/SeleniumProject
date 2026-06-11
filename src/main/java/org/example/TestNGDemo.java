package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import  org.openqa.selenium.chrome.ChromeDriver;
import  org.testng.Assert;
import  org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Test(priority = 3)  //test1
    public void validTest(){
        driver.findElement(By.name("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.name("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.name("login-button"))
                .click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.saucedemo.com/inventory.html");
        System.out.println("valid login");
    }

    @Test(priority = 2)
    public void invalidTest(){                      //test2
        driver.findElement(By.name("user-name"))
                .sendKeys("standard-user");

        driver.findElement(By.name("password"))
                .sendKeys("secret-sauce");

        driver.findElement(By.name("login-button"))
                .click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.saucedemo.com/inventory.html");
        System.out.println("invalid login");
    }

    @Test(priority = 1)
    public void titleTest() {
        String title = driver.getCurrentUrl();
        System.out.println("✅ Title: " + title );
    }

    @AfterMethod
    public void teardowm(){
            driver.quit();
    }

}
