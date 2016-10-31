package by.pvt.dumping.managers;

import by.pvt.dumping.constants.ConfigConstants;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

@Component
public class ConfigManager {

    public ConfigManager() {}

    private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigConstants.CONFIGS_SOURCE);

    public String getProperty(String key) {
        return bundle.getString(key);
    }

}



