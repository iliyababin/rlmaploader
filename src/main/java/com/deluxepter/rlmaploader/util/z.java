package com.deluxepter.rlmaploader.util;

import javafx.scene.image.Image;

public class z {

    private void showNotification(String title, String text, Image image) {
        /*Notifications notifications = Notifications.create()
                .title(title)
                .text(text)
                .graphic(new ImageView(image))
                .hideAfter(Duration.seconds(5));
        notifications.show();*/
    }

    private void test() {
        /*card.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown()) {
                Card<CustomMap> test = (Card<CustomMap>) event.getSource();
                try {
                    CustomMapUtil.loadMap(test.getValue(), new File(config.getRldir()));
                    showNotification(
                            resources.getString("notification.success"),
                            String.format(resources.getString("notification.import.map.success"), map.getName()),
                            successImage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });*/
    }
}
