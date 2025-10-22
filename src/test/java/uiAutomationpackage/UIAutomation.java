package uiAutomationpackage;

import java.util.List;
import java.nio.channels.SelectableChannel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.implementation.bytecode.Division;

public class UIAutomation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\silim\\OneDrive\\Documents\\SeleniumDriver");
		driver.manage().window().maximize();;		

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println("Static dropdown");
		Select select=new Select(driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency")));
		select.selectByIndex(2);
		System.out.println(select.getFirstSelectedOption().getText());
		select.selectByVisibleText("USD");
		System.out.println(select.getFirstSelectedOption().getText());
		select.selectByValue("INR");
		System.out.println(select.getFirstSelectedOption().getText());
		
		
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=0;i<2;i++) {
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		}
		System.out.println(driver.findElement(By.cssSelector("#divpaxinfo")).getText());
		
		
		
		
		System.out.println("Dynamic Dropdown");
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='BOM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
	
		
		System.out.println("Autosuggestive dropdown");
		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
		List<WebElement> options=driver.findElements(By.cssSelector("ul[class*='ui-autocomplete'] li a"));
		for(WebElement i: options) {
			if(i.getText().equalsIgnoreCase("india")){
				i.click();
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
