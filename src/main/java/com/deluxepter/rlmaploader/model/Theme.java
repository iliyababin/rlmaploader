package com.deluxepter.rlmaploader.model;

import com.deluxepter.rlmaploader.util.ThemeManager;

public class Theme {
    private String name;
    private String file;
    private String path;

    public Theme(String name, String file) {
        this.name = name;
        this.file = file;
        this.path = ThemeManager.class.getResource("/com/deluxepter/rlmaploader/css/" + file).toExternalForm();
    }

    public String getName() {
        return name;
    }

    public String getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }

    public String toString() {
        return this.name;
    }
}
