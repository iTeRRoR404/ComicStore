package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.28oi.ru/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addToCart() {
        driver.findElement(By.cssSelector(".pink-bold-menu-link")).click();
        driver.findElement(By.cssSelector(".product-card-wrapper:nth-child(5) .button:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".shopcart-widget-link:nth-child(1) .shopcart-widget-caption")).click();
        String actualText = driver.findElement(By.cssSelector(".item-title")).getText();
        String expectedText = "Подарочный бумажный сертификат 500 рублей";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void delFromCart() {
        driver.findElement(By.cssSelector(".pink-bold-menu-link")).click();
        driver.findElement(By.cssSelector(".product-card-wrapper:nth-child(5) .button:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".product-card-wrapper:nth-child(4) .button:nth-child(2)")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".shopcart-widget-link:nth-child(1) .shopcart-widget-caption")).click();

        //driver.findElement(By.cssSelector(".is-item-delete")).click();
        //String expectedText = "  Ваша корзина пуста";
        //String actualText = driver.findElement(By.cssSelector(".is-info")).getText();
        //Assert.assertEquals(actualText, expectedText);
    }

}