public class Prism extends Figure implements Printable {
    double height;
    Figure base;

    public Prism(Figure base, double height) {
        if (height<0) throw new IllegalArgumentException("Invalid Parameter");
        this.height = height;
        this.base = base;
    }

    @Override
    double calculateArea() {
        return 2 * base.calculateArea() + base.calculatePerimeter() * height;
    }

    @Override
    double calculatePerimeter() { return 0; }

    double volume() {
        return base.calculateArea() * height;
    }

    @Override
    public void print() {
        System.out.println("Height: " + height);
        System.out.println("Surface area of a prism: " + calculateArea());
        System.out.println("Volume of a prism: " + volume());
    }
}
