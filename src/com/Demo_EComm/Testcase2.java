package com.Demo_EComm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Testcase2 {
	private WebDriver d;
	private String baseurl="https://live.techpanda.org";
	
	@BeforeMethod
	  public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver-99\\chromedriver.exe");
		d=new ChromeDriver();
		baseurl="https://live.techpanda.org/";
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  }
	
  @Test
  public void testcase2() throws InterruptedException {
	  d.get(baseurl);
	  d.manage().window().maximize();
	  d.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
	  String xperiaprice= d.findElement(By.xpath("//span[text()='$100.00' and @class='price']")).getText();
	  System.out.println(xperiaprice);
	  
	 // d.findElement(By.id("product-collection-image-1")).click();
	  
	  d.findElement(By.xpath("//h2[@class='product-name']//following::a[@title='Sony Xperia']")).click();
	  Thread.sleep(5000);
	  
	  /*JavascriptExecutor js=((JavascriptExecutor)d);
	  
	  js.executeScript("window.scrollBy(0,500)");
	  String text = d.findElement(By.xpath("//span[text()='Description']//following::div[@class='std']")).getText();
	  System.out.println(text);
	  */
	  String detailsprice = d.findElement(By.xpath("//span[@class='price']")).getText();
	  System.out.println(detailsprice);
	  
	  try {
		  Assert.assertEquals(xperiaprice, detailsprice);
		  System.out.println("prices are same");
		  File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src,new File("C:\\Users\\arun2\\eclipse-workspace\\Ecomm_guru99\\Screenshot\\shot2.png"));
	  }
	  catch(Exception e) {
	  System.out.println("Prices are different");
	  }
  }
  

  @AfterMethod
  public void teardown() {
	  d.close();
  }

}
