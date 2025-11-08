package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7WebTables {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> rowList=  driver.findElements(By.cssSelector("table[name='courses'] tr"));
		System.out.println("Row counts "+rowList.size());
		
	
		List<WebElement> colList= driver.findElements(By.cssSelector("table[name='courses'] tr th"));
		System.out.println("Column counts "+colList.size());
		
		List<WebElement> rowDataList = driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(3) td"));
		for(int i=0;i<rowDataList.size();i++) {
			System.out.println(rowDataList.get(i).getText());
		}
//		
	}

}
