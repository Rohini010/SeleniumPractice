package practice;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPrac {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("fieldset input[type='checkbox']")).click();
		 Select select=new Select(driver.findElement(By.cssSelector(".cen-right-align select"))) ;	 
		 select.selectByValue("option1");
		 Thread.sleep(2000);
		 select.selectByValue("option3");
		System.out.println(select.getFirstSelectedOption().getText());
		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
//		List<WebElement> listElement= );
		 List<WebElement> listEList=   driver.findElements(By.cssSelector("#ui-id-1 li"));
		 
		 for(WebElement countryName:listEList) {
			if( countryName.getText().toLowerCase().equals("india")){
				countryName.click();
			 }
				 
			 
		 }
		

	}

}
