package com.Demo_EComm;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.reporters.Files;

public class Mobile_my_idea {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver-99\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.get("https://live.techpanda.org/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String exp_Title="Home page";
		String actual_title= d.getTitle();
		System.out.println(actual_title);
		if(actual_title.equals(exp_Title))
				{
			System.out.println("Title verified");
				}
		else
			System.out.println("Title verification failed");
		Thread.sleep(3000);

		d.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		
		String exp_Title1="Mobile";
		String actual_title1= d.getTitle();
		System.out.println(actual_title1);
		if(actual_title1.equals(exp_Title1))
				{
			System.out.println("Mobile page verified");
				}
		else
			System.out.println("Mobile page verification failed");
		
		new Select(d.findElement(By.xpath("//select[@title='Sort By']"))).selectByIndex(1);
		Thread.sleep(3000);
		
	
		
	}

}
