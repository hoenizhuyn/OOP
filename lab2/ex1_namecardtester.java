class namecard{
    private String name;
    private String phone;
    private String email;
    //setter
    public void setname(String name){
        this.name=name;
    }
    public void setphone(String phone){
        this.phone=phone;
    }
    public void setemail(String email){
        this.email=email;
    }
    //getter
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public String geteMail(){return email;}
}
public class ex1_namecardtester{
    public static void main(String args[]) {
		namecard c1 = new namecard();
		namecard c2 = new namecard();
	
		c1.setname("huyen");
		c1.setphone("0000000");
		c1.setemail("uncle@gmail.com");
		
		c2.setname("khai ngoo nhu cho");
		c2.setphone("999999");
		c2.setemail("khain@gmail.com");
		
		
		System.out.println("name: " + c1.getName());
		System.out.println("Phone: " + c1.getPhone());
		System.out.println("Email: " + c1.geteMail());
	
		System.out.println("\nname: " + c2.getName());
		System.out.println("Phone: " + c2.getPhone());
		System.out.println("Email: " + c2.geteMail());
		
		
	}
}