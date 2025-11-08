package practice;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import org.openqa.selenium.By;



public class CookieManagement {

	public static void main(String[] args) throws InterruptedException {
		  WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        // Go to demo site (you can replace this with any site that sets cookies)
	        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	        
	        // Simulate login
	        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
	        driver.findElement(By.id("password")).sendKeys("learning");
	        driver.findElement(By.id("signInBtn")).click();
	        
	        Thread.sleep(3000); // wait for login to complete
	        
	        // 🧠 Fetch all cookies from browser
	        Set<Cookie> cookies = driver.manage().getCookies();
	        System.out.println("=== Browser Cookies ===");
	        for (Cookie ck : cookies) {
	            System.out.println(ck);
	            System.out.println("-----------------------");
	        }

	        // 🧩 Get session cookie (if present)
	        Cookie sessionCookie = driver.manage().getCookieNamed("JSESSIONID");
	        if (sessionCookie != null) {
	            System.out.println("Session ID from cookie: " + sessionCookie.getValue());
	        } else {
	            System.out.println("No JSESSIONID found — site might use another cookie or token.");
	        }

	        // 🧪 Add a custom cookie
	        Cookie myCookie = new Cookie("TestCookie", "Rohini-Automation");
	        driver.manage().addCookie(myCookie);
	        System.out.println("Custom cookie added!");

	        // Verify it was added
	        Cookie fetched = driver.manage().getCookieNamed("TestCookie");
	        System.out.println("Custom cookie value: " + fetched.getValue());

	        // 🧹 Delete a specific cookie
	        driver.manage().deleteCookieNamed("TestCookie");
	        System.out.println("Custom cookie deleted.");

	        // 🧹 Delete all cookies (end of session)
	        driver.manage().deleteAllCookies();
	        System.out.println("All cookies deleted.");

	        driver.quit();

	}

}
