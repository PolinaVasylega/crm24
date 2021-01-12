package com.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * This class will use the Junit annotation @RunWith(),
 * which tells JUnit what is the test runner class.
 * @CucumberOptions are like property files or settings for your test.
 * Basically @CucumberOptions enables us to do all the things that
 * we could have done if we have used cucumber command line.
 * features - set path to the feature file
 * glue - set path to the step definition
 * tags - what tags in features will be executed
 * dryRun - dryRun option can either set as true or false.
 * If it is set as true, it means that Cucumber will only check that every Step
 * mentioned in the Feature File has corresponding code written in Step Definition file or not.
 * So in case any of the functions are missed in the Step Definition for any Step in Feature File,
 * it will give us the message with templates that we can just copy!.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com/step_definitions",
    tags = "",
    dryRun = false
)
public class CucumberRunner {
}
