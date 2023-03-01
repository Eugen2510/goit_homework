package module8;

public class Quad extends Rectangle{
    private final String name;
    public Quad (int height){
        super(height,height);
        name = "quad";
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "This is " + name
                + "\nwidth = height = " + getHeight()
                + "\narea = " + calcArea()
                + "\nperimeter = " + calcPerimeter();
    }
}

class QuadTest{
    public static void main(String[] args) {
        Quad quad = new Quad(9);
        Quad quad1 = new Quad(8);
        Quad quad2 = new Quad(8);
        System.out.println(quad1);
        System.out.println(quad1.getName());
        System.out.println(quad1.hashCode());
        System.out.println(quad2.hashCode());



    }
}
