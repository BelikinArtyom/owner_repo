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

    @Key("remoteUrl")
    @DefaultValue("https://localhost:4444")
    URL getRemoteUrl();

}

