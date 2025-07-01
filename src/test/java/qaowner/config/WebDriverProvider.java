package qaowner.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

public class WebDriverProvider  implements Supplier<WebDriver> {

    private final WebDriverConfig config;

    public WebDriverProvider() {
        config = new WebDriverConfig();
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
