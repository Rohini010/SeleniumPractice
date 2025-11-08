package rsacademy;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExample {

	public static void addItems(WebDriver driver, String[] productName) {
		List<WebElement> products = driver.findElements(By.cssSelector("div h4.product-name"));
		int j = 0;
		List<String> productList = Arrays.asList(productName);
		for (int i = 0; i < products.size(); i++) {

			String name = products.get(i).getText();
			String prNAme = name.split(" ")[0].trim();

			System.out.println("product name " + name);
			System.out.println("trimmed product :" + prNAme);
			if (productList.contains(prNAme)) {
				driver.findElements(By.cssSelector(".product-action button")).get(i).click();
				j++;
				if (j == productName.length) {
					System.out.println("exiting...");
					break;
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] productName = { "Brocolli", "Carrot", "Tomato", "Beans" };
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  -- IMplicit wait
		//Explicit wait
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(8));
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		addItems(driver, productName);
		driver.findElement(By.cssSelector("a.cart-icon")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		
		
	}

}
