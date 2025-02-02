import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsByPayTests {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        closeCookieConsent();
    }

    private static void closeCookieConsent() {
        try {
            WebElement cookieButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree")));
            cookieButton.click();
        } catch (Exception e) {

        }
    }

    @Test
    public void testServicePlaceholders() {
        checkPlaceholders("Услуги связи", "Номер телефона", "Сумма", "E-mail для отправки чека");
        checkPlaceholders("Домашний интернет", "Номер абонента", "Сумма", "E-mail для отправки чека");
        checkPlaceholders("Рассрочка", "Номер счета на 44", "Сумма", "E-mail для отправки чека");
        checkPlaceholders("Задолженность", "Номер счета на 2073", "Сумма", "E-mail для отправки чека");
    }

    private void checkPlaceholders(String serviceType, String expectedPhone, String expectedSum, String expectedEmail) {
        selectServiceFromDropdown(serviceType);


        if (serviceType.equals("Услуги связи")) {
            assertPlaceholder("Номер телефона", driver.findElement(By.xpath("//input[@placeholder='Номер телефона']")).getAttribute("placeholder"), expectedPhone);
            assertPlaceholder("Сумма", driver.findElement(By.id("connection-sum")).getAttribute("placeholder"), expectedSum);
            assertPlaceholder("E-mail для отправки чека", driver.findElement(By.id("connection-email")).getAttribute("placeholder"), expectedEmail);
        } else if (serviceType.equals("Домашний интернет")) {
            assertPlaceholder("Номер абонента", driver.findElement(By.xpath("//input[@placeholder='Номер абонента']")).getAttribute("placeholder"), expectedPhone);
            assertPlaceholder("Сумма", driver.findElement(By.id("internet-sum")).getAttribute("placeholder"), expectedSum);
            assertPlaceholder("E-mail для отправки чека", driver.findElement(By.id("internet-email")).getAttribute("placeholder"), expectedEmail);
        } else if (serviceType.equals("Рассрочка")) {
            assertPlaceholder("Номер счета на 44", driver.findElement(By.id("score-instalment")).getAttribute("placeholder"), expectedPhone);
            assertPlaceholder("Сумма", driver.findElement(By.id("instalment-sum")).getAttribute("placeholder"), expectedSum);
            assertPlaceholder("E-mail для отправки чека", driver.findElement(By.id("instalment-email")).getAttribute("placeholder"), expectedEmail);
        } else if (serviceType.equals("Задолженность")) {
            assertPlaceholder("Номер счета 2073", driver.findElement(By.id("score-arrears")).getAttribute("placeholder"), expectedPhone);
            assertPlaceholder("Сумма", driver.findElement(By.id("arrears-sum")).getAttribute("placeholder"), expectedSum);
            assertPlaceholder("E-mail для отправки чека", driver.findElement(By.id("arrears-email")).getAttribute("placeholder"), expectedEmail);
        }
    }

    private void selectServiceFromDropdown(String serviceType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select__wrapper']")));
        dropdown.click();

        WebElement serviceOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + serviceType + "']")));
        serviceOption.click();
    }

    private void assertPlaceholder(String fieldName, String actualValue, String expectedValue) {
        if (!actualValue.equals(expectedValue)) {
            throw new AssertionError(fieldName + ": ожидаемый \"" + expectedValue + "\", полученный \"" + actualValue + "\".");
        }
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
