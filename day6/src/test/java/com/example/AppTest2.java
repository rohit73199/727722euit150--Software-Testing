package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest2 {
    WebDriver driver;
    @BeforeMethod
    public void beforemethod(){
    WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
      driver.manage().window().fullscreen();
      System.out.println("beforemethod");
    }
    @Test(priority=0)
    public void test0()
    {
        System.out.println("test0");
        driver.get("https://www.google.com/");
    }
    @Test(priority=1)
    public void test1()
    {
        System.out.println("test1");
        driver.get("https://www.bing.com/");
    }
    @Test(priority=2)
    public void test2()
    {
        System.out.println("test2");
        driver.get("https://skcet530.examly.io/login");
    }
    @Test(priority=3)
    public void test3()
    {
        System.out.println("test3");
        driver.get("https://www.yahoo.com/");
    }
    @AfterMethod
    public void aftermethod()
    {
        System.out.println("driver quit");
        driver.quit();
    }
}
