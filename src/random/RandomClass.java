package random;

import java.io.Serializable;

public class RandomClass implements Cloneable, Serializable {

    private static final long SerialVersionUID = 42L;

    private int x;
    private int y;

    public RandomClass() {
        System.out.println("No Arg constructor");
    }

    public RandomClass(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Args constructore");
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public RandomClass clone() throws CloneNotSupportedException {
        return (RandomClass) super.clone();
    }

    @Override
    public String toString() {
        return "RandomClass{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
