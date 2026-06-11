package org.example.Tests;

import org.example.pages.HomePagey;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePagey homePage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        homePage  = new HomePagey(driver);
    }

    @Test
    public void validLoginTest() {
        loginPage.login(
                "standard_user",
                "secret_sauce");
        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Home page nahi khula!");
        System.out.println(
                "✅ Valid Login — PASS!");
    }

    @Test
    public void invalidLoginTest() {
        loginPage.login(
                "wrong_user",
                "wrong_pass");
        Assert.assertFalse(
                loginPage.isLoginSuccessful(),
                "Login nahi hona chahiye!");
        System.out.println(
                "✅ Invalid Login — PASS!");
    }

    @Test(dataProvider = "loginData")
    public void dataLoginTest(
            String username,
            String password,
            boolean expected) {
        loginPage.login(username, password);
        Assert.assertEquals(
                loginPage.isLoginSuccessful(),
                expected,
                "Login result galat!");
        System.out.println(
                "✅ Data Test — " + username);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"standard_user",
                        "secret_sauce", true},
                {"wrong_user",
                        "wrong_pass",   false},
                {"locked_out_user",
                        "secret_sauce", false}
        };
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}