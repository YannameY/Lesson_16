package path.to.your.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/*
public class MainPage {
    private WebDriver driver;

    //**
     * Конструктор класса MainPage
     *
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Переходит на страницу оплаты через выпадающий список.
     * Ожидает доступности выпадающего списка и элемента в нем,
     * затем выбирает указанный тип услуги.
     *
    public path.to.your.pages.PaymentPage selectServiceFromDropdown(String serviceType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select__wrapper']")));

        /**
         * Нажимаем на выпадающий список
         *
        dropdown.click();

        String optionXPath = "//p[@class='select__option' and text()='" + serviceType + "']";
        WebElement serviceOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXPath)));

        /**
         * Кликаем на нужный вариант
         *
        serviceOption.click();

        /**
         * Возвращаем новый объект страницы оплаты
         *
        return new path.to.your.pages.PaymentPage(driver);
    }
}


 */

