package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment8AutoDropdown {
	public static void main(String[] args) throws InterruptedException {
		String expectedCountry = "India";
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions actions = new Actions(driver);

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("ind");
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath(("//div[@class='ui-menu-item-wrapper']"))));

		List<WebElement> countryList = driver.findElements(By.cssSelector(".ui-menu-item div"));
		for (WebElement i : countryList) {
			String actualCountry = i.getText();
			System.out.println("Found countries: " + actualCountry);
			if (actualCountry.equalsIgnoreCase(expectedCountry)) {
				actions.moveToElement(i).click().build().perform();
				System.out.println(expectedCountry + " found in dropdown");
				break;

			}
		}
		Assert.assertEquals(driver.findElement(By.cssSelector("input#autocomplete")).getAttribute("value"),
				expectedCountry);
	}

}
