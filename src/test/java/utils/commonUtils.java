package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

public class commonUtils {

    public static String getURL(String PropFileName) throws IOException {
        Properties prop = new Properties();
        FileInputStream in = new FileInputStream(PropFileName);
        prop.load(in);
        return prop.getProperty("url");
    }
}