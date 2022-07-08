package com.deluxepter.rlmaploader.model;

import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.io.File;

public class CustomMap {
    private String name;
    private File imageFile;
    private File udkFile;

    public CustomMap() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        try {
            if (ImageIO.read(imageFile) != null)
                this.imageFile = imageFile;
        } catch (Exception e) {
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
