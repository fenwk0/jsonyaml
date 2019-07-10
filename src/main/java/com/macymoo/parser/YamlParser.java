package com.macymoo.parser;

import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;

import java.io.IOException;
import java.io.InputStream;

public class YamlParser extends ByteSource {

    private ClassLoader classLoader = this.getClass().getClassLoader();
    private InputStream in;


    public YamlParser(String fileName){
        in = classLoader.getResourceAsStream(fileName);

    }
    public InputStream openStream() throws IOException {
        return in;
    }

    public String contents() throws IOException {
        return this.asCharSource(Charsets.UTF_8).read();

    }
}
