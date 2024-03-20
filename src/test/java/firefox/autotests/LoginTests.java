package firefox.autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
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
    @Test(description = "Вход в личный кабинет")
    public void login() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sbuzin@bk.ru");
        driver.findElement(By.cssSelector("#password")).sendKeys("GdAtA123");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String expectedTitle = "История заказов";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test(description = "Вход в личный кабинет без пароля")
    public void loginEmptyPassword() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sbuzin@bk.ru");
        driver.findElement(By.cssSelector("#password")).sendKeys("");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String hasAttribute = driver.findElement(By.cssSelector("#password")).getAttribute("required");
        String expectedAttribute = "true";
        Assert.assertEquals(hasAttribute, expectedAttribute);
    }
    @Test(description = "Вход в личный кабинет без электронной почты")
    public void loginEmptyEmail() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("");
        driver.findElement(By.cssSelector("#password")).sendKeys("GdAtA123");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String hasAttribute = driver.findElement(By.cssSelector("#email")).getAttribute("required");
        String expectedAttribute = "true";
        Assert.assertEquals(hasAttribute, expectedAttribute);
    }
    @Test(description = "Вход в личный кабинет с невалидным паролем")
    public void loginInvalidPassword() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sbuzin@bk.ru");
        driver.findElement(By.cssSelector("#password")).sendKeys("GdAtA");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String expectedText = "Сочетание логина и пароля не подходит";
        String actualText = driver.findElement(By.cssSelector(".co-notice--danger")).getText();
        Assert.assertEquals(actualText, expectedText);
    }
    @Test(description = "Вход в личный кабинет с невалидной электронной почтой")
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