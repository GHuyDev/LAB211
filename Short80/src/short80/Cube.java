/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package short80;

/**
 *
 * @author Huyb
 */
public class Cube extends ThreeDimensionalShape{
    private double edge;

    public Cube(double edge) {
        this.edge = edge;
    }
    
    @Override
    public double getArea(){
        return 6 * edge * edge;
    }
    
    @Override
    public double getVolume(){
        return Math.pow(edge, 3);
    }
    
    @Override
    public String toString(){
        return "Cube [edge =" + edge + "]"; 
    }
}
