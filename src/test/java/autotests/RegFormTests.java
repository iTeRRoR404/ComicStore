package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegFormTests {
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
    public void regEmptyName() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.linkText("Зарегистрироваться")).click();
        driver.findElement(By.cssSelector("#client_name")).sendKeys("");
        driver.findElement(By.cssSelector("#client_phone")).sendKeys("88008008008");
        driver.findElement(By.cssSelector("#client_email")).sendKeys("clientt@bk.ru");
        driver.findElement(By.cssSelector("#client_password")).sendKeys("AaSsDdFf");
        driver.findElement(By.cssSelector("#client_password_confirmation")).sendKeys("AaSsDdFf");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String expectedMessage = "Поле не заполнено";
        String actualMessage = driver.findElement(By.cssSelector(".co-input--name > .co-input-notice")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void regEmptyPhone() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.linkText("Зарегистрироваться")).click();
        driver.findElement(By.cssSelector("#client_name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.cssSelector("#client_phone")).sendKeys("");
        driver.findElement(By.cssSelector("#client_email")).sendKeys("clientt@bk.ru");
        driver.findElement(By.cssSelector("#client_password")).sendKeys("AaSsDdFf");
        driver.findElement(By.cssSelector("#client_password_confirmation")).sendKeys("AaSsDdFf");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String expectedMessage = "Поле не заполнено";
        String actualMessage = driver.findElement(By.cssSelector(".co-input-notice:nth-child(4)")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void regEmptyEmail() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.linkText("Зарегистрироваться")).click();
        driver.findElement(By.cssSelector("#client_name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.cssSelector("#client_phone")).sendKeys("88008008008");
        driver.findElement(By.cssSelector("#client_email")).sendKeys("");
        driver.findElement(By.cssSelector("#client_password")).sendKeys("AaSsDdFf");
        driver.findElement(By.cssSelector("#client_password_confirmation")).sendKeys("AaSsDdFf");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String expectedMessage = "Поле не заполнено";
        String actualMessage = driver.findElement(By.cssSelector(".co-input--email > .co-input-notice")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    /*@Test
    public void regEmptyPasswordTest() {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.linkText("Зарегистрироваться")).click();
        driver.findElement(By.cssSelector("#client_name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.cssSelector("#client_phone")).sendKeys("88008008008");
        driver.findElement(By.cssSelector("#client_email")).sendKeys("clientt@bk.ru");
        driver.findElement(By.cssSelector("#client_password")).sendKeys("AaSsDdFf");
        driver.findElement(By.cssSelector("#client_password_confirmation")).sendKeys("AaSsDd");
        driver.findElement(By.cssSelector(".js-co-login-submit")).click();
        String expectedMessage = "не совпадает с подтверждением";
        String actualMessage = driver.findElement(By.cssSelector(".co-notice--flash")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }*/
}