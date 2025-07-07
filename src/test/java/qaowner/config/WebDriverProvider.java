package qaowner.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.aeonbits.owner.ConfigFactory;
import java.util.function.Supplier;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebDriverNewConfig config;
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";

    public WebDriverProvider() {
        Properties properties = loadProperties();
        this.config = ConfigFactory.create(WebDriverNewConfig.class, properties, System.getProperties());
    }

    private Properties loadProperties() {
        Properties properties = new Properties();

        boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "false"));
        String configFile = isRemote ? "remote.properties" : "local.properties";

        try (FileInputStream input = new FileInputStream(configFile)) {
            properties.load(input);
        } catch (IOException e) {
        }

        properties.setProperty("remote", String.valueOf(isRemote));

        return properties;
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    public WebDriver createDriver() {
        if (config.isRemote()) {
            return createRemoteDriver();
        } else {
            return createLocalDriver();
        }
    }

    private WebDriver createLocalDriver() {
        switch (config.getBrowser().toLowerCase()) {
            case FIREFOX: {
                FirefoxOptions options = new FirefoxOptions();
                return new FirefoxDriver(options);
            }
            case CHROME: {
                ChromeOptions options = new ChromeOptions();
                return new ChromeDriver(options);
            }
            default: {
                throw new RuntimeException("Неподдерживаемый браузер: " + config.getBrowser());
            }
        }
    }

    private WebDriver createRemoteDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", config.getBrowser());
        capabilities.setCapability("browserVersion", config.getBrowserVersion());

        try {
            return new RemoteWebDriver(config.getRemoteUrl(), capabilities);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось создать RemoteWebDriver", e);
        }
    }
}