public class Circle extends Figure implements Printable{
    double radius;
    public Circle(double r) throws IllegalArgumentException
    {
        if (r<0)throw new IllegalArgumentException("Invalid Parameter");
        this.radius = r;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void print() {
        System.out.println("The radius of a cycle: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}
