package locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorBasics {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\silim\\OneDrive\\Documents\\SeleniumDriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		System.out.println(driver.getTitle());
		driver.findElement(By.id("inputUsername")).sendKeys("rohini");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rohini@gmail.com");
		driver.findElement(By.cssSelector(".signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector(".error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3);
		
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("input[placeholder='Name']");
		System.out.println("diff ways of find same element");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abc@dd");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rohini@gmail.com");
		driver.findElement(By.cssSelector(".sign-up-container form input:nth-child(4)")).sendKeys("9088762617");
		driver.findElement(By.xpath("//div/button[2]")).click();
		System.out.println(driver.findElement(By.xpath("//form/p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(10);
		
		driver.findElement(By.id("inputUsername")).sendKeys("rohini");
		driver.findElement(By.cssSelector(".sign-in-container form input:nth-child(4)")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".sign-in-container button")).click();
		System.out.println(driver.findElement(By.xpath("//div/h2")).getText());
		System.out.println(driver.findElement(By.cssSelector(".login-container p")).getText());
		driver.findElement(By.xpath("//div/button")).click();
		driver.quit();
		

	}

}
