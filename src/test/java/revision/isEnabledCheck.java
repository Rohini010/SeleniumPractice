package revision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class isEnabledCheck {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.easemytrip.com/");
        Thread.sleep(3000);

        WebElement returnDate = driver.findElement(By.id("rdate"));

        // Get initial DOM and live attributes
        String styleDomBefore = returnDate.getDomAttribute("style");
        String styleAttrBefore = returnDate.getAttribute("style");

        System.out.println("DOM (before): " + styleDomBefore);
        System.out.println("LIVE (before): " + styleAttrBefore);

        if (styleDomBefore.contains("opacity: 0")) {
            System.out.println("🚫 Return date is hidden/disabled (One Way).");
        }

        // Click "Round Trip"
        WebElement roundTrip = driver.findElement(By.id("rtrip"));
        roundTrip.click();
        Thread.sleep(2000);

        // Re-fetch element and get updated attributes
        returnDate = driver.findElement(By.id("rdate")); // re-locate after DOM update

        String styleDomAfter = returnDate.getDomAttribute("style");
        String styleAttrAfter = returnDate.getAttribute("style");

        System.out.println("DOM (after): " + styleDomAfter);
        System.out.println("LIVE (after): " + styleAttrAfter);

        if (!styleAttrAfter.contains("opacity: 0")) {
            System.out.println("✅ Return date is now visible/enabled after selecting Round Trip.");
        } else {
            System.out.println("❌ Return date still hidden.");
        }


	}

}
