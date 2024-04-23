package com.example;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeAppTestXM {
    WebDriver driver;
    @Test(dataProvider = "data")
    public void test1(String username, String password) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
                .sendKeys(username);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
                .sendKeys(password);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    }

    @DataProvider(name = "data")
    public Object[][] fetchData() throws Exception {`
        Object[][] data = new Object[2][2];
        data[0][0] = "Admin";
        data[0][1] = "admin123";
        data[1][0] = "Admin111";
        data[1][1] = "admin123111";
        return data;
    }
}
