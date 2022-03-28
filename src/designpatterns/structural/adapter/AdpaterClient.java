package designpatterns.structural.adapter;

/**
 * Used when objects/classes offer same features
 * but have different interfaces
 * This adpater interface adpats to these existing interfaces
 * to avoid any modification in their source code
 * ex: charging adapter, usb to ethernet adapter
 * client -> adapter interface -> main interface
 * Adapter and Adaptee classes
 */
public class AdpaterClient {

    public static void main(String[] args) {
        performOperation(new ChromeDriver());
        performOperation(new WebDriverAdapter(new MozillaDriver()));
    }

    private static void performOperation(WebDriver webDriver) {
        webDriver.findElement();
        webDriver.selectElement();
    }

}
