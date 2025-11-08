package rsacademy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue shopping']")));
			continueBtn.click();
			System.out.println("Handled Continue Shopping");
		} catch (Exception e) {
			System.out.println("Continue shopping screen not shown, proceeding normally.");
		      
		}
		
		
		
		 File fullSS = new File("C:\\RohiniUDemy\\SeleniumPractice\\src\\test\\screenshots\\fullSS.png");

		 if (fullSS.exists() && fullSS.delete()) {
	            System.out.println("Old full screenshot deleted.");
	        }
		

		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile,fullSS);
		if (fullSS.exists()) {
            System.out.println("Screenshot successfully saved at: " + fullSS.getAbsolutePath());
        } else {
            System.out.println("Screenshot not found! Something went wrong.");
        }
//		Thread.sleep(2000);
		
		 WebElement testElement=driver.findElement(By.cssSelector("img[alt*='Cushion covers']")); 
		 File partialSS=new File("C:\\RohiniUDemy\\SeleniumPractice\\src\\test\\screenshots\\partialSS.png");
		 if (partialSS.exists() && partialSS.delete()) {
	            System.out.println("Old partialSS screenshot deleted.");
	        }
		
		 File partialsrcFile=testElement.getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(partialsrcFile, partialSS);
		if(partialSS.exists()) {
			System.out.println("Partial screenshot saved at: "+partialSS.getAbsolutePath());
		}
		
		
		
	}

}
