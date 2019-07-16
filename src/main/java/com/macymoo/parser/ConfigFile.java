package com.macymoo.parser;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;

public class ConfigFile {

    public File getFile() {
        return file;
    }

    public String getFilePath() {
        return filePath;
    }

    public CharSequence getCurrentFileExtension() {
        return currentFileExtension;
    }

    private final File file;
    private final String filePath;
    private String fileName;
    private FileInputStream in;
    private CharSequence currentFileExtension;

    public ConfigFile(String fileName){
        this.fileName = fileName;
        this.filePath =
                getClass().getClassLoader()
                .getResource(fileName)
                .getPath();
        this.file = FileUtils.getFile(this.filePath);
    }
    public String getFileName() {
        return this.fileName;
    }

    public String replaceFileExtension(CharSequence newFileExtension) {
        return this.fileName.replace(this.currentFileExtension, newFileExtension);
    }


    public FileInputStream getIn() {
        return this.in;
    }
}
