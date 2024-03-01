import java.util.Scanner;
public class ucln {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("MOI BAN nhap a:");
        int a=sc.nextInt();
        System.out.println("MOI BAN nhap b:");
        int b=sc.nextInt();
        while (a!=b){
            if(a>b){
                a=a-b;
            }
            else {
                b = b - a;
            }
        }
        System.out.println(a);


    }
}
