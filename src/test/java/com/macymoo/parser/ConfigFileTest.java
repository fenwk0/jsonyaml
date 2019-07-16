package com.macymoo.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigFileTest {

    @Test
    public void getFile() {
        ConfigFile configFile = new ConfigFile("grafana.yaml");
        assertNotNull("File not read", configFile.getFile());
    }

    @Test
    public void getFilePath() {
    }

    @Test
    public void getCurrentFileExtension() {
    }

    @Test
    public void getFileName() {
    }

    @Test
    public void replaceFileExtension() {
    }

    @Test
    public void getIn() {
    }
}