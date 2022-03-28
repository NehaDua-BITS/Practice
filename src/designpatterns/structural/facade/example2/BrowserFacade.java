package designpatterns.structural.facade.example2;

import java.sql.Driver;

public class BrowserFacade {

    public static void generateReports(String browser, String type, String test) {
        Driver driver = null;
        switch (browser) {
            case "firefox":
                driver = FirefoxBrowser.getDriver();
                switch (type) {
                    case "html":
                    FirefoxBrowser.generateHtmlReport(test, driver);
                    break;

                    case "junit":
                    FirefoxBrowser.generateJunitReport(test, driver);
                    break;
                }
                break;

            case "chrome":
                driver = ChromeBrowser.getDriver();
                switch (type) {
                    case "html":
                        ChromeBrowser.generateHtmlReport(test, driver);
                        break;

                    case "junit":
                        ChromeBrowser.generateJunitReport(test, driver);
                        break;
                }
                break;

            default:
                throw new RuntimeException("Unsupported browser");
        }
    }

}
