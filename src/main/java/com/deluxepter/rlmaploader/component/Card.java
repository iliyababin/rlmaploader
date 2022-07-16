package com.deluxepter.rlmaploader.component;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;


public class Card<T> extends Group {
    private ObjectProperty<T> value = new SimpleObjectProperty(this, "value");
    private int width = 200;
    private int height = 180;
    private Pos alignment = Pos.TOP_CENTER;
    private Image image;
    private String title;
    private TextAlignment textAlignment = TextAlignment.CENTER;

    public Card(T object, String title, Image image) {
        getStyleClass().add("card");
        this.value.set(object);
        VBox vBox = new VBox();
        vBox.setPrefWidth(width);
        vBox.setPrefHeight(height);
        vBox.setAlignment(alignment);

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(width / 1.7778);

        Label label = new Label(title);
        label.setTextAlignment(textAlignment);

        vBox.getChildren().addAll(imageView, label);
        this.getChildren().add(vBox);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getValue() {
        return value.getValue();
    }
}