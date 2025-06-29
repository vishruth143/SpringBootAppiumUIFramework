package com.ea.SpringBootAppiumUIFramework.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser {

    private static final Map<String, String> CONFIG_FILE_PATHS = new HashMap<>();

    static {
        CONFIG_FILE_PATHS.put("ui_test_data_config", "src/test/resources/config/ui_test_data_config.yml");
    }

    public static JsonNode loadYaml(String configName) {
        try {
            File file = Paths.get(CONFIG_FILE_PATHS.get(configName)).toFile();
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            return mapper.readTree(file);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load YAML: " + configName, e);
        }
    }
}
