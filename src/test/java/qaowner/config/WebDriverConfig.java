package qaowner.config;

import java.util.Objects;

import static com.codeborne.selenide.Configuration.browser;

public class WebDriverConfig {

    public String getBaseUrl() {

      String baseuRL = System.getProperty("baseUrl");
      if (Objects.isNull(baseuRL)) {
                baseuRL = "https://github.com";
      }
        return baseuRL;
    }

    public Browser getBrowser() {

        String browser = System.getProperty("browser");
        return Browser.valueOf(browser);
    }

}
