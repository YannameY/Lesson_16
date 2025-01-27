import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
package path.to.your;

public class MtsByPayTests {
    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Yan/Downloads/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by");

        mainPage = new MainPage(driver);
        closeCookieConsent(); // Закрываем окно куки
    }

    @Test
    public void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        Assert.assertEquals("Заголовок блока неверен", expectedTitle, mainPage.getBlockTitle()); // Проверяем заголовок
    }

    @Test
    public void testPaymentFieldsPlaceholders() {
        PaymentPage paymentPage = mainPage.goToPaymentPage(); // Переходим на страницу оплаты
        paymentPage.selectService("Услуги связи"); // Выбираем услуги связи

        // Проверяем надписи в незаполненных полях
        Assert.assertEquals("Неверный placeholder для телефона", "Номер телефона", paymentPage.getPhonePlaceholder());
        Assert.assertEquals("Неверный placeholder для суммы", "Сумма", paymentPage.getSumPlaceholder());
        Assert.assertEquals("Неверный placeholder для email", "E-mail для отправки чека", paymentPage.getEmailPlaceholder());

        paymentPage.selectService("Домашний интернет"); // Теперь выбираем домашний интернет

        // Проверяем надписи в незаполненных полях для домашнего интернета
        Assert.assertEquals("Неверный placeholder для номера абонента", "Номер абонента", paymentPage.getInternetPhonePlaceholder());
        Assert.assertEquals("Неверный placeholder для суммы", "Сумма", paymentPage.getInternetSumPlaceholder());
        Assert.assertEquals("Неверный placeholder для email", "E-mail для отправки чека", paymentPage.getInternetEmailPlaceholder());

        paymentPage.selectService("Рассрочка"); // Теперь выбираем рассрочку

        // Проверяем надписи в незаполненных полях для рассрочки
        Assert.assertEquals("Неверный placeholder для номера счета", "Номер счета на рассрочку", paymentPage.getInstalmentScorePlaceholder());
        Assert.assertEquals("Неверный placeholder для суммы", "Сумма", paymentPage.getInstalmentSumPlaceholder());
        Assert.assertEquals("Неверный placeholder для email", "E-mail для отправки чека", paymentPage.getInstalmentEmailPlaceholder());

        paymentPage.selectService("Задолженность"); // Теперь выбираем задолженность

        // Проверяем надписи в незаполненных полях для задолженности
        Assert.assertEquals("Неверный placeholder для номера счета", "Номер счета на 2073", paymentPage.getArrearsScorePlaceholder());
        Assert.assertEquals("Неверный placeholder для суммы", "Сумма", paymentPage.getArrearsSumPlaceholder());
        Assert.assertEquals("Неверный placeholder для email", "E-mail для отправки чека", paymentPage.getArrearsEmailPlaceholder());
    }

    @Test
    public void testFillPaymentDetailsAndSubmit() {
        PaymentPage paymentPage = mainPage.goToPaymentPage(); // Переходим на страницу оплаты
        paymentPage.selectService("Услуги связи"); // Выбираем услуги связи

        String phone = "297777777"; // Пример номера телефона
        String sum = "100"; // Пример суммы
        String email = "test@example.com"; // Пример email

        paymentPage.enterPaymentDetails(phone, sum, email); // Заполняем поля
        paymentPage.clickContinueButton(); // Кликаем на кнопку

        // Проверяем корректность отображения данных
        Assert.assertEquals("Неверный номер телефона", phone, paymentPage.getPhoneInputValue());
        Assert.assertEquals("Неверная сумма", sum, paymentPage.getSumInputValue());
        Assert.assertEquals("Неверный e-mail", email, paymentPage.getEmailInputValue()); // Проверяем email для услуг связи

        // Проверка наличия иконок платежных систем
        Assert.assertFalse("Иконки платежных систем не отображаются", paymentPage.getPaymentIcons().isEmpty());
    }

    @Test
    public void testFillInternetDetailsAndSubmit() {
        PaymentPage paymentPage = mainPage.goToPaymentPage(); // Переходим на страницу оплаты
        paymentPage.selectService("Домашний интернет"); // Выбираем домашний интернет

        String internetPhone = "297777777"; // Пример номера абонента
        String internetSum = "200"; // Пример суммы
        String internetEmail = "test_internet@example.com"; // Пример email для интернета

        paymentPage.enterInternetDetails(internetPhone, internetSum, internetEmail); // Заполняем поля
        paymentPage.clickContinueButton(); // Кликаем на кнопку

        // Проверяем корректность отображения данных
        Assert.assertEquals("Неверный номер абонента", internetPhone, paymentPage.getInternetPhoneInputValue());
        Assert.assertEquals("Неверная сумма", internetSum, paymentPage.getInternetSumInputValue());
        Assert.assertEquals("Неверный e-mail", internetEmail, paymentPage.getInternetEmailInputValue()); // Проверяем email для интернета

        // Проверка наличия иконок платежных систем
        Assert.assertFalse("Иконки платежных систем не отображаются", paymentPage.getPaymentIcons().isEmpty());
    }

    @Test
    public void testFillInstalmentDetailsAndSubmit() {
        PaymentPage paymentPage = mainPage.goToPaymentPage(); // Переходим на страницу оплаты
        paymentPage.selectService("Рассрочка"); // Выбираем рассрочку

        String instalmentScore = "123456789"; // Пример номера счета
        String instalmentSum = "150"; // Пример суммы
        String instalmentEmail = "test_instalment@example.com"; // Пример email для рассрочки

        paymentPage.enterInstalmentDetails(instalmentScore, instalmentSum, instalmentEmail); // Заполняем поля
        paymentPage.clickContinueButton(); // Кликаем на кнопку

        // Проверяем корректность отображения данных
        Assert.assertEquals("Неверный номер счета", instalmentScore, paymentPage.getInstalmentScoreInputValue());
        Assert.assertEquals("Неверная сумма", instalmentSum, paymentPage.getInstalmentSumInputValue());
        Assert.assertEquals("Неверный e-mail", instalmentEmail, paymentPage.getInstalmentEmailInputValue()); // Проверяем email для рассрочки

        // Проверка наличия иконок платежных систем
        Assert.assertFalse("Иконки платежных систем не отображаются", paymentPage.getPaymentIcons().isEmpty());
    }

    @Test
    public void testFillArrearsDetailsAndSubmit() {
        PaymentPage paymentPage = mainPage.goToPaymentPage(); // Переходим на страницу оплаты
        paymentPage.selectService("Задолженность"); // Выбираем задолженность

        String arrearsScore = "2073"; // Пример номера счета на задолженность
        String arrearsSum = "300"; // Пример суммы задолженности
        String arrearsEmail = "test_arrears@example.com"; // Пример email для задолженности

        paymentPage.enterArrearsDetails(arrearsScore, arrearsSum, arrearsEmail); // Заполняем поля
        paymentPage.clickContinueButton(); // Кликаем на кнопку

        // Проверяем корректность отображения данных
        Assert.assertEquals("Неверный номер счета", arrearsScore, paymentPage.getArrearsScoreInputValue());
        Assert.assertEquals("Неверная сумма", arrearsSum, paymentPage.getArrearsSumInputValue());
        Assert.assertEquals("Неверный e-mail", arrearsEmail, paymentPage.getArrearsEmailInputValue()); // Проверяем email для задолженности

        // Проверка наличия иконок платежных систем
        Assert.assertFalse("Иконки платежных систем не отображаются", paymentPage.getPaymentIcons().isEmpty());
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем драйвер
        }
    }
}
