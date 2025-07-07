package qaowner.config;

import java.net.MalformedURLException;
import java.net.URL;
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

        if (Objects.isNull(browser)) {
            browser = "CHROME";
        }
        return Browser.valueOf(browser);
    }

    public URL getRemoteURL() {
        //зачитываем значение из настроек
        String remoteUrl = System.getProperty("remoteUrl");
        //проверяем дефолтное значение
        if (Objects.isNull(remoteUrl)) {
            remoteUrl = "http://localhost:4444";
        }
        //возвращаем результат с приведением типов
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}


