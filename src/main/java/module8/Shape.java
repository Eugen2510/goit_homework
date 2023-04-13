package module8;

abstract class Shape {
    private final String name = "some shape";


    public abstract String getName();


    public abstract double calcArea();

    public abstract double calcPerimeter();
}
