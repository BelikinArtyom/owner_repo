package qaowner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface TypeConfig extends Config {


    @Key("integer")
    Integer getInteger();

    @Key("double")
    String getDouble();

    @Key("boolean")
    URL getBoolean();

    @Key("enum")
    Browser getEnum();


}
