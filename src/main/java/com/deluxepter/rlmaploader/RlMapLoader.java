package com.deluxepter.rlmaploader;

import com.deluxepter.rlmaploader.util.GUIUtils;
import com.deluxepter.rlmaploader.util.I18N;
import com.deluxepter.rlmaploader.util.PropertyUtils;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        GUIUtils.installIcons(new Image(RlMapLoader.class.getResourceAsStream("icon.png")));
        GUIUtils.load(
                getClass().getResource("/com/deluxepter/rlmaploader/view/dashboard.fxml"),
                I18N.getBundle().getString("gui.dashboard.title"),
                Modality.NONE,
                true
        );
    }

    @Override
    public void stop() throws IOException {
        propertyUtils.storeProperties();
    }
}
