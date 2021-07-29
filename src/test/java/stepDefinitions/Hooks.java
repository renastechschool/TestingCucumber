package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@Monthly")
    public void preCheckMonthly(){
        System.out.println("perform Pre-Checks for Monthly");
    }
    @Before("@Daily")
    public void preCheckDaily(){
        System.out.println("perform Pre-Checks for Daily");
    }
    @Before("@Weekly")
    public void preCheckWeekly(){
        System.out.println("perform Pre-Checks for Weekly");
    }

    @After("@Monthly")
    public void postCheckMonthly(){
        System.out.println("perform Post-Check for monthly");
    }
    @After("@Daily")
    public void postCheckDaily(){
        System.out.println("perform Post-Check for Daily");
    }
    @After("@Weekly")
    public void postCheckWeekly(){
        System.out.println("perform Post-Check for Weekly");
    }
}
