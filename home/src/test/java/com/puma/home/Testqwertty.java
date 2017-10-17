package com.puma.home;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;;


public class Testqwertty{
	
	
	
	@Test
	public void test() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Indium2\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.puma.com/");
		
		
		WebElement MenMenu = driver.findElement(By.linkText("MEN"));
	    Actions action = new Actions(driver);
	    action.moveToElement(MenMenu).build().perform(); 
	    
	    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	    
	    WebElement shoeRunning = driver.findElement(By.xpath("(//li[@id='men-subnav']//a[text()='Running'])[1]"));  
	    JavascriptExecutor executor = (JavascriptExecutor) driver; 
	    executor.executeScript("arguments[0].click();", shoeRunning);
	    
	    
	    String itemName=driver.findElement(By.xpath("(//li[@class='item last'])[2]//h2[@class='product-name']/a")).getText();
	    System.out.println("Product Second" +itemName);
	  
	    driver.findElement(By.xpath("(//li[@class='item last'])[2]//h2[@class='product-name']/a")).click();  
	    driver.findElement(By.xpath("//*[@id='size_label']/div[1]/div[2]")).click();
	    driver.findElement(By.xpath("//*[@id='select_label_size']")).click();
	    driver.findElement(By.xpath("//*[@id='180~73']")).click();
	    
	    
	    WebElement cartbutton = driver.findElement(By.xpath("//*[@class='button btn-cart']"));  
	    JavascriptExecutor executor1 = (JavascriptExecutor) driver; 
	    executor1.executeScript("arguments[0].click();", cartbutton);
	    	    
	    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	    
	    String itemCart=driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[2]/h2/a")).getText();
	    System.out.println("Product Second" +itemCart);
	    
	    
	    assertTrue(itemName.contains(itemCart));
	    
	  		
	}
	
}