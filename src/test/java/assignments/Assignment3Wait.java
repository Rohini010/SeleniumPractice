package assignments;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3Wait {
	
	
	public static void login(WebDriver driver,WebDriverWait wait) {
		driver.findElement(By.xpath("//label[@for='username']/following-sibling::input")).sendKeys("rahulshettyacademy");//xpath: sibling traversal 
		driver.findElement(By.cssSelector("label[for='password']~input")).sendKeys("learning"); //css selector: sibling traversal
		System.out.println("Selected value by default: "+driver.findElement(By.cssSelector("input[value='admin']")).isSelected());
		System.out.println("Non-Selected value by default: "+driver.findElement(By.cssSelector("input[value='user']")).isSelected());
		Select select=new Select(driver.findElement(By.cssSelector("select.form-control")));
		select.selectByValue("consult");
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title a")));

	}
	public static void addItem(WebDriver driver, String[] phoneName)
	{
		System.out.println("adding element");
		driver.findElement(By.cssSelector("button.btn-info")).click();
		
		List<WebElement> phoneList=driver.findElements(By.cssSelector(".card-title a"));
		int counter=0;
		List phone=Arrays.asList(phoneName);
		
		for(int i=0;i<phoneList.size();i++) {
			String name=phoneList.get(i).getText().split(" ")[0].trim();
		
			if(phone.contains(name)) {
				driver.findElements(By.cssSelector(".card-footer .btn")).get(i).click();
				System.out.println("Product added: "+name);
				counter++;
			}
			if(counter==phoneName.length) {
				System.out.println("All product added,exiting....");
				break;
			}
		}
	}
	public  static void checkoutSuccess(WebDriver driver,WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".active a.nav-link")));
		driver.findElement(By.cssSelector(".active a.nav-link")).click();
		driver.findElement(By.cssSelector("button.btn-success")).click();
		driver.findElement(By.cssSelector("input.filter-input")).sendKeys("ind");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.suggestions ul li a")));
		List<WebElement> countryList=driver.findElements(By.cssSelector("div.suggestions ul li a"));
		for(WebElement i:countryList) {
			String countryName=i.getText();
			System.out.println(countryName);
			if(countryName.equalsIgnoreCase("India")) {
				driver.findElement(By.cssSelector("div.suggestions ul li a")).click();
				break;
			}
		}
		driver.findElement(By.cssSelector("label[for='checkbox2']")).click();
		driver.findElement(By.cssSelector("input[value='Purchase']")).click();
		System.out.println(driver.findElement(By.cssSelector("div.alert-success")).getText());
		
	}

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
		    put("credentials_enable_service", false);
		    put("profile.password_manager_enabled", false);
		}});
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		

		String[] phoneName = {"iphone","Nokia","Blackberry"};
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
				
		login(driver, wait);
		addItem(driver, phoneName);
		checkoutSuccess(driver, wait);
		
		driver.close();
		
		

	}

}
