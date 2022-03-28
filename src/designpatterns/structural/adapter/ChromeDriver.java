package designpatterns.structural.adapter;

public class ChromeDriver implements WebDriver {

    @Override
    public void findElement() {
        System.out.println("Found ChromeDriver element !");
    }

    @Override
    public void selectElement() {
        System.out.println("Selected ChromeDriver element !");
    }
}
