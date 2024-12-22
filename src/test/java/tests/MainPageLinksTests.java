package tests;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;


public class MainPageLinksTests {
    private WebDriver driver;
    private static final String YANDEX_URL = "yandex.ru";

    @Before
    public void startUp() {
        driver = WebDriverFactory.getWebDriver("CHROME");
    }

    @Test
    public void testClickingScooterLogoNavigatesToHomePage() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage
                .openMainPage()
                .clickOrderButtonInHeader();
        orderPage
                .clickSamokatLogoButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Главная страница не открылась после клика на логотип.",
                currentUrl, mainPage.getPageUrl());
        Assert.assertTrue("Уникальный элемент главной страницы не найден.",
                mainPage.getOrderButtonInHeader().isDisplayed());
    }

    @Test
    public void testClickingYandexLogoOpensYandexHomePageInNewWindow() {

        MainPage mainPage = new MainPage(driver);

        String currentYandexLogoButtonLinkUrl =
                mainPage
                .openMainPage()
                .getYandexLogoButtonLink();

        MatcherAssert.assertThat(String.format("Логотип Яндекса не содержит ожидаемый базовый URL: %s", YANDEX_URL),
                currentYandexLogoButtonLinkUrl, containsString(YANDEX_URL));
        Assert.assertTrue(String.format("URL %s не открывается в новой вкладке", YANDEX_URL),
                mainPage.isYandexLinkOpenInNewTab());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
