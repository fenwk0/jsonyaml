package com.macymoo.parser;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class YamlParserTest {

    public static final String PACKAGE_NAME = "com.macymoo.k8s";
    YamlParser yamlParser = null;

    @org.junit.Before
    public void setUp() throws Exception {
        yamlParser = new YamlParser("grafana.yaml");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void readYaml() throws IOException {

        String yaml = yamlParser.contents();

        System.out.println("yamlParser = " + yaml);
    }

    @Test
    public void convertYamlToJson() throws IOException {

        String json = yamlParser.convertToJson();

        System.out.println("yamlParser = " + json);
    }

    @Test
    public void jsonToPojoTest() throws IOException {
        String packageName = PACKAGE_NAME;


        File outputPojoDirectory = new File("." + File.separator + "convertedPojo");
        outputPojoDirectory.mkdirs();


        String jsonName = yamlParser.getFileURL().getFile().replace(".yaml",".json");
        yamlParser.convert2JSON(yamlParser.getFileURL(), outputPojoDirectory, packageName, jsonName);

    }

}