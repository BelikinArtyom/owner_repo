package qaowner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverNewConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("127.0")
    String getBrowserVersion();

    @Key("remote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    URL getRemoteUrl();

    @Key("selenoidUser")
    @DefaultValue("")
    String getSelenoidUser();

    @Key("selenoidPassword")
    @DefaultValue("")
    String getSelenoidPassword();
}
