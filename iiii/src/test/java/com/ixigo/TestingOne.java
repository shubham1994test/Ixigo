package com.ixigo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TestingOne {
	
	

WebDriver driver;
	
	@Test()
	public void TopFlight() throws InterruptedException {
	
		
		
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path+"\\cch.exe");
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.ixigo.com/");
		driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left'] //input[@placeholder='Enter city or airport']")).click();
		driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left'] //input[@class='c-input u-v-align-middle']")).sendKeys("DEL");
		driver.findElement(By.xpath("(//div[text()='Indira Gandhi International Airport'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='dstn u-ib u-v-align-bottom u-text-left'] //input[@class='c-input u-v-align-middle']")).sendKeys("BLR");
    WebDriverWait wait= new WebDriverWait(driver, 50);



    
    
    
  // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));

    
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Kempegowda International Airport']")));
    Thread.sleep(10000);
      //  wait.until(ru.stqa.selenium.wait.ExpectedCondition<T>)
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Kempegowda International Airport']")));
		driver.findElement(By.xpath("//div[text()='Kempegowda International Airport']")).click();
    CalenderResults a = new CalenderResults();
		a.demo(driver,30,true);
		driver.findElement(By.xpath("//div[@class='close-btn u-pos-abs ixi-icon-cross']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
		a.demo(driver,40,true);
		driver.findElement(By.xpath("//div[@class='search u-ib u-v-align-bottom']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fltrs-buttons max-container-width']")));
		Thread.sleep(10000);
		List<WebElement> going = driver.findElements(By.xpath("//div[@class='result-col outr'] //div[@class=\"u-text-ellipsis\"]"));
		List<WebElement> returning = driver.findElements(By.xpath("//div[@class='result-col outr'] //div[@class=\"u-text-ellipsis\"]"));
		List<WebElement> takeoff = driver.findElements(By.xpath("//div[@class='result-col outr'] //div[@class=\"time\"][1]"));
		List<WebElement> landing = driver.findElements(By.xpath("//div[@class='result-col outr'] //div[@class=\"time\"][2]"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='result-col outr'] //div[@class=\"c-price-display u-text-ellipsis \"][1]"));
		
		List<WebElement> goingl = driver.findElements(By.xpath("//div[@class='result-col'] //div[@class=\"u-text-ellipsis\"]"));
		List<WebElement> returningl = driver.findElements(By.xpath("//div[@class='result-col'] //div[@class=\"u-text-ellipsis\"]"));
		List<WebElement> takeoffl = driver.findElements(By.xpath("//div[@class='result-col'] //div[@class=\"time\"][1]"));
		List<WebElement> landingl = driver.findElements(By.xpath("//div[@class='result-col'] //div[@class=\"time\"][2]"));
		List<WebElement> pricel = driver.findElements(By.xpath("//div[@class='result-col'] //div[@class=\"c-price-display u-text-ellipsis \"][1]"));
		for(int i= 0;i<20;i++)
		{
			System.out.println(i+1+" ==> "+going.get(i).getText()+" "+returning.get(i).getText()+" "+takeoff.get(i).getText()+" "+landing.get(i).getText()+" "+price.get(i).getText());
		}
		
		System.out.println("================================================");
		
		
		for(int i= 0;i<20;i++)
		{
			System.out.println(i+1+"  ==> "+goingl.get(i).getText()+" "+returningl.get(i).getText()+" "+takeoffl.get(i).getText()+" "+landingl.get(i).getText()+" "+pricel.get(i).getText());

		}
		


		
	}

}
