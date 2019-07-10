package com.macymoo.parser;

import org.junit.Test;

import java.io.IOException;

public class YamlParserTest {

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
}