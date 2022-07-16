package com.deluxepter.rlmaploader;

import com.deluxepter.rlmaploader.util.I18N;
import com.deluxepter.rlmaploader.util.PropertyUtils;
import com.deluxepter.rlmaploader.util.ThemeManager;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class RlMapLoader extends Application {
    private static final PropertyUtils propertyUtils = new PropertyUtils();

    public static void main(String[] args) {
        try {
            propertyUtils.loadProperties();
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/deluxepter/rlmaploader/view/dashboard.fxml"), I18N.getBundle());
        Scene scene = new Scene(root);
        ThemeManager.themeChanger(scene);
        stage.setTitle(I18N.getBundle().getString("gui.dashboard.title"));
        installIcons(new Image(RlMapLoader.class.getResourceAsStream("icon.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void installIcons(Image... icons) {
        Window.getWindows().addListener((ListChangeListener<Window>) c -> {
            while (c.next()) {
                for (Window window : c.getAddedSubList()) {
                    if (window instanceof Stage) {
                        ((Stage) window).getIcons().setAll(icons);
                    }
                }
            }
        });
    }


    @Override
    public void stop() throws IOException {
        propertyUtils.storeProperties();
    }
}
