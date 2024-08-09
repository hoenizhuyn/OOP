class vector{
    private int x;
    private int y;
    public vector(int x, int y){ this.x =x; this.y=y; } //constructor
    public void setx(int x){this.x= x;}
    public void sety(int y){this.y= y;}
    public int getx(){return x;}
    public int gety(){ return y;}

    public void add(vector other){
        this.x +=  other.getx();
        this.y +=  other.gety();
        System.out.println("Addition result:(" +this.x+ "," +this.y +")");
    }
    public vector substract(vector other){
        return new vector(this.x-other.getx(),  this.y-other.gety());
    } // need constructor for this!!!!!!!

    public vector  multiply (int multiplier) {
        return new vector(this.x * multiplier, this.y * multiplier);
    }

    public double dotProduct(vector other) {
        return (this.x * other.getx() + this.y*other.gety()) ;
    }
}
public class Vectortestdrive {
    public static void main(String[] args){
        vector v1= new vector(3,4);
        vector v2= new vector(8, 9);
        vector v3 = v2.substract(v1);
        System.out.println("Substraction result:" + "(" +v3.getx() +"," +v3.gety()+ ")");
        System.out.println("Mulplication result:" + "(" + v1.multiply(2).getx() +","+v1.multiply(2).gety() + ")" );
        v1.add(v2); //v1 change at this point

    }
}
