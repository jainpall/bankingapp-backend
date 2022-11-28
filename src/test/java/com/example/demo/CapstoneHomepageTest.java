//package com.example.demo;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class CapstoneHomepageTest {
//	public static WebDriver driver;
//	@Test
//	public void navigateToHomepage() {
//		System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
//		driver=new ChromeDriver();
//		driver.get("http://localhost:3000/");
//		String expectedUrl ="http://localhost:3000/";
//		String actualUrl = driver.getCurrentUrl();
//		System.out.println(actualUrl);
//		Assert.assertEquals(expectedUrl, actualUrl, "Test This URL");
//		
//		
//	}
//	
//	@Test
//	public void loginTest() {
//		
//		System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
//		driver=new ChromeDriver();
//		driver.get("http://localhost:3000/login");
//		driver.findElement(By.xpath("//form/div[1]/div/input")).sendKeys("vignesh@gmail.com");
//		driver.findElement(By.xpath("//form/div[2]/div/input")).sendKeys("Vignesh@1");
//		WebElement loginbutton = driver.findElement(By.xpath("//form/button"));
//		loginbutton.click();
//		String expectedUrl ="http://localhost:3000/dashboards";
//		String actualUrl = driver.getCurrentUrl();
//		System.out.println(actualUrl);
//		Assert.assertEquals(expectedUrl, actualUrl, "Test This DashboardsURL");
//	}
//		
//	
//}


