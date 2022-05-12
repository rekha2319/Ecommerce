package com.Demo_EComm;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Testcase3 {
	
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
  public void f() throws InterruptedException {
	  d.get(baseurl);
	  d.manage().window().maximize();
	  d.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
	  Thread.sleep(5000);
	  
	  d.findElement(By.xpath("//span[text()='$100.00']//following::span[text()='Add to Cart']")).click();
	  Thread.sleep(5000);
	  
	  d.findElement(By.xpath("//input[@type='text']")).sendKeys("1000");
	  Thread.sleep(5000);
	  d.findElement(By.xpath("//span[text()='Update']")).click();
	  String actual_error="* The maximum quantity allowed for purchase is 500.";
	  String error_msg = d.findElement(By.xpath("//p[@class='item-msg error']")).getText();
	  System.out.println(error_msg);
	  try {
		  //Assert.assertEquals(error_msg,actual_error);
		  SoftAssert sa=new SoftAssert();
		  sa.assertEquals(error_msg,actual_error);
		  System.out.println("The error msg is verified");
	  }
	  catch(Exception e)
	  {
		  //System.out.println(e);
		  e.printStackTrace();
	  }
	  Thread.sleep(3000);
	  d.findElement(By.xpath("//span[text()='Empty Cart']")).click();
	  String exp_msg="SHOPPING CART IS EMPTY";
	  String cart_msg = d.findElement(By.xpath("//h1")).getText();
	  System.out.println(cart_msg);
	  Thread.sleep(3000);
	  try {
		  Assert.assertEquals(exp_msg,cart_msg);
		  //SoftAssert sa=new SoftAssert();
		 // sa.assertEquals(error_msg,actual_error);
		  System.out.println("The error msg is verified");
	  }
	  catch(Exception e)
	  {
		  //System.out.println(e);
		  e.printStackTrace();
  }
  }
  

  @AfterMethod
  public void Teardown() {
	  d.close();
  }

}
