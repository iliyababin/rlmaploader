package com.deluxepter.rlmaploader.model;

import com.deluxepter.rlmaploader.RlMapLoader;
import javafx.scene.image.Image;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class CustomMap {
    private String name;
    private Image image;
    private File udkFile;

    public CustomMap() {
        image = new Image(RlMapLoader.class.getResourceAsStream("placeholder.png"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        if (!image.isError()) {
            this.image = image;
        }
    }

    public File getUdkFile() {
        return udkFile;
    }

    /**
     * @param udkFile
     * @apiNote this validates udk using ONLY the file extension.
     */
    public void setUdkFile(File udkFile) {
        if (!udkFile.isFile()) return;
        String fileExtension = FilenameUtils.getExtension(udkFile.getName());
        if (fileExtension.equals("udk")) {
            this.udkFile = udkFile;
        }
    }
}
