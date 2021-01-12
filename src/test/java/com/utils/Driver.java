package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * Singleton design pattern of the driver
 */
public class Driver {
    /**
     * private constructor - so it is impossible to create instance of this class.
     */
    private Driver(){}

    /**
     * driver instance:
     * private - for encapsulation (to protect framework from reaching this instance other than with getter)
     * static - no need to create instance to call it
     */
    private static WebDriver driver;

    /**
     * Getter for webdriver where we're returning WebDriver instance
     * Which is a parent class for ChromeDriver and FirefoxDriver (Polymorphism)
     * @return -  driver instance
     */
    public static WebDriver getDriver() {
       if(driver==null){
           /**
            * We're providing a key - browser and getting a value (for ex. chrome/firefox/safari etc)
            */
           String browser = ConfigurationReader.getProperty("browser");

           switch (browser){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
                   break;
               default:
                   /**
                    * Throw a custom exception to terminate our program
                    */
                   System.out.println("Wrong browser name!");
                   throw new IllegalArgumentException();
           }
       }
       return driver;
    }

    /**
     * Method to terminate driver & close window
     */
    public static void closeDriver(){
        if(driver!=null){
            /**
             * Will close all of the windows that was opened by this driver's instance
             */
            driver.quit();
            /**
             * Assigning driver's value to null -> getting rid of it from memory
             */
            driver=null;
        }
    }
}
