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
