package module8;

import java.util.Objects;

public class Circle extends Shape{
    public static final double PI = 3.14;
    private final String name;
    private final int radius;

    public Circle(int radius){
        if(radius <= 0){
            System.out.println("Wrong parameters");
            name = "none";
            this.radius = 0;
            return;
        }
        name = "circle";
        this.radius = radius;
    }

    @Override
    public String getName(){
        return name;
    }

    public int getRadius(){
        return radius;
    }

    @Override
    public double calcArea(){
        return PI*radius*radius;
    }

    @Override
    public double calcPerimeter(){
        return 2*PI*radius;
    }

    @Override
    public String toString(){
        return "This is " + name
                + "\nradius = " + radius
                + "\narea = " + calcArea()
                + "\ncircumference = " + calcPerimeter();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle)o;
        return circle.radius == radius;
    }

    @Override
    public int hashCode(){
        return Objects.hash(radius);
    }



}
