package com.Demo_EComm;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase4 {
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
  public void f() throws InterruptedException, IOException {
	  d.get(baseurl);
	  d.manage().window().maximize();
	  d.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
	  Thread.sleep(5000);
	  
	  d.findElement(By.xpath("//span[text()='$500.00']//following::a[text()='Add to Compare']")).click();
	  Thread.sleep(3000);
	  
	  d.findElement(By.xpath("//a[text()='Samsung Galaxy']//following::a[text()='Add to Compare']")).click();
	  d.findElement(By.xpath("//span[text()='Compare']")).click();
	  Thread.sleep(5000);
	  
	  for(String handles: d.getWindowHandles())
	  {
		  d.switchTo().window(handles);
	  }
	  String exp_popup_text="COMPARE PRODUCTS";
	  System.out.println("expected text= "+ exp_popup_text);
	  String popup_text = d.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div[1]/h1")).getText();
	  System.out.println("Actual pop up text = " + popup_text);
	  try {
		  Assert.assertEquals(exp_popup_text,popup_text);
	  }
	  catch(Exception e)
	 
	  {
		  e.printStackTrace();
	  }
	  
	  Thread.sleep(3000);
	  String iphone_text = d.findElement(By.xpath("//a[text()='IPhone']")).getText();
	  System.out.println(" Phone 1 = "+ iphone_text);
	  String samsung_text = d.findElement(By.xpath("//a[text()='Samsung Galaxy']")).getText();
	  System.out.println("phone 2 = "+ samsung_text);
	  Thread.sleep(5000);
	  
	  File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src,new File("C:\\Users\\arun2\\eclipse-workspace\\Ecomm_guru99\\Screenshot\\shot3.png"));
	  
	  Thread.sleep(3000);
	  d.findElement(By.xpath("//span[text()='Close Window']")).click();
	  
	  for(String handles:d.getWindowHandles())
	  {
		  d.switchTo().window(handles);
	  }
	  
  
  }
  
  @AfterMethod
  public void Teardown() {
	  d.close();
  }
}
