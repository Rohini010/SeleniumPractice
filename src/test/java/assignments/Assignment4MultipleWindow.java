package assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4MultipleWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href*='windows']")).click();
		driver.findElement(By.cssSelector("a[href*='windows/new']")).click();
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> iterator=windows.iterator();
		String parentID=iterator.next();
		String childID=iterator.next();
		
		
		driver.switchTo().window(childID);
		System.out.println("printing child window text: " + driver.findElement(By.cssSelector("div h3")).getText());
		driver.switchTo().window(parentID);
		System.out.println("printing parent window text: "+driver.findElement(By.cssSelector("div h3")).getText());
		driver.quit();
	}

}
