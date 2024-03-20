package firefox.autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://www.28oi.ru/");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test(description = "Поиск на русском")
    public void searchRU() {
        driver.findElement(By.cssSelector(".search-widget-field")).sendKeys("на шифре");
        driver.findElement(By.cssSelector(".search-widget-button")).click();
        String actualText = driver.findElement(By.cssSelector(".product-link")).getText();
        String expectedText = "На шифре. Инсайдерская история криптовалютного бума";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test(description = "Поиск на английском")
    public void searchEN() {
        driver.findElement(By.cssSelector(".search-widget-field")).sendKeys("mortal kombat");
        driver.findElement(By.cssSelector(".search-widget-button")).click();
        String actualText = driver.findElement(By.cssSelector(".product-card-wrapper:nth-child(6) .product-link")).getText();
        String expectedText = "Mortal Kombat 1 (PS5)";
        Assert.assertEquals(actualText, expectedText);
    }
}