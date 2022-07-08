package com.deluxepter.rlmaploader.controller;

import com.deluxepter.rlmaploader.util.I18N;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private MenuItem importMenuItem;
    @FXML
    private MenuItem deleteMenuItem;
    @FXML
    private Menu helpMenu;
    @FXML
    private MenuItem aboutMenuItem;
    @FXML
    private MenuItem settingsMenuItem;
    @FXML
    private Menu mapMenu;
    @FXML
    private TilePane tilePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapMenu.textProperty().bind(I18N.createStringBinding("map"));
        importMenuItem.textProperty().bind(I18N.createStringBinding("import"));
        deleteMenuItem.textProperty().bind(I18N.createStringBinding("delete"));
        helpMenu.textProperty().bind(I18N.createStringBinding("help"));
        aboutMenuItem.textProperty().bind(I18N.createStringBinding("about"));
        settingsMenuItem.textProperty().bind(I18N.createStringBinding("settings"));
    }

    @FXML
    private void openSettingsDialog() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/deluxepter/rlmaploader/view/settings.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/deluxepter/rlmaploader/dark_theme.css").toExternalForm());
        Stage stage = new Stage();
        stage.titleProperty().bind(I18N.createStringBinding("gui.settings.title"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}