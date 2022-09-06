package com.deluxepter.rlmaploader.util;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public final class I18N {
    private static final ObjectProperty<Locale> locale;

    static {
        locale = new SimpleObjectProperty<>(getDefaultLocale());
        locale.addListener((observable, oldValue, newValue) -> Locale.setDefault(newValue));
    }

    /**
     * @return list of supported locales
     */
    public static ObservableList<Locale> getSupportedLocales() {
        return FXCollections.observableArrayList(Arrays.asList(
                new Locale("en", "US"),
                new Locale("ru", "RU"),
                new Locale("es", "CO")));
    }

    private static Locale getDefaultLocale() {
        Locale sysDefault = Locale.getDefault();
        return getSupportedLocales().contains(sysDefault) ? sysDefault : new Locale("en", "US");
    }

    public static Locale getLocale() {
        return locale.get();
    }

    public static void setLocale(Locale locale) {
        localeProperty().set(locale);
        Locale.setDefault(locale);
    }

    public static ObjectProperty<Locale> localeProperty() {
        return locale;
    }

    public static ResourceBundle getBundle() {
        return ResourceBundle.getBundle("com.deluxepter.rlmaploader.lang.lb", getLocale());
    }
}