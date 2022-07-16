package com.deluxepter.rlmaploader.common;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.File;

public class Configuration {
    private final StringProperty rlDirectory = new SimpleStringProperty("");
    private final StringProperty mapsDirectory = new SimpleStringProperty("");

    public String getRlDirectory() {
        return rlDirectory.get();
    }

    public StringProperty rlDirectoryProperty() {
        return rlDirectory;
    }

    public void setRlDirectory(String rlDirectory) throws Exception {
        if (!new File(rlDirectory, "/TAGame/CookedPCConsole").exists())
            throw new Exception("That is not a valid Rocket League installation folder");
        this.rlDirectory.set(rlDirectory);
    }

    public String getMapsDirectory() {
        return mapsDirectory.get();
    }

    public StringProperty mapsDirectoryProperty() {
        return mapsDirectory;
    }

    public void setMapsDirectory(String mapsDirectory) {
        this.mapsDirectory.set(mapsDirectory);
    }

    private Configuration() {
        mapsDirectory.bind(Bindings.createStringBinding(() -> getRlDirectory() + "/Maps", rlDirectoryProperty()));
    }

    public static Configuration getInstance() {
        return Configuration.SettingsHolder.INSTANCE;
    }

    private static class SettingsHolder {
        private static final Configuration INSTANCE = new Configuration();
    }
}
