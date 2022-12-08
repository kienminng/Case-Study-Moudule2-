package Main;

import ProductManager.ProductManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class clientCartModal {
    static ProductManager productManager= new ProductManager();
    static Scanner scanner =new Scanner(System.in);
    public void clientCartModal(String account){
        int choiceCase3 =-1;
        while (true) {
            System.out.println("---------------------------");
            System.out.println("1.tiếp tục mua");
            System.out.println("2.Chốt đơn");
            System.out.println("3.Edit lại sản phẩm");

            while (true) {
                try {
                    choiceCase3 = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e){
                    System.out.println("nhập lại bằng số\n");
                }
            }
            if (choiceCase3==2) {
                productManager.bill(account);
                break;
            } else if (choiceCase3 ==1 ) {
                System.out.println("ok");
                break;
            } else if (choiceCase3==3){
                int choiceEdit = -1;
                System.out.println("1.xoá sản phẩm phẩm");
                System.out.println("2.sửa số lượng sản phẩm\n");
                do {
                    try {
                        choiceEdit = Integer.parseInt(scanner.nextLine());
                        break;

                    } catch (InputMismatchException e){
                        System.out.println("phải nhập số");
                    }
                } while (true);
                System.out.println("nhập tên sản phẩm truy xuất đến");
                String nameEdit = scanner.nextLine();
                int indexAcc = productManager.findIndexByName(account);
                int indexCart = productManager.findCartNameEditClient(nameEdit,indexAcc);
                if ( indexCart !=-1) {
                    switch (choiceEdit) {
                        case 1:
                            productManager.deleteSPClient(account,nameEdit);
                            break;
                        case 2:
                            productManager.editAmountSPCliet(account,nameEdit);
                            break;
                        default:
                            System.out.println("ko có chức năng này");
                            break;
                    }

                } else {
                    System.out.println("trong giỏ hàng không có sản phẩm này");
                }
            }
        }
    }
}
