public class Triangle extends Figure implements Printable{
    double x,y,z;
    public Triangle(double x, double y, double z) {

        if (!((x+y>z) && (x+z>y) && (y+z>x))) throw new IllegalArgumentException("Invalid Parameter");

        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    double calculateArea() {
        double area = 0;
        double p =(x+y+z)/2;
        area = Math.sqrt(p*(p-x)*(p-y)*(p-z));
        return area;
    }

    @Override
    double calculatePerimeter() {
        return x+y+z;
    }

    @Override
    public void print() {
        System.out.println("The sides of a triangle: " + x + ", " + y + ", " + z);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}
