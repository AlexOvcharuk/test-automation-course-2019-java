package HomeTask02;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class testObj2 {
    WebDriver driver = null;
    WebDriverWait wait = null;
    WebElement product = null;

    public class Product {
        WebElement elem;
        String name;
        String oldPrice;
        String OldPriceColor;
        String price;
        String priceColor;
        String OldPriceFont;
        String priceFont;

        Product(){
            this.name = null;
        }

        Product(String prodName){
            this.name = prodName;
            System.out.println(this.name);
        }
    }

    public void openBrowesr() {
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);
    }

    @Before
    public void login() {
        openBrowesr();
        driver.get("http://demo.litecart.net");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }



    private void initMainePage(Product product) {
        WebElement oldPrice;
        WebElement newPrice;

        product.elem = driver.findElement(By.xpath("//section[@id='box-campaign-products']/div/article/a[@title='" + product.name + "']"));
        oldPrice = product.elem.findElement(By.cssSelector("del.regular-price"));
        newPrice = product.elem.findElement(By.cssSelector("strong.campaign-price"));
        product.oldPrice = oldPrice.getText();
        product.price = newPrice.getText();

        product.OldPriceColor = Color.fromString(oldPrice.getCssValue("color")).asHex();
        product.priceColor = Color.fromString(newPrice.getCssValue("color")).asHex();

        System.out.println(product.OldPriceColor + " ~ " + product.priceColor);

        product.OldPriceFont = oldPrice.getCssValue("font-weight");
        product.priceFont = newPrice.getCssValue("font-weight");

        System.out.println(product.OldPriceFont + " ~ " + product.priceFont);

    }

    public Product getProductValues() {
        Product product = new Product();
        WebElement oldPrice;
        WebElement newPrice;

        product.elem = driver.findElement(By.cssSelector("h1.title"));
        product.name = product.elem.getText();
        oldPrice = driver.findElement(By.cssSelector("del.regular-price"));
        newPrice = driver.findElement(By.cssSelector("strong.campaign-price"));
        product.oldPrice = oldPrice.getText();
        product.OldPriceColor = Color.fromString(oldPrice.getCssValue("color")).asHex();
        product.price = newPrice.getText();
        product.priceColor = Color.fromString(newPrice.getCssValue("color")).asHex();

        System.out.println(product.OldPriceColor + " - " + product.priceColor);

        product.OldPriceFont = oldPrice.getCssValue("font-weight");
        product.priceFont = newPrice.getCssValue("font-weight");

        System.out.println(product.OldPriceFont + " - " + product.priceFont);

        return product;
    }

    public void clickProductOnMainPage(Product product){
        initMainePage(product);
        product.elem.click();
    }




}
