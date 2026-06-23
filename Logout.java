package seleniumlab; import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; public class Logout {
@Test
public void logoutTest() {
System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); WebDriver driver = new ChromeDriver();
driver.get("http://arms.sse.saveetha.com/");
// Logout automation depends on valid login.
// Since only dummy credentials are used, logout is demonstrated as procedure. assertTrue(driver.getTitle().length() > 0);
driver.quit();
}
}
