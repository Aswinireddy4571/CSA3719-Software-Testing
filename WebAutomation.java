package seleniumlab;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Webautomation { @Test
public void verifyTitle() {
System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); WebDriver driver = new ChromeDriver();
driver.get("http://arms.sse.saveetha.com/"); String title = driver.getTitle(); System.out.println("Website Title: " + title); assertTrue(title.length() > 0);
driver.quit();
}}
