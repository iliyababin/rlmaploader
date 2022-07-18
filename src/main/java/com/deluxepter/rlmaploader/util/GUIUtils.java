package com.deluxepter.rlmaploader.util;

import com.deluxepter.rlmaploader.RlMapLoader;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;

public class GUIUtils {
    /**
     * Set the icons for all the stages in the project
     *
     * @param icons
     * @see <a href="https://stackoverflow.com/a/66252665">Set Icon For Overall Application Windows In JavaFX</a>
     */
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

    /**
     * Opens a new stage with provided parameters.
     * Sets default theme and bundle.
     *
     * @param FXML
     * @param title
     * @param modality
     * @param resizable
     * @throws IOException
     */
    public static void load(URL FXML, String title, Modality modality, boolean resizable) throws IOException {
        Parent root = FXMLLoader.load(FXML, I18N.getBundle());
        Scene scene = new Scene(root);
        ThemeManager.themeChanger(scene);
        Stage stage = new Stage();
        stage.initModality(modality);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(resizable);
        stage.show();
    }

    public static void showNotification(String title, String text) {
        Notifications notifications = Notifications.create()
                .title(title)
                .text(text)
                .graphic(new ImageView(new Image(RlMapLoader.class.getResourceAsStream("/com/deluxepter/rlmaploader/ok.png"))))
                .hideAfter(Duration.seconds(6));
        notifications.show();
    }
}
