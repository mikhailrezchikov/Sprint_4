package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By IMPORTANT_QUESTIONS_SECTION = By.className("Home_FourPart__1uthg");
    private static final String QUESTION_TEMPLATE = ".//div[@data-accordion-component='AccordionItem']//div[text()='%s']";
    private static final String ANSWER_TEMPLATE = ".//div[@data-accordion-component='AccordionItem']//p[text()='%s']";
    private static final By ORDER_BUTTON_IN_HEADER = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    private static final By ORDER_BUTTON_IN_HOW_IT_WORK_SECTION = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static final By YANDEX_LOGO = By.cssSelector(".Header_LogoYandex__3TSOI");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(PAGE_URL);

        return this;
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    public MainPage scrollToImportantQuestionsSection() {
        WebElement importantQuestionsElement = driver.findElement(IMPORTANT_QUESTIONS_SECTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", importantQuestionsElement);

        return this;
    }

    public WebElement getImportantSectionQuestion(String questionText) {
        String elementPath = String.format(QUESTION_TEMPLATE, questionText);

        return driver.findElement(By.xpath(elementPath));
    }

    public WebElement getImportantSectionAnswer(String answerText) {
        String elementPath = String.format(ANSWER_TEMPLATE, answerText);

        return driver.findElement(By.xpath(elementPath));
    }

    public void clickOrderButtonInHeader() {
        driver.findElement(ORDER_BUTTON_IN_HEADER).click();
    }

    public WebElement getOrderButtonInHeader() {
        return driver.findElement(ORDER_BUTTON_IN_HEADER);
    }

    public void clickOrderButtonInHowItWorkSection() {
        WebElement orderButtonInHowItWorkSection = driver.findElement(ORDER_BUTTON_IN_HOW_IT_WORK_SECTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderButtonInHowItWorkSection);
        orderButtonInHowItWorkSection.click();
    }

    public String getYandexLogoButtonLink() {
        return driver.findElement(YANDEX_LOGO).getAttribute("href");
    }

    public boolean isYandexLinkOpenInNewTab() {
        String target = driver.findElement(YANDEX_LOGO).getAttribute("target");

        if (target.equals("_blank")) {
            return true;
        }
        return false;
    }
}
