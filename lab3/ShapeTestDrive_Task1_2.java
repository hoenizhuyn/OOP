class Object {   
}
abstract class Shape extends Object {
	public double calArea(){
		return 0.0;
	}
	public double calVolume(){
		return 0;
	}
	public abstract String getName();
}

class Point extends Shape {
    protected double x, y;
    //constructer method
    public Point(double x, double y){
        this.x = x;
        this.y = y;
	}
    public String getName(){
		return "Point";
	}
}
class Circle extends Point {
    protected double rc;
    public Circle(double radius, double x, double y){
        super(x,y);  
        rc=radius;
    }
    public double calArea(){
		if (rc>=0.0){
            return Math.PI*rc*rc;
        }
        else{
            return 0.0;
        }
	}
	public String getName(){
        return "Circle";
    }
}

class Cylinder extends Circle{
    protected double height;
    //constructor
    public Cylinder(double height, double radius, double x, double y){
        super(x,y,radius);
        this.height=height;
    }
    public double calArea(){
        if (this.rc>0 && this.height>0){
            return 2*Math.PI*Math.pow(rc, 2) + 2*Math.PI*rc*height;
        } else {
            return 0.0;
        }

    }
    public double calVolume(){
		if (this.rc>0 && this.height>0){
            return Math.PI*rc*rc*height;
        }
        else{
            return 0.0;
        }
	}
	public String getName(){
        return "Cylinder";
    }
}

public class ShapeTestDrive_Task1_2 {
    public static void main(String[] args) {
        Shape shape_array[]= new Shape[3];
        shape_array[0] = new Point(1, 2);
        shape_array[1] = new Circle(3, 4, 5.0);
        shape_array[2] = new Cylinder(6, 7, 8.0, 9.0);
        for (int i=0; i<shape_array.length; i++) {
            System.out.println("Shape type is: "+ shape_array[i].getName());
            if (shape_array[i].calArea()==0.0){
                System.out.println("The area of this shape is 0");
            } else { System.out.println(" Area: "+ shape_array[i].calArea());}
            if (shape_array[i].calVolume()==0.0){
                System.out.println("The volume of this shape is 0");
            } else { System.out.println(" Volume: "+ shape_array[i].calVolume());}     
    }
}
}
