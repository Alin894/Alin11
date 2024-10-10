package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import stepDefinition.Important.AbstractStepDefinition;

import java.sql.DriverManager;

import static driverManager.DriverManagerFactory.quitDriver;
import static driverManager.DriverManagerFactory.getDriver;
import static driverManager.DriverType.CHROME;


public class Hooks extends AbstractStepDefinition {
    @Before("@UI")
    public void beforeTest() {
       getDriver(CHROME);
    }

    @After("@UI")
    public void afterTest() {
        quitDriver();
    }

}
