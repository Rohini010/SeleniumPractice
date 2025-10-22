package assignments;

import java.util.*;

import javax.accessibility.AccessibleStateSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		WebElement checkbox1=driver.findElement(By.cssSelector("fieldset input[value='option1']"));
		System.out.println("Checking");
		checkbox1.click();
		Assert.assertTrue(checkbox1.isSelected());
		System.out.println("Unchecking");
		checkbox1.click();
		Assert.assertFalse(checkbox1.isSelected());
		
		
		List<WebElement> checkbox_list=    driver.findElements(By.cssSelector("fieldset input[type='checkbox']"));
	

		int  checkbox_count= checkbox_list.size();
		System.out.println("checkbox coount: "+checkbox_count);

	}

}
