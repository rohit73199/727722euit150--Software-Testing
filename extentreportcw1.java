package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreportcw1 {
    
    WebDriver driver = new ChromeDriver();
    ExtentReports extentrep;
    ExtentTest test;
    WebDriverWait wait;

    @BeforeMethod
    public void beforetest(){
        wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        ExtentSparkReporter report=new ExtentSparkReporter("C:\\Users\\rohit\\Downloads\\demo\\src\\reports\\report.html");
        extentrep =new ExtentReports();
        extentrep.attachReporter(report);
        driver.get("https://groww.in/");
    }
    @Test(priority = 0)
    public void testsetup() throws Exception{
        FileInputStream fs= new FileInputStream("C:\\Users\\rohit\\Downloads\\groww.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fs);
        XSSFSheet sheet1=wb.getSheet("Sheet1");
        XSSFRow row1=sheet1.getRow(0);
        double amount=row1.getCell(0).getNumericCellValue();
        double interest=row1.getCell(1).getNumericCellValue();
        double tenure=row1.getCell(2).getNumericCellValue();
        test=extentrep.createTest("test started");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement calculators =wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Calculators")));
        js.executeScript("arguments[0].scrollIntoView();", calculators);
        calculators.click();
        Thread.sleep(5000);
        if(driver.getPageSource().contains("Calculators")){
        test.log(Status.PASS,"Calcualtor is present");
        extentreportcw1.takescreenshot(driver,"C:\\Users\\viswa\\Downloads\\demo\\src\\screenshots\\screenshot.png");
        }
        else{
            test.log(Status.FAIL,"Calculator is not present");
        }
        WebElement homeloan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/a[15]")));
        js.executeScript("arguments.scrollIntoView", homeloan);
        homeloan.click();
        WebElement loanamount=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='LOAN_AMOUNT']")));
        WebElement rateofinterest=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='RATE_OF_INTEREST']")));
        WebElement loantenure=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='LOAN_TENURE']")));
        Thread.sleep(2000);
        loanamount.clear();
        Thread.sleep(2000);
        loanamount.sendKeys(""+amount);
        Thread.sleep(2000);
        rateofinterest.clear();
        Thread.sleep(2000);
        rateofinterest.sendKeys(""+interest);
        Thread.sleep(2000);
        loantenure.clear();
        Thread.sleep(2000);
        loantenure.sendKeys(""+tenure);
        Thread.sleep(3000);
        if(driver.getPageSource().contains("Your Amortization Details (Yearly/Monthly)")){
            test.log(Status.PASS, "Your Amortization Details (Yearly/Monthly) text is present",MediaEntityBuilder.createScreenCaptureFromPath("C:\\\\Users\\\\viswa\\\\Downloads\\\\demo\\\\src\\\\screenshots\\\\screenshot.png").build());
        }
        else{
            test.log(Status.FAIL,"Your Amortization Details (Yearly/Monthly) text is not present");
        }
    }
        public static void takescreenshot(WebDriver d,String path) throws Exception{
            TakesScreenshot scr=((TakesScreenshot) d);
            File scrfile=scr.getScreenshotAs(OutputType.FILE);
            File destFile=new File(path);
            FileUtils.copyFile(scrfile, destFile);
    
        }
        @AfterMethod
        public void close() throws Exception{
            extentrep.flush();
            driver.quit();
        }
    }