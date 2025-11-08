package rsacademy;

import static org.testng.Assert.fail;

import java.awt.Desktop.Action;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CalendarsPrac {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub   
		String monthNumber="6";
		String year="2028";
		String day="10";
		
		String expectedArray[]= {monthNumber,day,year};
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
//		Actions a=new Actions(driver);
//		a.moveToElement(driver.findElement(By.cssSelector(".react-calendar__navigation__label"))).doubleClick().build().perform();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		Thread.sleep(2000);
//		List<WebElement> yearList=  driver.findElements(By.cssSelector(".react-calendar__decade-view__years__year"));
//		System.out.println(yearList.size());
//		for(int i=0;i<=yearList.size();i++) {
//			String yr=driver.findElements(By.cssSelector(".react-calendar__decade-view__years__year")).get(i).getText().trim();
//			
//			if(yr.equals(year)) {
//				driver.findElements(By.cssSelector(".react-calendar__decade-view__years__year")).get(i).click();
//		break;
//			}
//		
//		}
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
	
		List<WebElement> actualDataList  =driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));
		for(int i=0;i<actualDataList.size();i++) {
			System.out.println(actualDataList.get(i).getAttribute("value"));
			Assert.assertEquals(actualDataList.get(i).getAttribute("value"), expectedArray[i]);
		}
		
		
//		List<WebElement> monthList=  driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"));
//		System.out.println(monthList.size());
//		for(int i=0;i<=monthList.size();i++) {
//			String mth=driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(i).getText().trim();
//			
//			if(mth.equals(monthNumber)) {
//				driver.findElements(By.cssSelector(".react-calendar__decade-view__years__year")).get(i).click();
//		break;
//			}
//		
//		}
		
		
	}

}
