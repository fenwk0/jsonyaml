package com.macymoo.parser;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.SourceType;

public class JsonConfig extends DefaultGenerationConfig {
    @Override
    public boolean isGenerateBuilders() { // set config option by overriding method
        return true;
    }

    public SourceType getSourceType() {
        return SourceType.JSON;
    }
}
