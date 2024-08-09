class ShoppingCart {
    private String[] cartContents; 
    private int itemCount; 
    public ShoppingCart(){
        cartContents = new String[50];
        itemCount=0;
    }
    public void setcartcontent(String[] cartContents){ this.cartContents= cartContents;}
    public String[] getcartContent() { return cartContents;}

    public void addtocart(String product) {
        if (itemCount < cartContents.length) {
            cartContents[itemCount] = product;
            itemCount++;
        } else {
            System.out.println("Cart is full. Cannot add more items.");
        }
    } //should not use while loop
    
    public void removefromcart(String product) {
        for (int i = 0; i < itemCount; i++) {
            if (cartContents[i].equals(product)) {
                for (int j = i; j < itemCount - 1; j++) {
                    cartContents[j] = cartContents[j + 1];
                } //lay cai sau i de len i bang j
                itemCount--;
                cartContents[itemCount] = null;
                return;
            }
        }
    }
    

    public void checkout(){
        for  (int i=0;i<itemCount;i++) {
            System.out.println( cartContents[i]);
        }
    }
}
public class ex4_shoppingcart {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();         
        cart.addtocart("hihii");
        cart.addtocart("hehe");
        cart.addtocart("tehe");
        cart.checkout();
        cart.removefromcart("tehe");
        cart.checkout();
      }    }
