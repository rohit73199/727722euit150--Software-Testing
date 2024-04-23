package com.example;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orangehrm {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void test() throws Exception{
        FileInputStream fs=new FileInputStream("C:\\Users\\rohit\\Downloads\\orangehrm (2).xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fs);
        XSSFSheet login=wb.getSheet("Login");
        XSSFRow row1=login.getRow(1);
        String username=row1.getCell(0).getStringCellValue();
        String password=row1.getCell(1).getStringCellValue();
        driver.findElement((By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement((By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))).click();
        Thread.sleep(5000);

    }
    @AfterMethod
    public void quitdriver(){
        driver.quit();
    }
}