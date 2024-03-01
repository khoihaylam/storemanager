import java.util.Scanner;
public class instore {
    Scanner sc=new Scanner(System.in);
    store[] arrstore=new  store[100];
    int n;
    int index=0;
    public void input(){
        System.out.println("MOI BAN NHAP So luong:");
        n=sc.nextInt();
        arrstore=new store[n];
        for(int i=0;i<n;i++){
            arrstore[index]=new store();
            arrstore[index].input(sc,arrstore,index);
            index++;
        }
    }
    public void output(){
        for(int i=0;i<index;i++){
            arrstore[i].output();
        }
    }
    public void profit(){
        for(int i=0;i<index;i++){
            System.out.println(arrstore[i].getProfit());
        }
    }
    public void sort(){
        store temp;
        for(int i=0;i<index-1;i++){
            for(int j=i+1;j<index;j++){
                if(arrstore[i].getProfit()<arrstore[j].getProfit()){
                    temp=arrstore[i];
                    arrstore[i]=arrstore[j];
                    arrstore[j]=temp;
                }
            }
        }
    }
    public void searchName(){
        sc.nextLine();
        System.out.println("MOI ban nhap ten muon tim:");
        String name=sc.nextLine();
        int check=-1;
        for(int i=0;i<index;i++){
            if(arrstore[i].getproductName().equals(name)){
                check=i;
            }
        }
        if(check==-1){
            System.out.println("khong tim thay");
        }
        else{
            for(int i=0;i<index;i++){
                if(check==i){
                    arrstore[i].output();
                }
            }
        }
    }
    public void updateStatus(){
        sc.nextLine();
        System.out.println("Moi ban nhap ma san pham muon cap nhat:");
        String productId=sc.nextLine();
        int update=findproductId(productId);
        if(update>=0){
            arrstore[update].setStatus(!arrstore[update].isStatus());
        }
        else{
            System.err.println("ma san pham khong ton tai:");
        }
    }
    public int findproductId(String productId){
        for(int i=0;i<index;i++){
            if(arrstore[i].getproductId().equals(productId)){
                return i;
            }
        }
        return -1;
    }
    public void sellproduct(){
        sc.nextLine();
        System.out.println("moi ban nhập sản phẩm muốn mua:");
        String productName=sc.nextLine();
        int sell=findproductName(productName);
        if(sell>=0){
            if(arrstore[sell].isStatus()){
                System.out.println("moi ban nhap so luong:");
                int quantity=sc.nextInt();
                int updatequantity=arrstore[sell].getQuantity()-quantity;
                arrstore[sell].setQuantity(updatequantity);
                if(arrstore[sell].getQuantity()==0){
                    arrstore[sell].setStatus(!arrstore[sell].isStatus());
                }
                else if(arrstore[sell].getQuantity()<0){
                    System.err.println("so luong mua khong duoc nho hon 0");
                    arrstore[sell].setQuantity(1);
                    arrstore[sell].setStatus(arrstore[sell].isStatus());
                }
                else{
                    arrstore[sell].setStatus(arrstore[sell].isStatus());
                }

            }
            else{
                System.out.println("san pham nay khong ban");
            }
        }
        else{
            System.out.println("TEN SAN PHAM KHONG TON TAI");
        }
    }
    public void importprice() {
        System.out.println("moi ban nhập ten  sản phẩm muốn mua:");
        String productName = sc.nextLine();
        sc.nextLine();
        int update = findproductName(productName);
        if (update >= 0) {
            System.out.println("moi ban nhap so luong:");
            int quantity=sc.nextInt();
            if(quantity>0){
                int updatequantity=arrstore[update].getQuantity()+quantity;
                arrstore[update].setQuantity(updatequantity);
                if(arrstore[update].getQuantity()!=0){
                    if(arrstore[update].isStatus()){
                        arrstore[update].setStatus(arrstore[update].isStatus());
                    }
                    else{
                        arrstore[update].setStatus(!arrstore[update].isStatus());
                    }
                }
                else{
                    System.err.println("san pham chua cap nhat gia");
                }
            }
            else{
                System.err.println("SO LUONG PHAI LON HON 0");
            }

        } else {
            System.err.println("ten san pham khong ton tai:");
        }
    }
    public int findproductName(String productName){
        for(int i=0;i<index;i++){
            if(arrstore[i].getproductName().equals(productName)){
                return i;
            }
        }
        return -1;
    }
    public void recepice(){
        int count=0;
        System.out.println("moi ban nhap gia a");
        int a=sc.nextInt();
        System.out.println("moi ban nhap gia b");
        int b=sc.nextInt();
        for(int i=0;i<index;i++){
            if(arrstore[i].getExportPrice()>a&&arrstore[i].getExportPrice()<b){
                count++;
                arrstore[i].output();
            }
        }
        if(count==0){
            System.out.println("khong ton tai trong gia khoang a-b");
        }
        else{
            System.out.printf("có %d sản phẩm trong gia tu a-b",count);
            System.out.println();
        }
    }
}
