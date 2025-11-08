package rsacademy;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandleConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set<String> window=driver.getWindowHandles();
		Iterator<String> iterator=window.iterator();
		String parentID= iterator.next();
		String childID=iterator.next();
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector("div p.im-para.red")).getText());
		String grabText=driver.findElement(By.cssSelector("div p.im-para.red")).getText().split("@")[1].trim().split("\\.")[0];
		
		System.out.println("Username: "+grabText);
		driver.switchTo().window(parentID);
		
		
		driver.findElement(By.xpath("//label[@for='username']/following-sibling::input")).sendKeys(grabText);//xpath: sibling traversal 
		driver.findElement(By.cssSelector("label[for='password']~input")).sendKeys("learning"); //css selector: sibling traversal
		System.out.println("Selected value by default: "+driver.findElement(By.cssSelector("input[value='admin']")).isSelected());
		System.out.println("Non-Selected value by default: "+driver.findElement(By.cssSelector("input[value='user']")).isSelected());
		Select select=new Select(driver.findElement(By.cssSelector("select.form-control")));
		select.selectByValue("consult");
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title a")));

	}

}
