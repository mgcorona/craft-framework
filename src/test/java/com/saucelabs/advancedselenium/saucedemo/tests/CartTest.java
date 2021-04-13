package test.java.com.saucelabs.advancedselenium.saucedemo.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.java.com.saucelabs.advancedselenium.saucedemo.pages.CartPage;
import test.java.com.saucelabs.advancedselenium.saucedemo.pages.HeaderSection;
import test.java.com.saucelabs.advancedselenium.saucedemo.pages.InventoryPage;
import test.java.com.saucelabs.advancedselenium.saucedemo.pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    public void addFromProductPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.visit();
        inventoryPage.selectBoltTshirt();

        new ProductPage(driver).addToCart();

        Assertions.assertEquals(1, new HeaderSection(driver).cartItems());
    }

    @Test
    public void removeFromProductPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.visit();
        inventoryPage.selectBoltTshirt();
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        productPage.removeFromCart();

        Assertions.assertEquals(0, new HeaderSection(driver).cartItems());
    }

    @Test
    public void addFromInventoryPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.visit();

        inventoryPage.addOnesieToCart();

        Assertions.assertEquals(1, new HeaderSection(driver).cartItems());
    }

    @Test
    public void removeFromInventoryPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.visit();

        inventoryPage.addBikeLightToCart();
        inventoryPage.removeBikeLightFromCart();

        Assertions.assertEquals(0, new HeaderSection(driver).cartItems());
    }

    @Test
    public void removeFromCartPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.visit();
        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();
        inventoryPage.goToCart();

        new CartPage(driver).removeBackpackFromCart();

        Assertions.assertEquals(1, new HeaderSection(driver).cartItems());
    }
}
