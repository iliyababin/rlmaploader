package com.deluxepter.rlmaploader.util;

import com.deluxepter.rlmaploader.model.Theme;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

import java.util.Arrays;

public class ThemeManager {
    private static ObjectProperty<Theme> theme;

    static {
        theme = new SimpleObjectProperty<>(getDefaultTheme());
    }

    public static Theme getTheme() {
        return theme.get();
    }

    public static ObjectProperty<Theme> themeProperty() {
        return theme;
    }

    public static void setTheme(Theme theme) {
        themeProperty().set(theme);
    }

    public static Theme getDefaultTheme() {
        return new Theme("Darcula", "dark_theme.css");
    }

    public static ObservableList<Theme> getSupportedThemes() {
        return FXCollections.observableArrayList(Arrays.asList(
                new Theme("Darcula", "dark_theme.css"),
                new Theme("Blindness", "light_theme.css")));
    }

    public static void themeChanger(Scene scene) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getTheme().getPath());
        ThemeManager.themeProperty().addListener((observableValue, theme, t1) -> {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getTheme().getPath());
        });
    }
}
