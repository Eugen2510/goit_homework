package module8;

public class parallelogram extends Shape{
    private String name;

    private int sideA;
    private int sideB;

    public parallelogram( int sideA, int sideB){
        if( sideA == 0 || sideB == 0) {
            System.out.println("Error creating");
            name = "not parallelogram";
            return;
        }
        this.sideA = Math.max(sideA,sideB);
        this.sideB = Math.min(sideA,sideB);
    }

    @Override
    public String getName(){
        return name;
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }

    @Override
    public double calcArea(){
        return 0;
    }

    @Override
    public double calcPerimeter(){
        return  2*sideA + 2*sideB;
    }
}
