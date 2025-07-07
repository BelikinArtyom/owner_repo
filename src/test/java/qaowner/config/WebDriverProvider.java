package qaowner.config;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class WebDriverProvider  implements Supplier<WebDriver> {

    private final WebDriverNewConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverNewConfig.class, System.getProperties());

    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    public WebDriver createDriver() {
        switch (config.getBrowser())  {
            case FIREFOX: {
                return new FirefoxDriver();
            }
            case CHROME: {
                return new ChromeDriver();
            }
            default: {
                throw new RuntimeException("Unsupported browser: " + config.getBrowser());
            }
        }
    }
}
