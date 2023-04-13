package module8;

import java.util.Objects;

public class Ellipse extends Shape{
    public static final double PI = 3.14;
    private final String name;
    private final int bigAxis;
    private final int smallAxis;

    public Ellipse (int axis1, int axis2){
        if(axis1 <= 0 || axis2 <= 0){
            System.out.println("Wrong parameters");
            name = "none";
            this.bigAxis = 0;
            this.smallAxis = 0;
            return;
        }
        name = "ellipse";
        bigAxis = Math.max(axis1,axis2);
        smallAxis = Math.min(axis1,axis2);
    }


    public String getName(){
        return name;
    }

    public int getBigAxis(){
        return bigAxis;
    }

    public int getSmallAxis(){
        return smallAxis;
    }

    @Override
    public double calcArea(){
        double a = (double) bigAxis/2;
        double b = (double) smallAxis/2;
        return PI*a*b;
    }

    @Override
    public double calcPerimeter(){
        double a = (double) bigAxis/2;
        double b = (double) smallAxis/2;
        return 4*(PI*a*b + Math.pow(a-b,2))/(a + b);
    }

    @Override
    public String toString(){
        return "This is " + name
                + "\nbig axis = " + bigAxis
                + "; small axis = " + smallAxis
                + "\narea = " + calcArea()
                + "\nperimeter = " + calcPerimeter();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return ellipse.bigAxis == bigAxis && ellipse.smallAxis == smallAxis;
    }

    @Override
    public int hashCode(){
        return Objects.hash(bigAxis,smallAxis);
    }
}

