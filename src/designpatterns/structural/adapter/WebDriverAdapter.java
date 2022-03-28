package designpatterns.structural.adapter;

public class WebDriverAdapter implements WebDriver {

    private MozillaDriver mozillaDriver;

    public WebDriverAdapter(MozillaDriver mozillaDriver) {
        this.mozillaDriver = mozillaDriver;
    }

    @Override
    public void findElement() {
        mozillaDriver.retrieveElement();
    }

    @Override
    public void selectElement() {
        mozillaDriver.clickElement();
    }
}
