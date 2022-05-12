package com.Demo_EComm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase5 {
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
	  d.findElement(By.xpath("//span[contains(text(),'Account')]")).click();
	  
	  for(String handles:d.getWindowHandles())
	  {
		  d.switchTo().window(handles);
	  }
	  
	  d.findElement(By.xpath("//a[text()='Log In']")).click();
	  Thread.sleep(3000);
	  
	  d.findElement(By.xpath("//input[@type='email']")).sendKeys("irekhacooks@gmail.com");
	  d.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
	  d.findElement(By.xpath("//span[text()='Login']")).click();
	  Thread.sleep(3000);
	  
	  String text = d.findElement(By.xpath("//strong[text()='Hello, Reka s Arun!']")).getText();
	  System.out.println("Account successfully created " +text);
	  
	  d.findElement(By.xpath("//a[text()='TV']")).click();
	  Thread.sleep(3000);
	  
	  d.findElement(By.xpath("//following::a[text()='Add to Wishlist']")).click();
	  Thread.sleep(3000);
	  d.findElement(By.xpath("//span[text()='Share Wishlist']")).click();
	  Thread.sleep(3000);
	  d.findElement(By.xpath("//textarea[@name='emails']")).sendKeys("rekha2319@gmail.com");
	  d.findElement(By.xpath("//textarea[@name='message']")).sendKeys("hello");
	  Thread.sleep(3000);
	  d.findElement(By.xpath("//button[@type='submit' and @class='button']")).click();
	  Thread.sleep(3000);
	  
	  String txt ="Your Wishlist has been shared.";
	  String text2 = d.findElement(By.xpath("//span[contains(text(),'Your Wishlist has been shared.')]")).getText();
	  System.out.println(text2);
	  
	  try {
		  Assert.assertEquals(text2, txt);
		  System.out.println("Whishlist successfully sent");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  //Registration 
	  /*
	  d.findElement(By.linkText("Register")).click();
	  Thread.sleep(3000);
	  
	  d.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Reka");
	  d.findElement(By.xpath("//input[@name='middlename']")).sendKeys("s");
	  d.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Arun");
	  d.findElement(By.xpath("//input[@name='email']")).sendKeys("irekhacooks@gmail.com");
	  d.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
	  d.findElement(By.xpath("//input[@name='confirmation']")).sendKeys("123456");
	  Thread.sleep(3000);
	  d.findElement(By.xpath("//span[text()='Register']")).click();
	  */
	  Thread.sleep(3000);
	 
  }
  
  
  @AfterMethod
  public void Teardown() {
	  d.close();
	  
  }
}
