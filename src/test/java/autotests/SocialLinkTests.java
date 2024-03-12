package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SocialLinkTests {
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
    public void vkLink() {
        driver.findElement(By.cssSelector(".fa-vk")).click();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);}
        String expectedURL = "https://vk.com/shop28oi";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void youTubelink() {
        driver.findElement(By.cssSelector(".fa-youtube")).click();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);}
        String expectedURL = "https://www.youtube.com/channel/UCA2nOXJ4thIc7aqfr1CqL6g";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void ticToclink() {
        driver.findElement(By.cssSelector(".tik-tok__link > img")).click();
        String expectedURL = "https://www.tiktok.com/@28oishop";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
}