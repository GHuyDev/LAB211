/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package short80;

/**
 *
 * @author Huyb
 */
public class Circle extends TwoDimensionalShape {
    private double radius;
    
    public Circle(double radius){
        this.radius = radius;
    }
    
    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }
    
    @Override
    public String toString(){
        return "Circle [radius =" + radius +"]";
    }
}
