package designpatterns.structural.facade.example2;

import java.sql.Driver;

public class ChromeBrowser {

    public static Driver getDriver() {
        return null;
    }

    public static void generateHtmlReport(String test, Driver driver) {
        System.out.println("Generated Chrome HTML report");
    }

    public static void generateJunitReport(String test, Driver driver) {
        System.out.println("Generated Chrome Junit report");
    }
}
