package module8;

public class ShapesTest {
    public static void main (String [] args){
        Triangle triangle = new Triangle(3,4,5);
        Circle circle = new Circle(8);
        Rectangle rectangle = new Rectangle(4,2);
        Ellipse ellipse = new Ellipse(7,8);
        ellipse = null;
        Quad quad = new Quad(6);

        Shape [] shapes = {triangle, circle, rectangle, ellipse, quad};

        for (Shape sh : shapes){
            ShapeNameShower.nameShower(sh);
        }
    }
}
