package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
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
    public void login() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sbuzin@bk.ru");
        driver.findElement(By.cssSelector("#password")).sendKeys("GdAtA123");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String expectedTitle = "История заказов";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void loginEmptyPassword() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sbuzin@bk.ru");
        driver.findElement(By.cssSelector("#password")).sendKeys("");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String hasAttribute = driver.findElement(By.cssSelector("#password")).getAttribute("required");
        String expectedAttribute = "true";
        Assert.assertEquals(hasAttribute, expectedAttribute);
    }
    @Test
    public void loginEmptyEmail() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("");
        driver.findElement(By.cssSelector("#password")).sendKeys("GdAtA123");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String hasAttribute = driver.findElement(By.cssSelector("#email")).getAttribute("required");
        String expectedAttribute = "true";
        Assert.assertEquals(hasAttribute, expectedAttribute);
    }
    @Test
    public void loginInvalidPassword() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sbuzin@bk.ru");
        driver.findElement(By.cssSelector("#password")).sendKeys("GdAtA");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String expectedText = "Сочетание логина и пароля не подходит";
        String actualText = driver.findElement(By.cssSelector(".co-notice--danger")).getText();
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void loginInvalidEmail() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sbuz@bk.ru");
        driver.findElement(By.cssSelector("#password")).sendKeys("GdAtA123");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String expectedText = "Сочетание логина и пароля не подходит";
        String actualText = driver.findElement(By.cssSelector(".co-notice--danger")).getText();
        Assert.assertEquals(actualText, expectedText);
    }
}