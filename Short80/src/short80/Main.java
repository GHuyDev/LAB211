package short80;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** SHAPE PROGRAM ***");

        Shape[] shapes = new Shape[6];

        // 2D Shapes
        shapes[0] = new Circle(3);
        shapes[1] = new Square(4);
        shapes[2] = new Triangle(3, 4, 5);

        // 3D Shapes
        shapes[3] = new Sphere(2);
        shapes[4] = new Cube(3);
        shapes[5] = new Tetrahedron(2);

//        double circleRadius = Validator.getPositiveDouble("Enter radius of Circle: ");
//        shapes[0] = new Circle(circleRadius);
//        
//        double squareSide = Validator.getPositiveDouble("Enter side of Square: ");
//        shapes[1] = new Square(squareSide);
//        
//        double sideA = Validator.getPositiveDouble("Enter side A of Triangle: ");
//        double sideB = Validator.getPositiveDouble("Enter side B of Triangle: ");
//        double sideC = Validator.getPositiveDouble("Enter side C of Triangle: ");
//        shapes[2] = new Triangle(sideA, sideB, sideC);
//        
//        double sphereRadius = Validator.getPositiveDouble("Enter radius of Sphere: ");
//        shapes[3] = new Sphere(sphereRadius);
//
//        double cubeEdge = Validator.getPositiveDouble("Enter edge of Cube: ");
//        shapes[4] = new Cube(cubeEdge);
//
//        double tetraEdge = Validator.getPositiveDouble("Enter edge of Tetrahedron: ");
//        shapes[5] = new Tetrahedron(tetraEdge);

        System.out.println("\n==== RESULTS ====");
        for (Shape s : shapes) {
            System.out.println(s);

            if (s instanceof TwoDimensionalShape) {
                System.out.printf("Type: 2D Shape | Area = %.2f%n", s.getArea());
            } else if (s instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape threeD = (ThreeDimensionalShape) s;
                System.out.printf("Type: 3D Shape | Area = %.2f | Volume = %.2f%n",
                        threeD.getArea(), threeD.getVolume());
            }
            System.out.println();
        }
    }
}
