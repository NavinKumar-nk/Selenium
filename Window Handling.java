package BasicAutomations;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("WebDriver.Chrome.Driver", 
				"D:\\Apps\\Eclipse_IDE\\WebDriver\\chromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String oldWindow = driver.getWindowHandle();
		WebElement firstButton= driver.findElement(By.name("newbrowserwindow123"));
		firstButton.click();

		Set<String> handles = driver.getWindowHandles();

		for (String newWindow : handles)
		{
			driver.switchTo().window(newWindow);
		}
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(oldWindow);
		Thread.sleep(2000);
		WebElement secondButton= driver.findElement(By.xpath("//*[@id=\'button1\']"));
		secondButton.click();
		Thread.sleep(2000);

		int numberOfWindows=driver.getWindowHandles().size();
		System.out.println("The number opened windows was : "+numberOfWindows);
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(2000);
		driver.quit();
	}
}