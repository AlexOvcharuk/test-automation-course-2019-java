import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class HomeTask01{
    WebDriver driver = null;
    WebDriverWait wait = null;


    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Before
    public void login() {
        openBrowser();
        driver.get("http://demo.litecart.net/admin/");
        driver.findElement(By.cssSelector(".btn-default")).click();

        wait.until((WebDriver d) -> d.findElements(By.cssSelector("div.alert")).size()>0);
    }

    public List<WebElement> getSideMenu() {
//        return driver.findElements(By.cssSelector("li.app"));
        return wait.until(numberOfElementsToBe(By.cssSelector("li.app"),17));
    }

    public List<WebElement> getSideSubMenu()  {
        return driver.findElements(By.cssSelector("li.doc"));
    }

    public boolean checkHeader() {
//        return wait.until((WebDriver d) -> d.findElements(By.cssSelector("div.panel-heading")).size() > 0);
        return driver.findElements(By.cssSelector("div.panel-heading")).size() > 0;
    }


    @Test
    public void Task01() throws InterruptedException {

        int sizeMenu = getSideMenu().size();
        Assert.assertEquals(sizeMenu,17);

        for (int i = 0; i < sizeMenu; i++){
            String menuText = getSideMenu().get(i).getText();
            System.out.println("=== Menu: " + menuText);

//            wait.until(visibilityOf(getSideMenu().get(i)));

            getSideMenu().get(i).click();

//            wait.until(visibilityOf(getSideMenu().get(i)));

            Assert.assertTrue(checkHeader());

            Thread.sleep(1000);

            if (getSideSubMenu().size() > 0){
                for (int j = 0; j < getSideSubMenu().size(); j++){
                    getSideSubMenu().get(j).click();
                    System.out.println(getSideSubMenu().get(j).getText());
                    checkHeader();
                }
            }
        }
    }
}
