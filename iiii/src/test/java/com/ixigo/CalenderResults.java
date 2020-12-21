package com.ixigo;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CalenderResults 
{
	List<WebElement> dates;
	boolean flag=true;
	int a, b;

	public  String calculateDate(int days)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		String str = calendar.getTime().toString();
		
		return str;
	}
	public  void dateClick(List<WebElement> dates, String date)
	{
		
		for (int i = 0; i < dates.size(); i++) 
		{
			if (dates.get(i).getText().contains(date)) 
			{
				dates.get(i).click();
				break;
			}
		}
		
	}
	public void demo(WebDriver driver, int days, boolean flag) {
		String val=calculateDate(days);
		String month = val.substring(4, 7);
		String date = val.substring(8, 10);
		if (date.substring(0, 1).equals("0")) 
		{
			date = date.substring(1, 2);
		}
		if(days==30)
		{
			a=1;
			b=2;
		}
		else
		{
			a=3;
		   b=4;
		}
		WebElement firstmonth = driver.findElement(By.xpath("(//div[@class='rd-month-label'])["+a+"]"));
		WebElement secondmonth = driver.findElement(By.xpath("(//div[@class='rd-month-label'])["+b+"]"));
		
		while (flag) {
			if (firstmonth.getText().contains(month)) 
			{
				dates = driver.findElements(By.xpath("(//table[@class='rd-days'])["+a+"]//td[@class='rd-day-body start-of-month' or @class='rd-day-body' or @class='rd-day-body end-of-month']"));
				dateClick(dates,date);
				flag=false;
			} 
			else if (secondmonth.getText().contains(month)) 
			{
				dates = driver.findElements(By.xpath("(//table[@class='rd-days'])["+b+"]//td[@class='rd-day-body start-of-month' or @class='rd-day-body' or @class='rd-day-body end-of-month']"));
				dateClick(dates,date);
				flag=false;
			}
		
			else 
			{
				driver.findElement(By.xpath("//button[@class='ixi-icon-arrow rd-next']")).click();
				flag=true;
			}
		}
	}
}