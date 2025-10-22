package assignments;

import java.lang.invoke.StringConcatFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("rohini");
		driver.findElement(By.name("email")).sendKeys("rohini@example.com");
		
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("password");
		
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		Select select=new Select(driver.findElement(By.cssSelector("#exampleFormControlSelect1")));
		select.selectByVisibleText("Female");
		driver.findElement(By.cssSelector("#inlineRadio1")).click();
		WebElement dateField = driver.findElement(By.name("bday"));

        // Set the desired date (YYYY-MM-DD format)
        String desiredDate = "10-08-2000";
        dateField.sendKeys(desiredDate);

        // Optional: retrieve what was entered to verify
        String enteredDate = dateField.getAttribute("value");
        System.out.println("Date entered: " + enteredDate);
        
        driver.findElement(By.cssSelector("input.btn-success")).click();
         String success  =driver.findElement(By.cssSelector("div.alert-success")).getText();
     
         System.out.print(success);
         
		
	}

}
