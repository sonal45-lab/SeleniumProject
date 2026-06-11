package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    // Data Provider — Data deta hai
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", true},
                {"wrong_user",    "wrong_pass",   false},
                {"locked_out_user","secret_sauce", false}
        };
    }

    // Test — DataProvider se data leta hai
    @Test(dataProvider = "loginData")
    public void loginTest(String username,
                          String password,
                          boolean expectedLogin) {

        driver.findElement(By.id("user-name"))
                .sendKeys(username);
        driver.findElement(By.id("password"))
                .sendKeys(password);
        driver.findElement(By.id("login-button"))
                .click();

        String url = driver.getCurrentUrl();
        boolean actualLogin = url.contains("inventory");

        if(expectedLogin == actualLogin) {
            System.out.println("✅ PASS — User: "
                    + username);
        } else {
            System.out.println("❌ FAIL — User: "
                    + username);
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}