package module8;

public class ShapeNameShower {
    public static void nameShower(Shape shape){
        if (shape == null) return;
        System.out.println(shape.getName());
    }
}
