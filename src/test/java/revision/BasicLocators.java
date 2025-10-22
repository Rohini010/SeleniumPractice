package revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocators {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("silimkar@apna.com");
		driver.findElement(By.name("inputPassword")).sendKeys("password");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.name("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("rohini");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("aabbcd@aa.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9082654178");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText=  driver.findElement(By.className("infoMsg")).getText();
		System.out.println(passwordText);
		
		String passString=passwordText.split("'")[1];
		
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("silimkar@apna.com");
		driver.findElement(By.name("inputPassword")).sendKeys(passString);
		
		
		
	}

}
