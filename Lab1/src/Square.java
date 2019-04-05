public class Square extends Figure implements Printable {
    double radius;
    public Square(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Invalid Parameter");
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 4* radius;
    }

    @Override
    public void print() {
        System.out.println("The side length of a square: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: "+ calculatePerimeter());
    }
}
