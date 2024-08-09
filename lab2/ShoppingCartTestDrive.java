import java.util.*;
class ShoppingCart{
  private ArrayList<String> cartContents;
  public ShoppingCart(){
    this.cartContents = new ArrayList<>();
  }
  public void setcart(ArrayList<String> cartContents){ this.cartContents= cartContents; }
  public  ArrayList<String> getcart() { return this.cartContents;}
  
  public void addToCart(String product){
    cartContents.add(product);
  }
  public void removeFromCart(String product){
    cartContents.remove(product);
  }

  public void checkOut(){
    // for  (String eachitem : cartContents){
    //   System.out.println(eachitem); }
    System.out.println("Checkout: " );
    System.out.println(cartContents);
  }}
public class ShoppingCartTestDrive {
        public static void main(String[] args) {
          ShoppingCart cart = new ShoppingCart();         
          cart.addToCart("Iphone");
          cart.addToCart("Samsung");
          cart.addToCart("Xiaomi");
          cart.checkOut();
          cart.removeFromCart("Samsung");
          cart.checkOut();
        }
      }