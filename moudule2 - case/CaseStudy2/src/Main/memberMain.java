package Main;

import ProductManager.ProductManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class memberMain {
    static ProductManager productManager = new ProductManager();
    static Scanner scanner = new Scanner(System.in);
    public void memberWindown(String name,String pass) {
        int choiceCart = -1;
        while (choiceCart!=0) {
            System.out.println(" _____________trung tâm hỗ trợ khách hàng______________");
            System.out.println("|       1.xem danh mục sản phẩm                        |");
            System.out.println("|       2.mua sản phẩm                                 |");
            System.out.println("|       3.xem giỏ hàng                                 |");
            System.out.println("|       0.exit                                         |");
            System.out.println("|______________________________________________________|");

            while (choiceCart!=0) {
                try {
                    choiceCart = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("phải nhập số");
                }
            }
            switch (choiceCart) {
                case 1:
                    productManager.showSP();
                    break;
                case 2:
                    int amount;
                    String nameSP;
                    int choice =-1 ;
                    while (true) {
                        System.out.println("nhập tên sản phẩm ");
                        nameSP = scanner.nextLine();
                        int index = productManager.findIndexCartByName(nameSP);
                        if (index ==-1) {
                            System.out.println("tên sản phẩm ko tồn tại \n");

                            System.out.println("0.exit");
                            System.out.println("1.nhập lại");
                            while (true) {
                                try {
                                    choice = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (Exception e){
                                    System.out.println("phải nhập số");
                                }
                            }
                            if (choice==0){
                                break;
                            } else if (choice==-1) {
                                System.out.println("ok\n");
                            }
                        } else {
                            while (true) {
                                try {
                                    System.out.println("nhập số lượng sản phẩm");
                                    amount = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (Exception e){
                                    System.out.println("phải nhập số");
                                }
                            }
                            productManager.buy(nameSP,amount,name);
                            break;
                        }
                    }
                    break;
                case 3:
                    productManager.showClientCart(name);
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
