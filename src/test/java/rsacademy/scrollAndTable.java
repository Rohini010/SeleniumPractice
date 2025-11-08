package rsacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrollAndTable {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> scoreList  =  driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4"));
		int sum=0;
		for(int i=0;i<scoreList.size();i++) {
			int total=  Integer.parseInt(scoreList.get(i).getText());
			sum=sum+total;
		}
		System.out.println(sum);
int actualSum= Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
Assert.assertEquals(sum,actualSum);


System.out.println("validating product price");

List<WebElement> productList  =  driver.findElements(By.cssSelector("table[name='courses'] td:nth-child(3)"));
int priceTotal=0;
for(int i=0;i<productList.size();i++) {
	int actualPrice=Integer.parseInt(productList.get(i).getText());
	priceTotal=priceTotal+actualPrice;
}
System.out.println(priceTotal);

//System.out.println(actualSum);

	}

}
