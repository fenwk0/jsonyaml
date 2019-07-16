package com.macymoo.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;

public class YamlParser extends ByteSource {

    private String fileName;
    private ClassLoader classLoader = this.getClass().getClassLoader();
    private InputStream in;
    private String yaml;


    public YamlParser(String fileName) throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to obtain filename path (rubbish)
        Field pathField = FileOutputStream.class.getDeclaredField("path");
        pathField.setAccessible(true);

        this.fileName = fileName;
        this.in = classLoader.getResourceAsStream(this.fileName);
        Object o = pathField.get(in);
        this.fileName = (String) o;
    }

    public InputStream openStream() throws IOException {
        return in;
    }

    public String contents() throws IOException {
        if (yaml == null) {
            yaml = this.asCharSource(Charsets.UTF_8).read();
        }
        return yaml;

    }

    public String convertToJson() throws IOException {
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(yaml, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();
        return jsonWriter.writeValueAsString(obj);
    }


    public void convert2JSON(URL inputJson, File outputPojoDirectory, String packageName, String className) throws IOException {
        JCodeModel codeModel = new JCodeModel();
        URL source = inputJson;
        GenerationConfig config = new JsonConfig();

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, className, packageName, source);
        codeModel.build(outputPojoDirectory);
    }


    public URL getFileURL() throws MalformedURLException {
        URL retVal;
        //Create a file object
        File file = new File("filename");
        retVal = file.toURI().toURL();
        return retVal;
    }
}
