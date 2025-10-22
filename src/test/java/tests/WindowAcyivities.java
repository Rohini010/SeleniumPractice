package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowAcyivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\silim\\OneDrive\\Documents\\SeleniumDriver");
		driver.manage().window().maximize();
		;
		System.out.println("Navigation started");

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().back();
		driver.navigate().forward();
		System.out.println("Navigation successful");
		driver.quit();

	}

}
