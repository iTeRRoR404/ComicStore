package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests {
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
    public void currentURL() {
        String expectedURL = "https://www.28oi.ru/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void homePageTitle() {
        String expectedTitle = "Магазин комиксов \"Двадцать восьмой\"";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void deliveryPage() {
        driver.findElement(By.linkText("Доставка и оплата")).click();
        String expectedTitle = "Доставка и оплата";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void bonusPage() {
        driver.findElement(By.linkText("Бонусная система")).click();
        String expectedTitle = "Накопительная система бонусных баллов";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void cartPage() {
        driver.findElement(By.cssSelector(".shopcart-widget-link:nth-child(1) .shopcart-widget-caption")).click();
        String expectedTitle = "Корзина";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void scrollTopArrow() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1250)");
        WebElement arrow = driver.findElement(By.cssSelector(".scroll-top"));
        assert arrow.isDisplayed();
    }
}