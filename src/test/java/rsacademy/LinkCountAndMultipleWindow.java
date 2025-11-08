package rsacademy;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LinkCountAndMultipleWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Link available on page: "+driver.findElements(By.tagName("a")).size());
		WebElement footerdriver=driver.findElement(By.cssSelector("div.footer_style"));
		System.out.println("footer section link: "+ footerdriver.findElements(By.tagName("a")).size());
		WebElement columndriver=footerdriver.findElement(By.cssSelector("div#gf-BIG tbody td:nth-child(1)"));
		System.out.println("first column links: "+columndriver.findElements(By.tagName("a")).size());
		int colLinks=columndriver.findElements(By.tagName("a")).size();
		String clickLinkNewTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		
		for(int i=1;i<colLinks;i++) {
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkNewTab);
			Thread.sleep(2000);
		}
		

		
		 Set<String> windows = driver.getWindowHandles();
	        Iterator<String> it = windows.iterator();

	        while (it.hasNext()) {
	            driver.switchTo().window(it.next());
	            System.out.println("Title: " + driver.getTitle());
	        }

//		driver.close();

	}
	

}
