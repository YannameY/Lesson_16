package path.to.your.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
public class PaymentPage {
    private WebDriver driver;

    /**
     * Поле услуги связи
     *
    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneInput;

    @FindBy(id = "connection-sum")
    private WebElement sumInput;

    @FindBy(id = "connection-email")
    private WebElement emailInput;

    /**
     * Поле домашнего интернета
     *
    @FindBy(id = "internet-phone")
    private WebElement internetPhoneInput;

    @FindBy(id = "internet-sum")
    private WebElement internetSumInput;

    @FindBy(id = "internet-email")
    private WebElement internetEmailInput;

    /**
     * поле рассрочки
     *
    @FindBy(id = "score-instalment")
    private WebElement scoreInstalment;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSum;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmail;

    /**
     * Поле задолженности
     *
    @FindBy(id = "score-arrears")
    private WebElement scoreArrears;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSum;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmail;

    /**
     * Конструктор класса PaymentPage
     *
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Проверяет плейсхолдеры для услуги связи
     *
    public void checkConnectionPlaceholders(String expectedPhonePlaceholder, String expectedSumPlaceholder, String expectedEmailPlaceholder) {
        System.out.println("Для формы услуги связи");
        assertPlaceholder("Номер телефон", phoneInput.getAttribute("placeholder"), expectedPhonePlaceholder);
        assertPlaceholder("Сумма", sumInput.getAttribute("placeholder"), expectedSumPlaceholder);
        assertPlaceholder("E-mail для отправки чека", emailInput.getAttribute("placeholder"), expectedEmailPlaceholder);
        System.out.println();
    }

    /**
     * Проверяет плейсхолдеры для домашнего интернета
     *
    public void checkInternetPlaceholders(String expectedInternetPlaceholder, String expectedInternetSumPlaceholder, String expectedInternetEmailPlaceholder) {
        System.out.println("Для формы домашний интернет");
        assertPlaceholder("Номер абонента", internetPhoneInput.getAttribute("placeholder"), expectedInternetPlaceholder);
        assertPlaceholder("Сумма", internetSumInput.getAttribute("placeholder"), expectedInternetSumPlaceholder);
        assertPlaceholder("E-mail для отправки чека", internetEmailInput.getAttribute("placeholder"), expectedInternetEmailPlaceholder);
        System.out.println();
    }

    /**
     * Проверяет плейсхолдеры для рассрочки.
     *
    public void checkInstalmentPlaceholders(String expectedInstalmentPlaceholder, String expectedInstalmentSumPlaceholder, String expectedInstalmentEmailPlaceholder) {
        System.out.println("Для формы рассрочка");
        assertPlaceholder("Номер счета на 44", scoreInstalment.getAttribute("placeholder"), expectedInstalmentPlaceholder);
        assertPlaceholder("Сумма", instalmentSum.getAttribute("placeholder"), expectedInstalmentSumPlaceholder);
        assertPlaceholder("E-mail для отправки чека", instalmentEmail.getAttribute("placeholder"), expectedInstalmentEmailPlaceholder);
        System.out.println();
    }

    /**
     * Проверяет плейсхолдеры для задолженности.
     *
    public void checkArrearsPlaceholders(String expectedArrearsPlaceholder, String expectedArrearsSumPlaceholder, String expectedArrearsEmailPlaceholder) {
        System.out.println("Для формы задолженность");
        assertPlaceholder("Номер счета 2073", scoreArrears.getAttribute("placeholder"), expectedArrearsPlaceholder);
        assertPlaceholder("Сумма", arrearsSum.getAttribute("placeholder"), expectedArrearsSumPlaceholder);
        assertPlaceholder("E-mail для отправки чек", arrearsEmail.getAttribute("placeholder"), expectedArrearsEmailPlaceholder);
        System.out.println();
    }

    /**
     * Сравнивает фактический и ожидаемый плейсхолдер.
     *
    private void assertPlaceholder(String fieldName, String actualValue, String expectedValue) {
        if (!actualValue.equals(expectedValue)) {
            throw new AssertionError("Плэйсхолдер не верный для " + fieldName + ": фактический \"" + expectedValue + "\", ожидаемый \"" + actualValue + "\".");
        } else {
            System.out.println(fieldName + " Плейсхолдер такой как и ожидалось: " + actualValue);
        }
    }
}

 */
