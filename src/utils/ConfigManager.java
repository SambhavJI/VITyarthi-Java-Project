package utils;

public class ConfigManager {

    private static ConfigManager instance = new ConfigManager();

    public String currency = "INR";

    private ConfigManager() {}

    public static ConfigManager getInstance() {
        return instance;
    }
}
