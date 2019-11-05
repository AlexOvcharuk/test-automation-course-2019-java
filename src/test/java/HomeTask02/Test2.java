package HomeTask02;

import org.junit.Assert;
import org.junit.Test;

public class Test2 extends testObj2{

    @Test
    public void task02() {
        String productName = "Yellow Duck";

        Product firstProduct = new Product(productName);

        clickProductOnMainPage(firstProduct);

        Product secondProduct = getProductValues();

        Assert.assertEquals(firstProduct.name, secondProduct.name);
        Assert.assertEquals(firstProduct.oldPrice, secondProduct.oldPrice);
        Assert.assertEquals(firstProduct.price, secondProduct.price);

        Assert.assertEquals(firstProduct.OldPriceColor, "#333333");
        Assert.assertEquals(secondProduct.OldPriceColor, "#333333");

        Assert.assertEquals(secondProduct.priceColor, "#cc0000");
        Assert.assertEquals(secondProduct.priceColor, "#cc0000");

        Assert.assertEquals(firstProduct.OldPriceFont, "400");
        Assert.assertEquals(secondProduct.OldPriceFont, "400");

        Assert.assertEquals(firstProduct.priceFont, "700");
        Assert.assertEquals(secondProduct.priceFont, "700");
    }
}
