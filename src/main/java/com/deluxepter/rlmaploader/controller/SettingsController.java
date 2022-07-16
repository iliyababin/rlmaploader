package com.deluxepter.rlmaploader.controller;

import com.deluxepter.rlmaploader.common.Configuration;
import com.deluxepter.rlmaploader.model.Theme;
import com.deluxepter.rlmaploader.util.I18N;
import com.deluxepter.rlmaploader.util.ThemeManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    @FXML
    private TextField rldirTextField;

    @FXML
    private ComboBox<Theme> themeComboBox;

    @FXML
    private ComboBox<Locale> languageComboBox;

    private ResourceBundle resources;
    private Configuration config;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resources = resourceBundle;
        this.config = Configuration.getInstance();
        rldirTextField.textProperty().bind(config.rlDirectoryProperty());
        languageComboBox.setValue(I18N.getLocale());
        themeComboBox.setValue(ThemeManager.getTheme());
        languageComboBox.setItems(I18N.getSupportedLocales());
        themeComboBox.setItems(ThemeManager.getSupportedThemes());
    }

    @FXML
    private void setRlDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(new Stage());
        try {
            config.setRlDirectory(directory.getAbsolutePath());
            new File(config.getMapsDirectory()).mkdirs();
        } catch (NullPointerException e) {
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    @FXML
    private void setLanguage() {
        I18N.setLocale(languageComboBox.getValue());
        new Alert(Alert.AlertType.INFORMATION, resources.getString("dialog.restart.language"), ButtonType.OK).show();
    }

    @FXML
    private void setTheme() {
        ThemeManager.setTheme(themeComboBox.getValue());
    }
}
