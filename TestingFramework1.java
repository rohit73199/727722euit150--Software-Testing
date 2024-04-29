package com.example;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingFramework1 {
    WebDriver driver;
    @Test(dataProvider = "data")
    public void test1(String username, String password) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input")))
                .sendKeys(username);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/input")))
                .sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/button"))).click();
        WebElement home=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/aside/nav/div[2]/ul/li[1]/a")));
        String hometext=home.getText();
        if(hometext.equalsIgnoreCase("Home"))
        {
            System.out.println(true);
        }
        else{
            
            System.out.println(false);
        }
        
    }

    @DataProvider(name = "data")
    public Object[][] fetchData() throws Exception {
        Object[][] data = new Object[2][2];
        data[0][0] = "S@gmail.com";
        data[0][1] = "P@ssword12";
        data[1][0] = "Admin111";
        data[1][1] = "admin123111";
        return data;
    }
}
