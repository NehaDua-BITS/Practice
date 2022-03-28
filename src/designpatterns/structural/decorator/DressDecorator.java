package designpatterns.structural.decorator;

public class DressDecorator implements Dress {
    private Dress dress;

    public DressDecorator(Dress dress) {
        this.dress = dress;
    }

    @Override
    public void assemble() {
        this.dress.assemble();
    }
}
