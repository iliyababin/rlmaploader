package com.deluxepter.rlmaploader.controller;

import com.deluxepter.rlmaploader.common.Configuration;
import com.deluxepter.rlmaploader.component.Card;
import com.deluxepter.rlmaploader.model.CustomMap;
import com.deluxepter.rlmaploader.util.CustomMapHelper;
import com.deluxepter.rlmaploader.util.I18N;
import com.deluxepter.rlmaploader.util.ThemeManager;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private TilePane tilePane;

    @FXML
    private Menu mapMenu;

    @FXML
    private TextField mapSearchTextField;

    private ResourceBundle resources;
    private Configuration config;
    private ObservableList<CustomMap> mapList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        this.config = Configuration.getInstance();
        mapList = FXCollections.observableArrayList(CustomMapHelper.getMaps(new File(config.getMapsDirectory())));
        mapMenu.disableProperty().bind(config.rlDirectoryProperty().isEmpty());
        mapList.addListener((ListChangeListener<CustomMap>) change -> drawMaps());
        config.rlDirectoryProperty().addListener((observableValue, s, t1) -> drawMaps());
        drawMaps();
    }

    @SuppressWarnings("unchecked")
    @FXML
    private void drawMaps() {
        tilePane.getChildren().clear();
        if (mapList.isEmpty()) return;
        for (CustomMap map : mapList) {
            if (map.getName().toLowerCase().contains(mapSearchTextField.getText().toLowerCase())) {
                Card<CustomMap> card = new Card<>(map, map.getName(), map.getImage());
                tilePane.getChildren().add(card);
            }
        }
    }

    @FXML
    public void importMap() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(resources.getString("dialog.import.map"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(resources.getString("common.zip.file"), "*.zip"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile.exists() && selectedFile.isFile()) {
            try {
                CustomMapHelper.importMap(selectedFile, new File(config.getMapsDirectory()));
                mapList.setAll(CustomMapHelper.getMaps(new File(config.getMapsDirectory())));
            } catch (ZipException e) {
                new Alert(Alert.AlertType.ERROR, resources.getString("exception.invalid.zip"), ButtonType.OK).show();
            }
        }
    }

    @FXML
    private void reset() {
    }

    @FXML
    private void openSettingsDialog() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/deluxepter/rlmaploader/view/settings.fxml"), I18N.getBundle());
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle(resources.getString("gui.settings.title"));
        ThemeManager.themeChanger(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openAboutDialog() throws Exception {

    }
}