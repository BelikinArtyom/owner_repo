package qaowner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverNewConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browser")
    String getBrowser();

    @Key("remoteUrl")
    URL getRemoteUrl();

}

