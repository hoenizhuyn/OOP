public class Automobile { 
    // class variables  
    double fuel; 
    double speed;      
    String license; 
    void init(double f, double s, String l) { 
        fuel =  f; 
        speed = s; 
        license = l; 
    } 
    //class methods (static) have direct access to the class members 
    // and only be accessed by other static ones.
    void accelerate(double v) { 
             if (fuel > 0) speed += v; 
    } 
    void decelerate(double v) { 
             if (fuel <= 0) speed -= v; 
    } 
    public static void main(String args[]) { 
     Automobile car = new Automobile(); 
     car.init(4.5,34, "29JAD");
     car.accelerate(4); 
     car.decelerate(5); 
     System.out.println("License Plate: " + car.license);
     System.out.println("Current Speed: " + car.speed);
     System.out.println("Current Fuel: " + car.fuel);
    } 
    }

