
package short61;

public class Main {

    public static void main(String[] args) {
        System.out.println("=====Calculator Shape Program=====");

        // Rectangle
        double width = Validator.getDouble("Please input side width of Rectangle: ");
        double length = Validator.getDouble("Please input length of Rectangle: ");
        Rectangle rect = new Rectangle(width, length);

        // Circle
        double radius = Validator.getDouble("Please input radius of Circle: ");
        Circle circle = new Circle(radius);

        // Triangle
        double sideA = Validator.getDouble("Please input side A of Triangle: ");
        double sideB = Validator.getDouble("Please input side B of Triangle: ");
        double sideC = Validator.getDouble("Please input side C of Triangle: ");
        Triangle tri = new Triangle(sideA, sideB, sideC);

        // Print results
        System.out.println();
        
        rect.printResult();
        
        circle.printResult();
        
        tri.printResult();
    }
}
