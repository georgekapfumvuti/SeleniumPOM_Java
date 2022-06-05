package com.selenium.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Utils {
    public static String get_element_from_properties_file(String key, String filename) {
        Properties property = new Properties();
        try {
            FileInputStream readMe = new FileInputStream("src/main/java/com/selenium/file/" + filename + ".properties");
            property.load(readMe);
        } catch (IOException exception) {
            System.out.println("Something gone wrong in Utils. get_element_from_properties_file method " + exception.getMessage());
        }

        return property.getProperty(key);

    }

    public static void waitUntil(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            System.out.println("Something gone wrong in Utils. waitUntil method" + e.getMessage());
        }

    }

    public static String generatingRandomAlphabeticString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        return   random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
