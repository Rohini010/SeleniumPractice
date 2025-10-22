package locators;

import java.lang.invoke.StringConcatFactory;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorBasics2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\silim\\OneDrive\\Documents\\SeleniumDriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password =getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		
		driver.findElement(By.id("inputUsername")).sendKeys("rohini");
		driver.findElement(By.cssSelector(".sign-in-container form input:nth-child(3)")).sendKeys(password);
		driver.findElement(By.cssSelector(".sign-in-container button")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div/h2")).getText());
		System.out.println(driver.findElement(By.cssSelector(".login-container p")).getText());
		driver.findElement(By.xpath("//div/button")).click();
		driver.quit();

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String passwordTextString=driver.findElement(By.xpath("//form/p")).getText();
		String[] passwordArray= passwordTextString.split("'");
		String actualPassword=passwordArray[1].split("'")[0];
		return actualPassword;
		
	}

}
