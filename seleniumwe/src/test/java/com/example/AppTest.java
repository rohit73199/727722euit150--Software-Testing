package com.example;
 
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        // assertTrue( true );
        WebDriverManager.chromedriver().setup(); // set up our driver for specific browser
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoblaze.com/"); 
        driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("MacBook air")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        // WebElement element;
        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(5000);
    
        driver.quit();


    }

}