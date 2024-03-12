import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.28oi.ru/");
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/

    @Test
    public void loginTest() {
        driver.findElement(By.cssSelector(".pink-bold-menu-link")).click();
        driver.findElement(By.cssSelector(".product-card-wrapper:nth-child(5) .button:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".shopcart-widget-link:nth-child(1) .shopcart-widget-caption")).click();
        driver.findElement(By.cssSelector(".is-count-up")).click();
        //String expectedText = "2";
        //String actualText = driver.findElement(By.xpath("//div/input").
        //Assert.assertEquals(actualText, expectedText);
    }

}