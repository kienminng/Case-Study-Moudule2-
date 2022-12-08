package Main;

import ProductManager.ProductManager;

import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner =new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        productManager.readFile();
        productManager.readAdmin();
        productManager.readTopClient();

        int choice =-1;
        while (choice!=0) {

            System.out.println("_______menu________ ");
            System.out.println("|  [1].Login       |");
            System.out.println("|  [2].Đăng kí     |");
            System.out.println("|  [0].exit        |");
            System.out.println(" ------------------ ");


            while (true){
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;

                } catch (Exception e){
                    System.out.println("phải nhập số");
                }
            }

            switch (choice) {
                case 1:
                    System.out.print("nhập account: ");

                    String account = scanner.nextLine();

                    System.out.print("nhập password: ");

                    String password = scanner.nextLine();

                    productManager.Login(account, password);
                    break;

                case 2:
                    System.out.print("nhập tên: ");
                    String name = scanner.nextLine();

                    String acc;
                    System.out.println("tài khoản phải có từ 6 đến 16 kí tự");
                    while (true) {
                            System.out.print("nhập tên account: ");
                            acc = scanner.nextLine();
                            Pattern pattern = Pattern.compile("^([A-Za-z0-9]+){5,15}$");
                            if (pattern.matcher(acc).find()){
                                break;
                            } else {
                                System.out.println(" tài khoản ít nhất phải có 6 kí tự");
                            }
                    }

                    String pass ;
                    System.out.println("Mật khẩu phải có từ 8 đến 16 kí tự");
                    while (true) {

                        System.out.print("nhâp pass: ");

                         pass = scanner.nextLine();
                        Pattern pattern = Pattern.compile("^[A-Z]([A-Za-z0-9]+){7,15}$");
                        if (pattern.matcher(pass).find()){
                            break;
                        } else {
                            System.out.println("mật khẩu ko đạt yêu cầu phải có ít nhất 8 ký tự");

                        }
                    }


                    int day=0;
                    do {
                        try {
                            System.out.print("nhập ngày sinh: ");
                            day =Integer.parseInt(scanner.nextLine());
                            if (day>31 || day<1){
                                System.out.println("ngày sinh này ko hợp lệ");
                            } else {
                                break;
                            }

                        } catch (Exception e) {
                            System.out.println("phải nhập số");
                        }
                    }while (true);



                    int month = 0;
                    do {
                        try {
                            System.out.print("tháng: ");
                            month = Integer.parseInt(scanner.nextLine());
                            if (month<1 || month>12) {
                                System.out.println("Nhập tháng sai");
                            } else {
                                break;
                            }

                        }catch (Exception e){
                            System.out.println("phải nhập số");
                        }
                    }while (true);

                    int year = 0 ;
                    do {
                        try {
                            System.out.print("năm: ");
                            year = Integer.parseInt(scanner.nextLine());
                            if (year<1922 || year>2011){
                                System.out.println("Năm sinh không hợp lệ");
                            } else {
                                break;
                            }

                        } catch (Exception e) {
                            System.out.println("phải nhập số");
                        }
                    }while (true);


                    LocalDate date = LocalDate.of(year, month, day);

                    String[] gender = {"nam","nữ"};

                    System.out.print("nhập giới tính: ");

                    String genderInput = scanner.nextLine();

                    productManager.createMember(name, acc, pass, date, genderInput);
                    break;

                case 0:
                    productManager.writeFile();
                    productManager.writeAdmin();
                    productManager.writeTopClient();
                    System.out.println("Thoát khỏi chương trình thành công");
                    break;

                default:
                    System.out.println("ko có tính năng này");
                    break;
            }
        }
    }
}