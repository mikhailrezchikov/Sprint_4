package tests;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

@RunWith(Parameterized.class)
public class CreateOrderTests {
    private WebDriver driver;
    private final String name;
    private final String family;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final String rentalPeriod;
    private final String scooterColor;
    private final String comment;

    public CreateOrderTests(String name, String family, String address, String metroStation, String phone, String date,
                            String rentalPeriod, String scooterColor, String comment) {
        this.name = name;
        this.family = family;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Иван", "Иванов", "ул. Пушкина, дом 10", "Аэропорт", "89766113314", "20.11.24", "сутки", "grey", "Тест"},
                {"Иван", "Иванов", "ул. Пушкина, дом 10, корпус 1, квартира 53", "Чистые пруды", "+79766113314", "21.11.24", "двое суток", "black", "Тест"}
        };
    }

    @Before
    public void startUp() {
        driver = WebDriverFactory.getWebDriver("FIREFOX");
    }

    @Test
    public void testCreateOrderUsingOrderButtonInHeader() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage
                .openMainPage()
                .clickOrderButtonInHeader();
        orderPage
                .setName(name)
                .setFamily(family)
                .setAddress(address)
                .setMetroStation(metroStation)
                .setPhone(phone)
                .clickNextButton()
                .setDate(date)
                .setRentalPeriod(rentalPeriod)
                .setScooterColorCheckbox(scooterColor)
                .setComment(comment)
                .createOrder();
        Assert.assertTrue("Всплывающее окно с сообщением об успешном создании заказа не отображается",
                orderPage.getSuccessOrderHeader().isDisplayed());
    }

    @Test
    public void testCreateOrderUsingOrderButtonInHowItWorksSection() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage
                .openMainPage()
                .clickOrderButtonInHowItWorkSection();
        orderPage
                .setName(name)
                .setFamily(family)
                .setAddress(address)
                .setMetroStation(metroStation)
                .setPhone(phone)
                .clickNextButton()
                .setDate(date)
                .setRentalPeriod(rentalPeriod)
                .setScooterColorCheckbox(scooterColor)
                .setComment(comment)
                .createOrder();
        Assert.assertTrue("Всплывающее окно с сообщением об успешном создании заказа не отображается",
                orderPage.getSuccessOrderHeader().isDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
