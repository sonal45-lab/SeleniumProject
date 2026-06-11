package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagey {

    WebDriver driver;

    By pageTitle    = By.className("title"); //   By pageTitle  -: by element ka type he
    By cartIcon     = By.className(                   // By.className -: kese dundna he class name se dunadana he
            "shopping_cart_link");
    By productNames = By.className(
            "inventory_item_name");

    public HomePagey(WebDriver driver) {  //object bante hi contru automatically call hoga  use driver driver degha
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle)
                .getText();
    }

    public void clickCart() {
        driver.findElement(cartIcon)
                .click();
    }

    public void clickFirstProduct() {
        driver.findElement(productNames)
                .click();
    }

    public boolean isHomePageDisplayed() {
        return driver.getCurrentUrl()
                .contains("inventory");
    }
}