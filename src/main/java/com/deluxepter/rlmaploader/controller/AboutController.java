package com.deluxepter.rlmaploader.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {
    @FXML
    TextArea description;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        description.setText("Version: 1.0.0 \n \n" +
                "A cross-platform application for importing, managing, and loading custom maps into Rocket League.");
    }
}
