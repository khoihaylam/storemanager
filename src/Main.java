import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        instore out=new instore();
        System.out.println("Hello world!");
        do {
            System.out.println();
            System.out.println("********************STOREMANAGER*************************");
            System.out.println("1.nhap thong tin san pham");
            System.out.println("2.xuat thong tin san pham");
            System.out.println("3.Tinh loi nhuan san pham");
            System.out.println("4.sap xep san pham:");
            System.out.println("5.Tim kiem san pham");
            System.out.println("6.bán sản phẩm");
            System.out.println("7.nhap san pham");
            System.out.println("8.thong ke san pham theo gia");
            System.out.println("9.cap nhat trang thai san pham");
            System.out.println("MOI ban nhap chuc nang menu:");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    out.input();
                    break;
                case 2:
                    out.output();
                    break;
                case 3:
                    out.profit();
                    break;
                case 4:
                    out.sort();
                    break;
                case 5:
                    out.searchName();
                    break;
                case 6:
                    out.sellproduct();
                    break;
                case 7:
                    out.importprice();
                    break;
                case 8:
                    out.recepice();
                    break;
                case 9:
                    out.updateStatus();
                    break;
                case 10:
                    System.exit(0);
            }



        }while (true);
    }
}