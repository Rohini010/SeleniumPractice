package uiAutomationpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		;

		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000); 
		System.out.println("handling autosuggestive dropdown");
		driver.findElement(By.cssSelector("span.commonModal__close")).click();
		driver.findElement(By.cssSelector("#fromCity")).click();
		driver.findElement(By.cssSelector("input[placeholder='From']")).sendKeys("mumbai");
		Thread.sleep(1000);
		List<WebElement> fromCityList = driver.findElements(By.cssSelector("ul[role='listbox'] li"));
		Thread.sleep(1000); // wait for list to load
		for (WebElement i : fromCityList) {
			if (i.getText().toLowerCase().contains("mumbai")) {
				i.click();
				break;
			}
		}
		
		Thread.sleep(2000); 
		driver.findElement(By.cssSelector("#toCity")).click();
		Thread.sleep(2000); 
		driver.findElement(By.cssSelector("input[placeholder='To']"	)).sendKeys("New Delhi");
		Thread.sleep(2000); 

		List<WebElement> toCityList = driver.findElements(By.cssSelector("div.searchToCity ul[role='listbox'] li"));
		Thread.sleep(2000); 
		for (WebElement toCity : toCityList) {
			if (toCity.getText().toLowerCase().contains("new delhi")) {
				toCity.click();
				break;
			}
		}
		Thread.sleep(2000); 
		
		driver.findElement(By.cssSelector("div.DayPicker-Day--today")).click();
//		driver.findElement(By.cssSelector("li[data-cy='roundTrip'] span")).click();
//		Assert.assertFalse(driver.findElement(By.cssSelector("div[data-cy='returnArea'] .greyText")).isEnabled());
		driver.findElement(By.cssSelector("li[data-cy='roundTrip'] span")).click();
		Thread.sleep(2000);

		String returnClass = driver.findElement(By.cssSelector("div[data-cy='returnArea'] p"))
		                           .getDomAttribute("class");

		if (returnClass.contains("greyText")) {
		    System.out.println("Return date not enabled (One Way mode).");
		    Assert.fail("Return date should be enabled for Round Trip but found disabled.");
		} else {
		    System.out.println("Return date enabled (Round Trip mode).");
		    Assert.assertTrue(true, "Return date is enabled in Round Trip mode");
		}

		
//		
//		Thread.sleep(2000);
//		if(driver.findElement(By.cssSelector("div[data-cy='returnArea'] p")).getDomAttribute("class").contains("greyText")){
//			System.out.println("not enabled");
//			Assert.assertFalse(false);
//		}
		
		
		
		
		

		
		
//		Assert.assertFalse(driver.findElement(By.cssSelector(".specialFareContainer div.makeFlex div:nth-child(3) input[type='radio']")).isSelected());
//		driver.findElement(By.cssSelector(".specialFareContainer div.makeFlex div:nth-child(3)")).click();
//		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.cssSelector(".specialFareContainer div.makeFlex div:nth-child(3) input[type='radio']")).isSelected());
//		Assert.assertTrue(driver.findElement(By.cssSelector(".specialFareContainer div.makeFlex div:nth-child(3) input[type='radio']")).isSelected());
		
	
	}

}
