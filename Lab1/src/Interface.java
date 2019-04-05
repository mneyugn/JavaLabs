import java.util.Scanner;


public class Interface {

    public static void chooseFigure(){
        boolean prism = false;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a figure");
            System.out.println("1. Square");
            System.out.println("2. Circle");
            System.out.println("3. Triangle");
            if(!prism) {
                System.out.println("4. Prism");
            }

            System.out.println("5. Exit");

            double arg;
            int select = scanner.nextInt();

            switch (select) {
                case 1:                                                   //Square
                    System.out.println("Enter the side of the square");
                    arg = scanner.nextDouble();
                    try {
                        Square s = new Square(arg);
                        if (prism)                                        //if Prism
                        {
                            makePrism(s);
                        } else
                            s.print();
                    } catch (IllegalArgumentException e)          // if side < 0
                    {
                        System.out.println(e.getMessage());
                    }
                    return;

                case 2:                                                    //Circle
                    System.out.println("Enter the radius of the circle");
                    arg = scanner.nextDouble();
                    try {
                        Circle c = new Circle(arg);
                        if (prism)                                        //if Prism
                        {
                            makePrism(c);
                        } else
                            c.print();
                    } catch (IllegalArgumentException e)            // if radius < 0
                    {
                        System.out.println(e.getMessage());
                    }
                    return;

                case 3:                                                   //Triangle
                    System.out.println("Enter 3 sides of triangle");
                    double s1, s2, s3;

                    System.out.print("A: ");
                    s1 = scanner.nextDouble();
                    System.out.print("B: ");
                    s2 = scanner.nextDouble();
                    System.out.print("C: ");
                    s3 = scanner.nextDouble();
                    try {
                        Triangle t = new Triangle(s1, s2, s3);
                        if (prism)                                        //if Prism
                        {
                            makePrism(t);
                        } else t.print();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    return;

                case 4:
                    prism = true;
                    System.out.println("which figure is the base of the prism");
                    break;

                case 5:                                                   //Exit
                    return;

                default:
                    System.out.println("Invalid argument! Try again");
            }
        }
    }

    public static void makePrism(Figure s)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the height");
        double height = scanner.nextDouble();
        Prism p = new Prism(s,height);
        p.print();
    }
}
