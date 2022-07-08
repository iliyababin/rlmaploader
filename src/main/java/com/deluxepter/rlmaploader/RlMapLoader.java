package com.deluxepter.rlmaploader;

import com.deluxepter.rlmaploader.util.I18N;
import com.deluxepter.rlmaploader.util.PropUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Locale;

public class RlMapLoader extends Application {

    public static void main(String[] args) {
        try {
            PropUtil.getInstance().loadProperties();
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Locale locale = new Locale(
                PropUtil.getInstance().getPropertiesMap().get("language"),
                PropUtil.getInstance().getPropertiesMap().get("country"));
        I18N.setLocale(locale);
        Parent root = FXMLLoader.load(getClass().getResource("/com/deluxepter/rlmaploader/view/dashboard.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("dark_theme.css").toExternalForm());
        stage.titleProperty().bind(I18N.createStringBinding("gui.dashboard.title"));
        stage.getIcons().add(new Image(RlMapLoader.class.getResourceAsStream("icon.png")));
        stage.setScene(scene);
        stage.show();
    }
}
