package assignmentTwoModuleSix;

import java.net.SocketException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTwoModuleSix {

	public static void main(String[] args) throws InterruptedException, SocketException {
		
/*		Test Scenario I: Actions
		Step-1 Launch Chrome Browser
		Step-2 Open Test URL- http://only-testing-blog.blogspot.com/2014/09/selectable.html
		Step-3 Double Click on Double-Click Me to See Alert Button to generate Alert
		Step-4 Accept Alert
		Step-5 Close Browser 
		*/
		

		   WebDriverManager.chromedriver().setup();
	       WebDriver driver=new ChromeDriver();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	       driver.navigate().to("http://only-testing-blog.blogspot.com/2014/09/selectable.html");
	       driver.manage().window().maximize();

	       Actions action=new Actions(driver);
	       action.doubleClick(driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"))).build().perform();
	       wait.until(ExpectedConditions.alertIsPresent());
	       driver.switchTo().alert();
	       Thread.sleep(2000);
	       driver.switchTo().alert().accept();
	       Thread.sleep(2000);
	       driver.close();
	}

}
