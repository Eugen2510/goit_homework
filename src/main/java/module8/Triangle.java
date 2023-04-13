package module8;


public class Triangle extends Shape{
    private final String name;
    private  String type;
    private final int sideA;
    private final int sideB;
    private final int sideC;

    public Triangle(int a, int b, int c){
        if (!isTriangle(a,b,c)) {
            System.out.println("wrong parameters");
            name = "none";
            type = "";
            sideA = 0;
            sideB = 0;
            sideC = 0;
            return;
        }

        name = "Triangle";
        sideA = a;
        sideB = b;
        sideC = c;
        setType();
    }

    private void setType(){
        boolean isEquilateral = (sideA == sideB && sideB == sideC);
        boolean isIsosceles =  (sideA == sideB || sideA == sideC || sideB == sideC) && !isEquilateral;
        boolean isRight = calcArea()*2 == findMaxMiddleMinSide()[1]*findMaxMiddleMinSide()[2];
        if (isEquilateral){
            type = "equilateral";
            return;
        }
        if (isIsosceles) {
            type = "isosceles";
            return;
        }
        if (isRight) type = "right";
        else type = "ordinary triangle";
    }

    public String getName (){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getSideA(){
        return sideA;
    }

    public int getSideB(){
        return  sideB;
    }

    public int getSideC(){
        return sideC;
    }

    @Override
    public double calcArea(){

        return Math.sqrt(calcPerimeter()/2
                *(calcPerimeter()/2 - sideA)
                *(calcPerimeter()/2 - sideB)
                *(calcPerimeter()/2 - sideC));
    }

    @Override
    public double calcPerimeter(){
        return sideA + sideB + sideC;
    }

    @Override
    public String toString(){
        return "This is " + type + " " + name
                + "\nside a = " + sideA
                + "; side b = " + sideB
                + "; side c = " + sideC
                + "\narea = " + calcArea()
                + "\nperimeter = " + calcPerimeter();
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Triangle triangle = (Triangle)o;
        int [] thisTriangle1 = findMaxMiddleMinSide();
        int [] oTriangle = triangle.findMaxMiddleMinSide();
        return  thisTriangle1[0] == oTriangle[0]
                && thisTriangle1[1] == oTriangle[1]
                && thisTriangle1[2] == oTriangle[2];
    }

    @Override
    public int hashCode(){
        int [] sides = findMaxMiddleMinSide();
        return sides[0]*11 + sides[1]*12 + sides[2]*13;
    }

    private int [] findMaxMiddleMinSide(){
        int max = Math.max(sideA, sideB);
        max = Math.max(max,sideC);

        int min = Math.min(sideA,sideB);
        min = Math.min(min, sideC);

        int middle = (int)calcPerimeter() - min - max;

        return new int[]{max,middle,min};
    }

    private boolean isTriangle(int a, int b, int c){
       return (a > 0 && b > 0 && c > 0 && a + b > c && b + c > a && a + c > b);
    }
}
