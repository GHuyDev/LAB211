/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package short80;

/**
 *
 * @author Huyb
 */
public class Tetrahedron extends ThreeDimensionalShape{
    private double edge;

    public Tetrahedron(double edge) {
        this.edge = edge;
    }
    
    public double getArea(){
        return Math.sqrt(3) * edge * edge;
    }
    
    public double getVolume(){
        return (1.0/12) * Math.sqrt(2) * Math.pow(edge, 3);
    }
}
