package seleniumlab; import org.junit.Test;
import static org.junit.Assert.*; import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions; import org.openqa.selenium.support.ui.WebDriverWait; import java.time.Duration;

public class Invalidautomation { @Test
public void invalidLoginTest() throws InterruptedException { System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); WebDriver driver = new ChromeDriver();

try {
// --- STEP 1: LOAD PAGE ---
driver.get("http://arms.sse.saveetha.com/"); driver.manage().window().maximize();

System.out.println(">>> PAUSING FOR 5 SECONDS. TAKE SCREENSHOT OF LOGIN PAGE NOW.");
Thread.sleep(5000); // PAUSE 1: Empty Login Page

// --- STEP 2: ENTER CREDENTIALS ---
driver.findElement(By.id("txtusername")).sendKeys("invaliduser"); driver.findElement(By.id("txtpassword")).sendKeys("wrongpass");
 




System.out.println(">>> PAUSING FOR 5 SECONDS. TAKE SCREENSHOT OF FILLED DETAILS.");
Thread.sleep(5000); // PAUSE 2: Credentials Entered

// --- STEP 3: CLICK LOGIN ---
WebElement loginBtn = driver.findElement(By.id("btnlogin")); JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript("arguments[0].click();", loginBtn);

// Wait for error to appear
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); try {
wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"),  "invalid"));
} catch (Exception e) {
// Ignore timeout
}

System.out.println(">>> PAUSING FOR 5 SECONDS. TAKE SCREENSHOT OF ERROR MESSAGE.");
Thread.sleep(5000); // PAUSE 3: Error Message Displayed

// --- STEP 4: VERIFY TEXT ---
String pageText = driver.findElement(By.tagName("body")).getText().toLowerCase(); System.out.println(">>> CHECKING TEXT: " + pageText);

boolean errorFound = pageText.contains("invalid") || pageText.contains("incorrect") || pageText.contains("wrong");

assertTrue("Test Failed: Error message not found.", errorFound);

} finally {
// DRIVER WILL CLOSE AUTOMATICALLY AFTER THE LAST PAUSE
driver.quit();
}
}
}
