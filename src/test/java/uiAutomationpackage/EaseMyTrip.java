package uiAutomationpackage;

import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class EaseMyTrip {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.easemytrip.com/");

		driver.findElement(By.xpath("//input[@id='FromSector_show']")).click();
		driver.findElement(By.cssSelector("#a_FromSector_show")).sendKeys("del");
		Thread.sleep(2000);
		List<WebElement> inputCity = driver.findElements(By.cssSelector("#fromautoFill ul.ausuggest li"));
		for (WebElement i : inputCity) {
			System.out.println("From City: " + i.getText());
			if (i.getText().contains("Delhi")) {
				i.click();
				break;
			}
		}
		System.out.println("-------------------------");
		driver.findElement(By.cssSelector("#a_Editbox13_show")).sendKeys("ben");
		Thread.sleep(2000);
		List<WebElement> toCitys = driver.findElements(By.cssSelector("#toautoFill .ausuggest li"));
		for (WebElement j : toCitys) {
			System.out.println("To Citys: " + j.getText());
			if (j.getText().contains("Bengaluru")) {
				j.click();
				break;
			}
		}

		List<WebElement> fromDate = driver
				.findElements(By.cssSelector(".main .days ul li[style='visibility:show']:not(.old-dt)"));
		for (WebElement i : fromDate) {
			if (i.getText().contains("29")) {
				i.click();
				break;

			}
		}
		Thread.sleep(3000);
		
		
		
		WebElement returnDatElement=driver.findElement(By.id("divRtnCal"));
		System.out.println("Problem with isdisplayed() methodL- one way: "+ returnDatElement.isDisplayed());
		driver.findElement(By.id("rtrip")).click();
		Thread.sleep(2000);
		
	
		System.out.println(driver.findElement(By.cssSelector("#rdatelbl")).getDomAttribute("style"));
		if(driver.findElement(By.id("rdatelbl")).getDomAttribute("style").contains("1")){
			System.out.println("return date is enabled");
			Assert.assertTrue(true);
		}
		else {
			assertFalse(true);
		}
		
		
		returnDatElement.click();
		Thread.sleep(3000);
		System.out.println("after clicking on round trip: "+returnDatElement.isDisplayed());
		Thread.sleep(3000);
		
		
		
		List<WebElement> selectreturnDate =driver.findElements(By.cssSelector("#dvcalendar .main1 div ul li"));
		for(WebElement date:selectreturnDate) {
			if(date.getText().contains("19")) {
				date.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#ptravlrNo")).click();
		WebElement plusAdult = driver.findElement(By.cssSelector("#optAdult + button"));
		for (int i = 1; i < 4; i++) {
		    plusAdult.click();
		}
		
		WebElement plusChild=driver.findElement(By.cssSelector("#optChild+button"));
		for (int i = 0; i < 3; i++) {
		    plusChild.click();
		}
		driver.findElement(By.cssSelector("#rbFirst")).click();
		driver.findElement(By.cssSelector("#traveLer")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("chkStudent")).click();
		driver.findElement(By.cssSelector("input.srchBtnSe")).click();
	
	}

}
