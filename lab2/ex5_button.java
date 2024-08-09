class button{
    private String label;
    private String color;
    public button(String l, String c){
        this.label = l;
        this.color = c;
    }
    public void setlabel(String l){this.label= l;}
    public String getlabel(){return this.label;}
    public void setcolor(String c) {this.color =c;} 
    public String getcolor() { return this.color;}
    public void dePress(){
        System.out.println(label + ", " + color + " Depressed!");
    }

    public void unDepress(){
        System.out.println(label + ", " + color + " unDepressed!");
    }
}
public class ex5_button {
    public static void main(String arg[]){
        button b1 = new button("Lights", "Red");
        button b2 = new button("Cook", "Green");
        
        b1.dePress();
		b2.unDepress();
    }
}
