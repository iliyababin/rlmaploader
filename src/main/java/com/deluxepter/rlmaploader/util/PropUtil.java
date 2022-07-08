package com.deluxepter.rlmaploader.util;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.util.Map.entry;

public class PropUtil {
    private MapProperty<String, String> propertiesMap = new SimpleMapProperty<>(FXCollections.observableMap(new HashMap<>(Map.ofEntries(
            entry("rldir", ""),
            entry("theme", "dark"),
            entry("language", "en"),
            entry("country", "US")
    ))));
    private Properties properties = new Properties();
    private File propertiesFile = new File("rlml.properties");

    public ObservableMap<String, String> getPropertiesMap() {
        return propertiesMap.get();
    }

    public MapProperty<String, String> propertiesMapProperty() {
        return propertiesMap;
    }

    //private final ObjectProperty<Properties> prop = new SimpleObjectProperty<Properties>(new Properties());
    /*private final StringProperty rldir = new SimpleStringProperty("");
    private final StringProperty theme = new SimpleStringProperty("");
    private final StringProperty language = new SimpleStringProperty("");*/

    //private final ListProperty<StringProperty> props = new SimpleListProperty<>();

    public void loadProperties() throws IOException {
        if (!propertiesFile.exists() || propertiesFile.isDirectory()) {
            storeProperties();
        }
        properties.load(new FileReader(propertiesFile));
        for (String name : properties.stringPropertyNames()) {
            propertiesMap.put(name, properties.getProperty(name));
        }

        propertiesMap.addListener(new MapChangeListener<String, String>() {
            @Override
            public void onChanged(Change<? extends String, ? extends String> change) {
                try {
                    storeProperties();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void storeProperties() throws IOException {
        properties.putAll(propertiesMap);
        properties.store(new FileWriter(propertiesFile), "Rocket League Map Loader");
    }

    /*private Properties generateProperties() {
        Properties properties = new Properties();
        properties.put("rldir", rldir.getValue());
        properties.put("theme", theme.getValue());
        properties.put("language", language.getValue());
        return properties;
    }*/
    private PropUtil() {

    }

    public static PropUtil getInstance() {
        return PropUtil.PropertiesUtilHolder.INSTANCE;
    }

    private static class PropertiesUtilHolder {
        private static final PropUtil INSTANCE = new PropUtil();
    }
}
