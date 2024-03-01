import java.util.Scanner;
public class store {
    private String productId;
    private String productName;
    private double importPrice;
    private double exportPrice;
    private double profit;
    private int quantity;
    private String description;
    private boolean status;
    public store() {
    }

    public store(String productId,String productName,double importPrice,double exportPrice,double profit,int quantity,String description,boolean status) {
        this.productId = productId;
        this.productName=productName;
        this.importPrice=importPrice;
        this.exportPrice=exportPrice;
        this.profit=profit;
        this.quantity=quantity;
        this.description=description;
        this.status=status;
    }

    public String getproductId() {
        return productId;
    }

    public void setproductId(String productId) {
        this.productId = productId;
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void input(Scanner scanner,store[] arrstore,int index){
        this.productId=inputproductId(scanner,arrstore,index);
        scanner.nextLine();
        this.productName=inputproductName(scanner,arrstore,index);
        scanner.nextLine();
        this.importPrice=inputproducePrice(scanner);
        this.exportPrice=inputexportPrice(scanner);
        this.profit=inputprofit();
        this.quantity=inputquantity(scanner);
        this.description=inputdescription(scanner);
        this.status=inputstatus(scanner);
    }
    public String inputproductId(Scanner scanner,store[] arrstore,int index){
        scanner.nextLine();
        System.out.println("MOI BAN NHAP MA san pham:");
       do {
           String productId=scanner.nextLine();
           if(productId.length()==4){
               if(productId.charAt(0)=='P'){
                   boolean check=false;
                   for(int i=0;i<index;i++){
                       if(arrstore[i].getproductId().equals(productId)){
                           check=true;
                       }
                   }
                   if(check){
                       System.out.println("TEN SAN PHAM DA TON TAI:");
                   }
                   else{
                       return productId;
                   }
               }
               else{
                   System.out.println("ten san pham bat dau co ky tu la P");
               }
           }
           else{
               System.err.println("TEN SAN PHAM CHI CO 4 KY TU");
           }
       }while (true);
    }
    public String inputproductName(Scanner scanner,store[] arrstore,int index){
        System.out.println("MOI BAN NHAP ten san pham:");
        do {
            String productName=scanner.nextLine();
            if(productName.length()>6&&productName.length()<50){
                boolean ischeck01=false;
                for(int i=0;i<index;i++){
                    if(arrstore[i].getproductName().equals(productName)){
                        ischeck01=true;
                    }
                }
                if(ischeck01){
                    System.out.println("TEN SAN PHAM DA TON TAI:");
                }
                else{
                    return productName;
                }
            }
            else{
                System.out.println("ten san pham toi da 6-50 ky tu");
            }
        }while (true);
    }
    public double inputproducePrice(Scanner scanner){
        System.out.println("MOI BAN nhap gia nhap:");
        do {
            double importprice=scanner.nextDouble();
            if(importprice>0){
                return importprice;
            }
            else{
                System.out.println("GIA SAn pham phai lon hon 0");
            }
        }while (true);
    }
    public double inputexportPrice(Scanner scanner){
        System.out.println("moi ban NHAP GIA XUAT");
        do {
            double exportPrice=scanner.nextDouble();
            double p=(importPrice*120)/100;
            if(exportPrice>p){
                return exportPrice;
            }
            else{
                System.out.println("gia xuat phai lon hon gia nhap .vui log nhap lai");
            }
        }while (true);
    }
    public double inputprofit(){
        return exportPrice-importPrice;
    }
    public int inputquantity(Scanner scanner){
        System.out.println("MOI BAN nhap so luong:");
        do {
            int quantity=scanner.nextInt();
            if(quantity>0){
                return quantity;
            }
            else{
                System.out.println("SO LUONG PAHI LON HON 0");
            }

        }while (true);
    }
    public String inputdescription(Scanner scanner){
        return scanner.nextLine();
    }
    public boolean inputstatus(Scanner scanner){
        System.out.println("MOI BAN nhap trang thai san pham:");
        do {
            String status=scanner.nextLine();
            if(status.equals("true")||status.equals("false")){
                return Boolean.parseBoolean(status);
            }
            else{
                System.out.println("CHI NHAP TRUE HOAC FALSE");
            }
        }while (true);
    }
    public void output(){
        System.out.printf("%5s  %5s  %.1f  %.1f  %.1f  %5d  %5s  %5s\n ",this.productId,this.productName,this.importPrice,this.exportPrice,this.profit,this.quantity,this.description,(this.status)?"dang ban":"khong ban");
    }

}
