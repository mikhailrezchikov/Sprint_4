package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static final String FIREFOX_DRIVER = "FIREFOX";
    private static final String CHROME_DRIVER = "CHROME";

    public static WebDriver getWebDriver(String browserName) {
        if (browserName.equals(FIREFOX_DRIVER)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserName.equals(CHROME_DRIVER)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else {
            throw new RuntimeException("Нераспознанный браузер: " + browserName);
        }
    }
}
