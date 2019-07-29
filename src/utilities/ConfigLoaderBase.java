package utilities;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Base class for loaders
 */
public class ConfigLoaderBase {

    /**
     * Reads the value from a given properties file
     * @param file is the path to properties file to read from
     * @param key  is the key to read the value for
     */
    protected static String readPropertyValue(String file, String key) throws Exception {
        Properties prop = new Properties();
        InputStream input = null;
        String result = null;
        try {
            input = ConfigLoaderBase.class.getResourceAsStream(file);
            prop.load(input);
            result = prop.getProperty(key);
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return result;
    }

    /**
     * Reads the content from a given yml file and transforms it into a HashMap
     * Make sure the yml file content is properly structured
     * @param file is the path to yml file to read from
     */
    public static HashMap readYAMLValuesAsHashMap(String file) throws Exception {
        Yaml yaml = new Yaml();
        InputStream input = null;
        HashMap result = null;
        try {
            input = ConfigLoaderBase.class.getResourceAsStream(file);
            result = (HashMap) yaml.load(input);
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return result;
    }
}
