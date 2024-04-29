package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingFramework2
{
     @Test
     public void answers() throws InterruptedException
     {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(5000);
        driver.findElement(By.linkText("Laptops")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MacBook air"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart"))).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart"))).click();

        WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]")));
        String mytext=text.getText();
        if(mytext.equalsIgnoreCase("MacBook air"))
        {
            System.out.print(true);
        }
        else{
            System.out.print(false);
            
        }



     }
}
