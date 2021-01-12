package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    /**
     * The Properties class represents a persistent set of properties.
     * The Properties can be saved to a stream or loaded from a stream.
     * Each key and its corresponding value in the property list is a string.
     * By providing a key -> You'll get its value.
     */
    private static final Properties properties = new Properties();
    /**
     * Create a FileInputStream by opening a connection to an actual file, the file named by the path name name in the file system.
     * A new FileDescriptor object is created to represent this file connection.
     */
    private static InputStream in;

    /**
     * We're using the static block to open input stream between our Java program and file from outside
     * Than we want to close this connection right away, that's why we want to execute this code before anything else
     */
    static {
        try {
            in = new FileInputStream("configuration.properties");
            /**
             * Reads a property list (key and element pairs) from the input byte stream.
             * throws an exception that we need to handle
             */
            properties.load(in);
        } catch (IOException e) {
            /**
             * Here we're printing the error message and custom message
             * e.printStackTrace() - will tell you where exactly error occurs
             */
            System.out.println("Error while reading properties file! "+ e.getMessage());
            e.printStackTrace();
        }finally {
            /**
             * finally block will be executed no matter what, so we want to close our connection here
             * is it necessary? No. Is it a good practice?  Yes.
             */
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing input Stream" + e.getMessage());
                e.printStackTrace();
            }
        }

    }

    /**
     * Getter that will
     * @param key - take a parameter (key) and will
     * @return - return its corresponding value
     */
    public static String getProperty(String key){
       return properties.getProperty(key);
    }



}
