package com.example.fanfics.settings;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesToXml {
    public static String fileDir = "src/test/resources/Settings.xml";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("baseURL", "https://fanfics.me/");
        properties.setProperty("login", "olga11111111");
        properties.setProperty("password", "qwerty007");

        try (OutputStream outputStream =
                     Files.newOutputStream(Paths.get(fileDir))) {

            // convert the properties to an XML file
            properties.storeToXML(outputStream, "Server config file", String.valueOf(StandardCharsets.UTF_8));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
