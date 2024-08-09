// q16 page 209
import java.util.Scanner;

class point{
    private double x;
    private double y;

    public point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double get_x() {
        return x;
    }

    public void set_x(double x) {
        this.x = x;
    }

    public double get_y() {
        return y;
    }

    public void set_y(double y) {
        this.y = y;
    }
    public double euDis(point otherpoint){
        return Math.sqrt(((this.x-otherpoint.get_x())*(this.x-otherpoint.get_x())-(this.y-otherpoint.get_y())*(this.y-otherpoint.get_y())));
    }

}
class euclideanDistance{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        int pointcount = scn.nextInt();
        point []points=new point[pointcount];
        for  (int i = 0; i < points.length; i++) {
            System.out.println("Point " + (i+1) + ":");
            System.out.print("X: ");
            double x = scn.nextDouble();
            System.out.print("Y: ");
            double y = scn.nextDouble();
            points[i] = new point(x,y);}
        System.out.println("The distance between point("+points[0].get_x()+"," +points[0].get_y()+" )and point("+points[1].get_x()+"," +points[1].get_y()+ ")is "+points[0].euDis(points[1]));
        scn.close();  // closing the scanner to avoid memory leak
    }
    
}