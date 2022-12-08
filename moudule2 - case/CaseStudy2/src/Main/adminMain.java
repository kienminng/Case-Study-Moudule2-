package Main;

import ProductManager.ProductManager;

import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Scanner;

public class adminMain {
    static Scanner scanner = new Scanner(System.in);
    static ProductManager productManager = new ProductManager();
    public void adminWindown(String name, String pass) {
        System.out.println("  welcome back master  ");
        int choice = -1;
        while (choice != 0) {
            System.out.println(" ______________MENu______________");
            System.out.println("|  [1].danh sách khách hàng      |");
            System.out.println("|  [2].delete Client             |");
            System.out.println("|  [3].danh sách sản phẩm        |");
            System.out.println("|  [4].thêm sản phẩm             |");
            System.out.println("|  [5].xoá sản phẩm              |");
            System.out.println("|  [6].sửa sản phẩm              |");
            System.out.println("|  [7].Khách hàng của tháng      |");
            System.out.println("|  [8].tổng doanh thu            |");
            System.out.println("|  [0].exit                      |");
            System.out.println("|________________________________|");
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("phải nhập số");
                }
            } while (true);

            switch (choice) {
                case 1:
                    productManager.showClient();
                    break;
                case 2:
                    System.out.println("nhập tên khách hàng cần xoá");
                    String nameCL= scanner.nextLine();
                    productManager.delete(nameCL);
                    break;
                case 3:
                    productManager.showSP();
                    break;
                case 4:
                    System.out.println("nhập tên sp");
                    String nameSP = scanner.nextLine();
                    int amount ;
                    do {

                        try {
                            System.out.println("nhập số lượng sản phẩm");
                            amount = Integer.parseInt(scanner.nextLine());
                            if (amount<0) {
                                System.out.println("số lượng ko hợp lí");
                            } else {
                                break;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("phải nhập số");
                        }
                    }while (true);

                    double price;
                    do {
                        try {
                            System.out.println("nhập giá sản phẩm");
                            price = Double.parseDouble(scanner.nextLine());
                            if (price<0){
                                System.out.println("bảng giá ko hợp lí ");
                            } else {
                                break;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("sai kiểu dữ liệu");
                        }
                    } while (true);
                    productManager.addSP(nameSP,amount,price);
                    break;
                case 5:
                    System.out.println("nhập tên sản phẩm");
                    String nameDeleteSP = scanner.nextLine();
                    productManager.deleteCart(nameDeleteSP);
                    break;
                case 6:
                    System.out.println("nhập tên sản phẩm muốn sửa");
                    String nameSPEdit = scanner.nextLine();
                    productManager.editCart(nameSPEdit);
                    break;
                case 7:
                    productManager.topClientOfMonth();
                    break;
                case 8:
                    productManager.allOfMoney();
                    break;
                case 0:
                    System.out.println("đăng xuất thành công");
                    break;
                default:
                    System.out.println("ko có chức năng này");
                    break;
            }
        }
    }
}
