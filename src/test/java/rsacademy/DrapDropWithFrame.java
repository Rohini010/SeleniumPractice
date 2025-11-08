package rsacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DrapDropWithFrame {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement sourceElement=driver.findElement(By.cssSelector("#draggable"));
		WebElement targetElement=driver.findElement(By.cssSelector("#droppable"));
		Actions actions=new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='API Documentation']")).click();
	}

}
