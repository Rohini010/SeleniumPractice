package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("label[for='honda'] input")).click();

		String checkboxSelected = driver.findElement(By.cssSelector("label[for='honda']")).getText();
		System.out.println(checkboxSelected);
		Select select = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
		select.selectByVisibleText(checkboxSelected);

		driver.findElement(By.name("enter-name")).sendKeys(checkboxSelected);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertText);
		if (alertText.contains(checkboxSelected)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		driver.quit();
	}

}
