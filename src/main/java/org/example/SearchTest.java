package org.example;
import org.openqa.selenium.WebDriver; // ye mera tools he
import org.openqa.selenium.chrome.ChromeDriver; //chrome open hoga
import org.openqa.selenium.By; //ye search bar ka tool import kiya he isme code use kar sakte he
import org.openqa.selenium.WebElement; //ye hmare page and button me


public class SearchTest {
    public static  void main(String args[])
            throws InterruptedException
    {
         WebDriver drive = new ChromeDriver();

         drive.get("http://www.google.com");
         WebElement seachbox = drive.findElement(By.name("q"));  //ye  ye sreach karana he
         seachbox.sendKeys("selenium  Automation");   //search box me type hoga
         seachbox.submit();
        Thread.sleep(3000);
         System.out.println("title : " +  drive.getTitle());
         drive.quit();
        }


}



