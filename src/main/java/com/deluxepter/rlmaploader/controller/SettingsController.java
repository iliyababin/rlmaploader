package com.deluxepter.rlmaploader.controller;

import com.deluxepter.rlmaploader.util.I18N;
import com.deluxepter.rlmaploader.util.PropUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    @FXML
    private TitledPane generalTitledPane;
    @FXML
    private TextField rldirTextField;
    @FXML
    private ComboBox themeComboBox;
    @FXML
    private ComboBox<Locale> languageComboBox;
    @FXML
    private Label themeLabel;
    @FXML
    private Label languageLabel;
    @FXML
    private Label rlInstallFolderLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        themeLabel.textProperty().bind(I18N.createStringBinding("theme"));
        languageLabel.textProperty().bind(I18N.createStringBinding("language"));
        rlInstallFolderLabel.textProperty().bind(I18N.createStringBinding("rlinstallfolder"));
        generalTitledPane.textProperty().bind(I18N.createStringBinding("General"));

        rldirTextField.textProperty().bind(PropUtil.getInstance().propertiesMapProperty().valueAt("rldir"));

        languageComboBox.setValue(I18N.getLocale());
        for (Locale locale : I18N.getSupportedLocales()) {
            languageComboBox.getItems().add(locale);
        }
    }

    @FXML
    private void setRldir() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(new Stage());
        try {
            PropUtil.getInstance().getPropertiesMap().put("rldir", directory.getAbsolutePath());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    private void setLanguage() {
        String string = languageComboBox.getValue().toString();
        String[] parts = string.split("_");
        Locale newLocale = new Locale(parts[0], parts[1]);
        I18N.setLocale(newLocale);
        PropUtil.getInstance().getPropertiesMap().put("language", newLocale.getLanguage());
        PropUtil.getInstance().getPropertiesMap().put("country", newLocale.getCountry());
    }

    @FXML
    private void setTheme() {

    }
}
