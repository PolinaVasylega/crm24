package com.pages;

import com.utils.Driver;
import org.openqa.selenium.support.PageFactory;
/**
 * BasePage - will contain all the common methods and elements for each page
 * (for ex. some navigation elements/title/etc)
 */
public abstract class BasePage {
    /**
     * Factory class to make using Page Objects simpler and easier
     * Instantiate an instance of the given class, and set a lazy proxy for each of the WebElement
     * and List<WebElement> fields that have been declared, assuming that the field name is also the HTML element's "id" or "name".
     * This means that for the class: public class Page { private WebElement submit; } there will be an element that can be located using
     * the xpath expression "//*[@id='submit']" or "//*[@name='submit']"
     * By default, the element or the list is looked up each and every time a method is called upon it.
     */
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
