package rsacademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] productName= {"Brocolli","Carrot","Tomato","Beans"};
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/seleniumPractise");
//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
List<WebElement> products=driver.findElements(By.cssSelector("div h4.product-name"));
int j=0;
List<String> productList=Arrays.asList(productName);
for(int i=0;i< products.size();i++){
	
	String name=products.get(i).getText();
	String prNAme= name.split(" ")[0].trim();
	
	
	System.out.println("product name "+name);
	System.out.println("trimmed product :"+prNAme);
	if(productList.contains(prNAme)) {
		driver.findElements(By.cssSelector(".product-action button")).get(i).click();
		j++;
		if(j==productName.length) {
			System.out.println("breaking");
			break;
		}
	}
}

	}

}
