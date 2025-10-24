/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package short80;

/**
 *
 * @author Huyb
 */
public class Triangle extends TwoDimensionalShape{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        double p = (sideA + sideB + sideC) / 2; 
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
    
    @Override
    public String toString() {
        return "Triangle [A=" + sideA + ", B=" + sideB + ", C=" + sideC + "]";
    }
}