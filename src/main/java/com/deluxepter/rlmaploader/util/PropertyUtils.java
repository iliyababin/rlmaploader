package com.deluxepter.rlmaploader.util;

import com.deluxepter.rlmaploader.common.Configuration;
import com.deluxepter.rlmaploader.model.Theme;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PropertyUtils {
    private final File propertiesFile = new File("rlml.properties");
    private Configuration config = Configuration.getInstance();
    private Properties properties = new Properties();

    public PropertyUtils() {
    }

    public void loadProperties() throws IOException {
        if (!propertiesFile.exists()) {
            storeProperties();
        }
        properties.load(new FileReader(propertiesFile));
        try {
            config.setRlDirectory(properties.getProperty("rl_directory"));
        } catch (Exception e) {

        }
        ThemeManager.setTheme(new Theme(properties.getProperty("theme_name"), properties.getProperty("theme_file")));
        I18N.setLocale(new Locale(properties.getProperty("language"), properties.getProperty("country")));
    }

    public void storeProperties() throws IOException {
        properties.put("rl_directory", config.getRlDirectory());
        properties.put("theme_name", ThemeManager.getTheme().getName());
        properties.put("theme_file", ThemeManager.getTheme().getFile());
        properties.put("language", I18N.getLocale().getLanguage());
        properties.put("country", I18N.getLocale().getCountry());
        properties.store(new FileWriter(propertiesFile), "Rocket League Map Loader");
    }
}
