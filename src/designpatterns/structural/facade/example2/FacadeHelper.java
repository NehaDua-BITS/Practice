package designpatterns.structural.facade.example2;

/**
 * Structural design pattern
 * Used when multiple interfaces/sub-systems do same kind of job
 * i.e. steps are same but internal implementation might be different
 * These interfaces can be managed by a single facade interface (unified interface)
 *
 * Provides a high-level interface that hides complexity of subsystems and makes
 * it easier to use them
 *
 * Facade == face or frontage
 *
 * Use when :
 * 1. there is a need to provide simple interface to a complex subsystem
 * 2. many dependencies between clients and implementation classes
 * 3. facade is used an entry point of all subsystems and interface for interaction between them
 *
 * Ex: customer --- waiter --- food/chef
 */
public class FacadeHelper {

    public static void main(String[] args) {

        String test = "testLogin";
        BrowserFacade.generateReports("chrome", "html", test);
        BrowserFacade.generateReports("chrome", "junit", test);
        BrowserFacade.generateReports("firefox", "html", test);
        BrowserFacade.generateReports("firefox", "junit", test);
        BrowserFacade.generateReports("safari", "html", test);
    }
}
