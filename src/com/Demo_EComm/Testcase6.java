package com.Demo_EComm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase6 {
	private WebDriver d;
	private String baseurl="https://live.techpanda.org";
	
	@BeforeTest
	  public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\Chrome101\\chromedriver.exe");
		d=new ChromeDriver();
		baseurl="https://live.techpanda.org/";
		//WebDriverWait wait= new WebDriverWait(d,10);
		//wait.until(ExpectedConditions.
		
		d.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
  @Test
  public void f() throws InterruptedException {
	  
	  d.get(baseurl);
	  d.manage().window().maximize();
	  d.manage().getCookies();
	  
	  d.findElement(By.xpath("//span[contains(text(),'Account')]")).click();
	  for(String handles:d.getWindowHandles())
	  {
		  d.switchTo().window(handles);
	  }
	  
	  d.findElement(By.xpath("//a[text()='My Account']")).click();
	  Thread.sleep(3000);
	  
	 
	  d.findElement(By.xpath("//input[@type='email']")).sendKeys("irekhacooks@gmail.com");
	  d.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
	  d.findElement(By.xpath("//span[text()='Login']")).click();
	  Thread.sleep(3000);
	  
  }
  @Test
  public void f1() throws InterruptedException {
	  d.findElement(By.xpath("//a[text()='My Product Reviews']//following::a[contains(text(),'My Wishlist')]")).click();
	  Thread.sleep(3000);
	  d.findElement(By.xpath("//span[text()='Add to Cart']")).click();
	  
	  d.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
	  d.findElement(By.id("billing:firstname")).sendKeys("Rekha");
	  d.findElement(By.id("billing:middlename")).sendKeys("s");
	  d.findElement(By.id("billing:lastname")).sendKeys("Arun");
	  d.findElement(By.id("billing:company")).sendKeys("ABC COMPANY");
	  d.findElement(By.id("billing:street1")).sendKeys("R.S.Puram");
	  d.findElement(By.id("billing:city")).sendKeys("COIMBATORE");
	// select class
	  Select s1=new Select( d.findElement(By.id("billing:region_id")));
	  s1.selectByIndex(2);
	  Thread.sleep(500);
	  
	  d.findElement(By.id("billing:postcode")).sendKeys("641002");
	// select class  
	  Select s2=new Select( d.findElement(By.id("billing:region_id")));
	  s2.selectByIndex(5);
	  Thread.sleep(500);
	  
	  
	  d.findElement(By.id("billing:telephone")).sendKeys("0422473426");
	  Thread.sleep(2000);
	  
	  d.findElement(By.xpath("//button[@type='button' and @onclick='billing.save()']")).click();
	  Thread.sleep(3000);
	  }
  
  
  @Test
  public void f2() throws InterruptedException {
	  
	  d.findElement(By.xpath("//h2[text()='Shipping Information']")).click();
	  Thread.sleep(3000);
	  
	  d.findElement(By.id("billing:firstname")).sendKeys("Rekha");
	  d.findElement(By.id("billing:middlename")).sendKeys("s");
	  d.findElement(By.id("billing:lastname")).sendKeys("Arun");
	  d.findElement(By.id("billing:company")).sendKeys("ABC COMPANY");
	  d.findElement(By.id("billing:street1")).sendKeys("R.S.Puram");
	  d.findElement(By.id("billing:city")).sendKeys("COIMBATORE");
	// select class 
	  
	  
	  
	  d.findElement(By.id("billing:postcode")).sendKeys("641002");
	  Thread.sleep(500);
	// select class 
	
	  Select s2=new Select( d.findElement(By.id("billing:region_id")));
	  s2.selectByIndex(5);
	  Thread.sleep(500);
	  
	  d.findElement(By.id("billing:telephone")).sendKeys("0422473426");
	 
	  d.findElement(By.xpath("//button[@onclick='billing.save()']//following::span[text()='Continue']")).click();
	  Thread.sleep(2000);
	  
  }
  
  
  @AfterTest
  public void Teardown() {
	 d.close(); 
	
}
}