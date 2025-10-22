package revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HeroInternet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("div ul li:nth-child(11)>a")).click();
		 Select select=new Select(driver.findElement(By.cssSelector("#dropdown")));
		 select.selectByValue("2");
		 driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
		int checkboxSize=	 driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(checkboxSize);
		System.out.println(driver.findElement(By.cssSelector("form#checkboxes :nth-child(3)")).isSelected());
		driver.findElement(By.cssSelector("form#checkboxes :nth-child(3)")).click();
		System.out.println("checkbox 2 selected "+driver.findElement(By.cssSelector("form#checkboxes :nth-child(3)")).isSelected());
		driver.findElement(By.cssSelector("form#checkboxes :nth-child(1)")).click();
		System.out.println("checking checkbox 1: " + driver.findElement(By.cssSelector("form#checkboxes :nth-child(1)")).isSelected());

		
		driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
		for(int i=0;i<5;i++)
		{
			driver.findElement(By.cssSelector("button[onclick*='addElement']")).click();
			}
		
		int deleteCount=driver.findElements(By.cssSelector("div#elements .added-manually")).size();
		System.out.println("delete btn count pressed: "+deleteCount);
		System.out.println("deleting  three btn");
		for(int i=0;i<3;i++)
		{
			driver.findElement(By.cssSelector("div#elements .added-manually")).click();
			}
		int updatedCount=driver.findElements(By.cssSelector("div#elements .added-manually")).size();
		System.out.println("after removing, delete btn count: "+updatedCount);
		}

}
