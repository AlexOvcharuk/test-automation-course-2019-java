import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    WebDriver driver;

    @Before
    public void openBrowesr(){
        driver = new ChromeDriver();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void firstGoogleTest(){
        driver.get("http://google.com");
    }

    @Test
    public void ukrNetTest(){
        driver.get("http://ukr.net");
    }
}
