package sample.learning;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyTest {
	static WebDriver wb;
	@Test
	public void openSite() throws IOException  {
		wb = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(wb, Duration.ofSeconds(20));
		wb.manage().window().maximize();
		wb.get("https://demo.dealsdray.com");
		WebElement username=wb.findElement(By.name("username"));
		username.sendKeys("prexo.mis@dealsdray.com");
		WebElement pwd=wb.findElement(By.name("password"));
		pwd.sendKeys("prexo.mis@dealsdray.com");
		WebElement logbtn=wb.findElement(By.xpath("//*[text()='Login']"));
		logbtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//*[@class=' MuiBox-root css-1y98cgs'])[1]")));
		WebElement mntl=wb.findElement(By.xpath("(//*[@class=' MuiBox-root css-1y98cgs'])[1]"));
		mntl.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Add Bulk Orders']")));
		WebElement mntl2=wb.findElement(By.xpath("//*[text()='Add Bulk Orders']"));
		mntl2.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputSizeSmall css-1imb3v5']")));
		WebElement ele=wb.findElement(By.xpath("//*[@class=\"MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputSizeSmall css-1imb3v5\"]"));
		ele.sendKeys("C:\\Users\\HP\\eclipse-workspace1\\learning\\src\\main\\resources\\demo-data.xlsx");
		wb.findElement(By.xpath("//*[text()='Import']")).click();
		wb.findElement(By.xpath("//*[text()='Validate Data']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		wb.switchTo().alert().accept();
		File scrFile = ((TakesScreenshot)wb).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\HP\\eclipse-workspace1\\learning\\src\\main\\resources\\output.png"));
	}
}
