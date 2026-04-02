class Shapes {
    double area;

    // Constructor Overloading
    Shapes(double side) { // Square
        area = side * side;
        System.out.println("Area of Square: " + area);
    }

    Shapes(double length, double breadth) { // Rectangle
        area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }

    Shapes(double radius, boolean isCircle) { // Circle
        area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    // Method Overloading
    void area(int side) {
        System.out.println("Area of Square (method): " + (side * side));
    }

    void area(int length, int breadth) {
        System.out.println("Area of Rectangle (method): " + (length * breadth));
    }

    void area(double radius) {
        System.out.println("Area of Circle (method): " + (3.14 * radius * radius));
    }
}

class ShapesDemo {
    public static void main(String[] args) {
        // Constructor Overloading
        Shapes s1 = new Shapes(4);              // Square
        Shapes s2 = new Shapes(5, 3);           // Rectangle
        Shapes s3 = new Shapes(2.5, true);      // Circle

        System.out.println();

        // Method Overloading
        Shapes s = new Shapes(1); // dummy object
        s.area(6);
        s.area(7, 2);
        s.area(3.5);
    }
}