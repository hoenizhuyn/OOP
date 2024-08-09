class Cow {
    private int age;
    private String breed;

    public void set_age(int age) {
        this.age = age;
    }
    
    public void set_breed(String breed) {
        this.breed = breed;
    }
    public int get_age() {
        return age;
    }
    public String get_breed() {
        return breed;
    }
    public void moo() {
        System.out.println("Moo...!");
    }
}
public class ex2_CowTestDrive {
    public static void main(String[] args) {
        Cow myCow = new Cow();

        myCow.set_age(4);
        myCow.set_breed("Bison");
        myCow.moo();

        System.out.println("Cow Breed: " + myCow.get_breed());
        System.out.println("Cow Age: " + myCow.get_age());
    }
}