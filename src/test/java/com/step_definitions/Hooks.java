package com.step_definitions;

import com.utils.Driver;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import java.util.concurrent.TimeUnit;

/**
 * Hooks will be executed before run and after run
 */
public class Hooks {

    @BeforeAll
    public static void setUp(Scenario scenario){
        /**
         * will print the tag that we're tesing
         */
        System.out.println(scenario.getSourceTagNames());
        System.out.println("Starting automation");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterAll
    public static void tearDown(){
        Driver.closeDriver();
        System.out.println("End od the automation!");
    }


}
