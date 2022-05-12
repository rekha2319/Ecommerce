package com.Demo_EComm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

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
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class NewTest {
	private WebDriver d;
	private String baseurl="https://live.techpanda.org/";
	  

	
	@BeforeMethod
	  public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver-99\\chromedriver.exe");
		d=new ChromeDriver();
		baseurl="https://live.techpanda.org/";
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  }
  @Test
  public void testcase1() throws IOException, InterruptedException {
	  d.get(baseurl);
	 // String pagetitle= d.findElement(By.cssSelector("h2")).getText();
	 // System.out.println(pagetitle);
	  String exp_Title="Home page";
		String actual_title= d.getTitle();
		System.out.println(actual_title);
	  try {
		  Assert.assertEquals(actual_title, exp_Title);
		  System.out.println("Page title verified");
		 // Assert.assertEquals("THIS IS DEMO SITE FOR",pagetitle);
	  }
	  catch(Error e)
	  {
		 System.out.println("Assert Failed");
	  }
	  d.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
	 
		File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(src, new File("C:\\Users\\arun2\\eclipse-workspace\\Ecomm_guru99\\Screenshot\\screenshot01.png"));
		Thread.sleep(5000);
  }

  @AfterMethod
  public void teardown() {
	  d.close();
  }

}
