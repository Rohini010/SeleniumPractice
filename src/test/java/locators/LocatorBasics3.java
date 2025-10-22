package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorBasics3 {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\silim\\OneDrive\\Documents\\SeleniumDriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println("Sibling Traversal using xpath");
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		System.out.println(driver.findElement(By.xpath(null)));
		
		
	}

}
