package com.deluxepter.rlmaploader.util;

import com.deluxepter.rlmaploader.model.Theme;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

import java.util.Arrays;

public class ThemeManager {
    private static final ObjectProperty<Theme> theme;


    static {
        theme = new SimpleObjectProperty<>(getDefaultTheme());
    }

    private static Theme getDefaultTheme() {
        return new Theme("Darcula", "dark_theme.css");
    }

    private static ObjectProperty<Theme> themeProperty() {
        return theme;
    }

    /**
     * @return list of all supported themes
     */
    public static ObservableList<Theme> getSupportedThemes() {
        return FXCollections.observableArrayList(Arrays.asList(
                new Theme("Darcula", "dark_theme.css"),
                new Theme("Blindness", "light_theme.css")));
    }

    /**
     * Changes the scene's theme whenever {@Link theme} gets updated
     *
     * @param scene to affect
     */
    public static void themeChanger(Scene scene) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getTheme().getPath());
        ThemeManager.themeProperty().addListener((observableValue, theme, t1) -> {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getTheme().getPath());
        });
    }

    /**
     * @param theme to set
     */
    public static void setTheme(Theme theme) {
        themeProperty().set(theme);
    }

    /**
     * @return current theme
     */
    public static Theme getTheme() {
        return theme.get();
    }
}
