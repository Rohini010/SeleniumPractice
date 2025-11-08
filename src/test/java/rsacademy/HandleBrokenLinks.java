package rsacademy;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement footerElement=driver.findElement(By.cssSelector("table.gf-t"));
		int statuscode;
		List<WebElement> links=footerElement.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement i:links) {
			String urlString=i.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection) new URL(urlString).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
 statuscode=		conn.getResponseCode();
 if(statuscode>400) {
		System.out.println(i.getText()+" is broken with code "+statuscode);
		Assert.assertTrue(false);
	}
		}
		
		
		
		
		driver.quit();

	}

}
