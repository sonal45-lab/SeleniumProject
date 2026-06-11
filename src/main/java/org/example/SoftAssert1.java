package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import  org.testng.asserts.SoftAssert;
public class SoftAssert1 {

            WebDriver driver;

            @BeforeMethod
            public void setup(){
                driver = new ChromeDriver();
                driver.get("https://www.saucedemo.com");
            }

            @Test
            public void softassetTest() {

                SoftAssert sa = new SoftAssert();

                driver.findElement(By.name("user-name"))
                        .sendKeys("standard_user");

                driver.findElement(By.id("password"))
                        .sendKeys("secret_sauce");
                driver.findElement(By.id("login-button"))
                        .click();


                sa.assertEquals(
                        driver.getTitle(),
                        "Swag Labs",
                        "Title galat hai!");
                System.out.println("✅ Check 1 — Title!");

                //2. assertTrue
                // Condition true hai?
                sa.assertTrue(
                        driver.getCurrentUrl()
                                .contains("inventory1"),
                        "URL mein inventory nahi!1");

                // 3. assertFalse
                // Condition false hai?
                sa.assertFalse(
                        driver.getTitle()
                                .isEmpty(),
                        "Title empty hai!");

                // Hamesha last mein!
                sa.assertAll();
            }


                @AfterMethod
                public void teardown1() {
                    driver.quit();
                    System.out.println("❌ Browser Band!");
                }

}
