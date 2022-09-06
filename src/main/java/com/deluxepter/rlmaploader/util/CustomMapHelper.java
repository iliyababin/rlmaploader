package com.deluxepter.rlmaploader.util;

import com.deluxepter.rlmaploader.model.CustomMap;
import javafx.scene.image.Image;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomMapHelper {
    public static List<CustomMap> getMaps(File path) {
        List<CustomMap> list = new ArrayList<>();
        if (getFolders(path) == null) return list;
        for (File folder : getFolders(path)) {
            CustomMap map = new CustomMap();
            for (File file : getFiles(folder)) {
                try {
                    map.setImage(new Image(new FileInputStream(file)));
                } catch (FileNotFoundException e) {
                }
                map.setUdkFile(file);
            }
            if (map.getUdkFile() == null) continue;
            map.setName(folder.getName());
            list.add(map);
        }
        return list;
    }

    private static File[] getFolders(File directory) {
        File[] directories = new File(directory.getAbsolutePath()).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        return directories;
    }

    private static File[] getFiles(File directory) {
        File[] files = directory.listFiles();
        return files;
    }


    /**
     * @param map    to import
     * @param folder destination
     * @throws ZipException
     * @apiNote no checks are performed on the validity of the map
     */
    public static void importMap(File map, File folder) throws ZipException {
        ZipFile zipFile = new ZipFile(map);
        if (!zipFile.isValidZipFile()) {
            throw new ZipException("That is not a valid zip file");
        }
        File mapFolder = new File(folder, FilenameUtils.removeExtension(map.getName()));
        mapFolder.mkdir();
        for (FileHeader fileHeader : zipFile.getFileHeaders()) {
            zipFile.extractFile(fileHeader, mapFolder.getAbsolutePath(), new File(fileHeader.getFileName()).getName());
        }
    }

    /**
     * @param map   to load
     * @param rldir where to load the map
     * @throws IOException
     */
    public static void loadMap(CustomMap map, File rldir) throws IOException {
        File underPassUdkBak = new File(rldir, "/TAGame/CookedPCConsole/Labs_Underpass_P.upk.bak");
        if (!underPassUdkBak.exists()) {
            File underPassUdk = new File(rldir, "/TAGame/CookedPCConsole/Labs_Underpass_P.upk");
            if (!underPassUdk.exists()) {
                throw new FileNotFoundException("Could not create a backup because Labs_Underpass_P.upk does not exist!");
            }
            underPassUdk.renameTo(underPassUdkBak);
        }
        File udkDesktination = new File(rldir, "/TAGame/CookedPCConsole/Labs_Underpass_P.upk");
        FileUtils.copyFile(map.getUdkFile(), udkDesktination);
    }

    /**
     * @param rldir
     */
    public static void resetMap(File rldir) {
        File underPassUdk = new File(rldir, "/TAGame/CookedPCConsole/Labs_Underpass_P.upk");
        File underPassUdkBak = new File(rldir, "/TAGame/CookedPCConsole/Labs_Underpass_P.upk.bak");
        if (!underPassUdk.exists()) {
            throw new RuntimeException("Could not delete underpass udk");
        }
        underPassUdkBak.renameTo(underPassUdk);
    }
}
