package module8;

import java.util.Objects;

public class Rectangle extends Shape{
    private String name;
    private int width;
    private int height;

    public Rectangle (int width, int height){
        if (width == 0 || height == 0){
            System.out.println("This is not rectangle");
            name = "none";
            return;
        }

        this.width = width;
        this.height = height;
//        if (height == width) {
//            name = "quad";
//            return;
//        }
        name = "rectangle";
    }

    @Override
    public String getName(){
        return name;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    @Override
    public double calcArea(){
        return height*width;
    }

    @Override
    public double calcPerimeter(){
        return height*2 + width*2;
    }

    @Override
    public String toString(){
        return "This is " + name
                + "\nwidth = " + width
                + "; height = " + height
                + "\narea = " + calcArea()
                + "\nperimeter = " + calcPerimeter();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle oRectangle = (Rectangle) o;
        int [] thisRect = findMaxMinSide();
        int [] oRect = oRectangle.findMaxMinSide();
        return (thisRect[0] == oRect[0]) && (thisRect[1] == oRect[1]);
    }

    @Override
    public int hashCode (){
        return Objects.hash(findMaxMinSide()[0], findMaxMinSide()[1]);
    }

    private int [] findMaxMinSide(){
        return new int[]{Math.max(height,width), Math.min(height,width)};
    }

    public static void main (String [] args){
        Rectangle r1 = new Rectangle(2,3);
        Rectangle r2 = new Rectangle(3,2);
        Circle c1 = new Circle(9);
        System.out.println(r1.equals(c1));
        System.out.println(r1.equals(r2));
        System.out.println(r1.hashCode());
        System.out.println(r2.hashCode());

    }

}
