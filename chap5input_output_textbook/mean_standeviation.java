import java.util.Scanner;
class NumberList {
    private Double[] list;
    private int count;

    public NumberList() {
        list = new Double[100];
        count = 0;
    }

    public void setList(Double[] list) {
        this.list = list;
    }

    public Double[] getList() {
        return this.list;
    }
    public void addToList(Double number){
        if (count <  list.length) {
            list [count] = number ;
            count++;}}

    public double mean() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += list[i];
        }
        return sum / count;
    }

    public double standardDeviation() {
        double sumSquaredDiff = 0;
        for (int i = 0; i < count; i++) {
            sumSquaredDiff += Math.pow(list[i] - mean(), 2);
        }
        double stddevi = Math.sqrt(sumSquaredDiff / (count - 1));
        return stddevi;
    }
}

public class mean_standeviation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = scanner.nextInt();
        NumberList numberList = new NumberList();

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            double num = scanner.nextDouble();
            numberList.addToList(num);
        }
        scanner.close();
        System.out.println("Mean: " + numberList.mean());
        System.out.println("Standard Deviation: " + numberList.standardDeviation());
    }
}
