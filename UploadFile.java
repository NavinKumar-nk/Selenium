package BasicAutomations;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UploadFile
{

	public static void main(String[] args) throws InterruptedException, AWTException
	{
		System.setProperty("WebDriver.Chrome.Driver", 
				"D:\\Apps\\Eclipse_IDE\\WebDriver\\chromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement findElement=driver.findElement(By.id("uploadfile_0"));
		
		Actions act=new Actions(driver);
		act.click(findElement).perform();
		
		StringSelection sl=new  StringSelection("C:\\Users\\pc\\Documents\\SQL query.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sl, null);
		
		Robot rb=new Robot();
		rb.delay(5000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		WebElement check=driver.findElement(By.id("terms"));
		check.click();
		System.out.println(check.isSelected());
		driver.findElement(By.id("submitbutton")).click();
		Thread.sleep(2000);
		String text=driver.findElement(By.xpath("//center[2]")).getText();
		System.out.println(text);
	}
}