package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private WebDriver driver;
    private static final By NAME_INPUT_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    private static final By FAMILY_INPUT_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    private static final By ADDRESS_INPUT_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By METRO_STATION_INPUT_FIELD = By.xpath(".//input[@placeholder='* Станция метро']");
    private static final By METRO_STATION_LIST = By.cssSelector(".select-search__select");
    private static final By PHONE_INPUT_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static final By DATE_INPUT_FIELD = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By DATE_PERIOD_DROPDOWN_LIST_SELECTED_FIELD = By.cssSelector(".react-datepicker__day--selected");
    private static final By RENTAL_PERIOD_INPUT_FIELD = By.cssSelector(".Dropdown-placeholder");
    private static final String RENTAL_PERIOD_DROPDOWN_LIST = ".//div[@class='Dropdown-option' and text()='%s']";
    private static final String SCOOTER_COlOR_CHECKBOX = "#%s";
    private static final By COMMENT_INPUT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private static final By MAKE_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By MODAL_WINDOW_YES_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private static final By SUCCESS_ORDER_HEADER = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    private static final By SAMOKAT_LOGO = By.cssSelector(".Header_LogoScooter__3lsAR");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage setName(String name) {
        driver.findElement(NAME_INPUT_FIELD).sendKeys(name);

        return this;
    }

    public OrderPage setFamily(String family) {
        driver.findElement(FAMILY_INPUT_FIELD).sendKeys(family);

        return this;
    }

    public OrderPage setAddress(String address) {
        driver.findElement(ADDRESS_INPUT_FIELD).sendKeys(address);

        return this;
    }

    public OrderPage setMetroStation(String metroStation) {
        driver.findElement(METRO_STATION_INPUT_FIELD).sendKeys(metroStation);
        driver.findElement(METRO_STATION_LIST).click();

        return this;
    }

    public OrderPage setPhone(String phone) {
        driver.findElement(PHONE_INPUT_FIELD).sendKeys(phone);

        return this;
    }

    public OrderPage clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();

        return this;
    }

    public OrderPage setDate(String date) {
        driver.findElement(DATE_INPUT_FIELD).sendKeys(date);
        driver.findElement(DATE_PERIOD_DROPDOWN_LIST_SELECTED_FIELD).click();

        return this;
    }

    public OrderPage setRentalPeriod(String rentalPeriod) {
        driver.findElement(RENTAL_PERIOD_INPUT_FIELD).click();
        String elementPath = String.format(RENTAL_PERIOD_DROPDOWN_LIST, rentalPeriod);
        driver.findElement(By.xpath(elementPath)).click();

        return this;
    }

    public OrderPage setScooterColorCheckbox(String color) {
        String elementPath = String.format(SCOOTER_COlOR_CHECKBOX, color);
        driver.findElement(By.cssSelector(elementPath)).click();

        return this;
    }


    public OrderPage setComment(String comment) {
        driver.findElement(COMMENT_INPUT_FIELD).sendKeys(comment);

        return this;
    }

    public void clickMakeOrderButton() {
        driver.findElement(MAKE_ORDER_BUTTON).click();

    }

    public void clickYesForCreatingAnOrder() {
        driver.findElement(MODAL_WINDOW_YES_BUTTON).click();

    }

    public void createOrder() {
        clickMakeOrderButton();
        clickYesForCreatingAnOrder();
    }

    public WebElement getSuccessOrderHeader() {
        return driver.findElement(SUCCESS_ORDER_HEADER);
    }

    public void clickSamokatLogoButton() {
        driver.findElement(SAMOKAT_LOGO).click();
    }
}
