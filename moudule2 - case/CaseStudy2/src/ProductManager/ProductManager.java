package ProductManager;

import Cart.Cart;
import Person.ClientOfTheMonth;
import Main.adminMain;
import Main.clientCartModal;
import Main.memberMain;
import Person.Person;
import Person.Client;
import topClientOfTheMonth.TopMonth;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ProductManager {
    Scanner scanner =new Scanner(System.in);
    LocalDate date =  LocalDate.of(1999,12,14);
    Person admin = new Person("kien","kien123","123",date,"nam");
    static List<Client> member = new ArrayList<>();

    static List<Cart> carts = new ArrayList<>();

    public void createMember(String name1,String account1,String pass1,LocalDate date1,String gender1){
        List<Cart> cart1 = new ArrayList<>();
        Client client1 = new Client(name1,account1,pass1,date1,gender1,cart1);
        if (admin.getAccount().equals(account1) ){
            System.out.println("tài khoản đã tồn tại ");
        }else {
            for (int i = 0; i < member.size(); i++) {
                if (member.get(i).getAccount().equals(account1)){
                    System.out.println("tên tài khoản đã tồn tại làm ơn đăng kí lại");
                    return;
                }
            }
            member.add(client1);
            System.out.println("tài khoản khách hàng đã được thêm thành công");
            System.out.println(member);
        }
    }
    static ArrayList<ClientOfTheMonth> topMonth = new ArrayList<>();
     static TopMonth topMonth1 = new TopMonth();
    public void topClientOfMonth() {
        if (topMonth.isEmpty()) {
            System.out.println("hiện tại chưa có khách hàng nào");
        } else {
            topMonth.sort(topMonth1);
            System.out.println(topMonth.toString());
        }
    }
    public void bill(String name) {
        int index = findIndexByName(name);
        double money=0;
        if (member.get(index).getCart()==null) {
            System.out.println("hiện tại giỏ hàng đang rỗng ko thể thanh toán");
        } else {
            for (int j = 0; j < member.get(index).getCart().size(); j++) {
                System.out.println("Tên Sản phẩm: " + member.get(index).getCart().get(j).getNameSP() + " giá: " + member.get(index).getCart().get(j).getPrice());
                money = money + member.get(index).getCart().get(j).getPrice();
            }
            System.out.println("Tổng tiền: " + money);
            System.out.println("cảm ơn quý khách đã dùng dịch vụ");

            int indexTopMonth = findIndexClientOfTheMonth(member.get(index).getAccount());

            if (indexTopMonth==-1){
                ClientOfTheMonth clientOfTheMonth = new ClientOfTheMonth(member.get(index).getAccount(),money);
                topMonth.add(clientOfTheMonth);
            } else {
                double newMoney = topMonth.get(indexTopMonth).getMoney()+money;
                topMonth.get(indexTopMonth).setMoney(newMoney);
            }
            clearCartClient(index);

        }

    }
    public void clearCartClient(int index){
        for (int i = 0; i < member.get(index).getCart().size(); i++) {
            member.get(index).getCart().remove(i);
        }
    }
    public int findIndexClientOfTheMonth(String name) {
        for (int i = 0; i < topMonth.size(); i++) {
            if (name.equals(topMonth.get(i).getNameOfClient())){
                return i;
            }
        } return -1;
    }
    public void showClient() {
        for (Client client : member) {
            System.out.println(client);
        }
    }
    adminMain adminMain = new adminMain();
    memberMain memberMain = new memberMain();
    public void Login(String account,String pass) {
            if (admin.getAccount().equals(account) && admin.getPass().equals(pass)) {
                adminMain.adminWindown(account,pass);
            } else {
                for (int i = 0; i < member.size(); i++) {
                    if (member.get(i).getAccount().equals(account) && member.get(i).getPass().equals(pass)) {
                        memberMain.memberWindown(account, pass);
                    }
                }
                System.out.println("sai tài khoản hoặc mật khẩu");
            }
    }
    clientCartModal cCM = new clientCartModal();
    public void  showClientCart(String account) {
        int index = findIndexByName(account);
        if (member.get(index).getCart().isEmpty()) {
            System.out.println("hiện tại giỏ hàng rỗng");
        } else {
            yourCart(index);
            cCM.clientCartModal(account);
        }
    }
    public void allOfMoney() {
        double allMoney=0;
        if (topMonth.isEmpty()) {
            System.out.println("hiện tại doanh thu chưa có ");
        } else {
            for (int i = 0; i <topMonth.size() ; i++) {
                allMoney= allMoney+ topMonth.get(i).getMoney();
            }
            System.out.println(allMoney);
        }
    }
    public void addSP(String nameSP,int amount,double price) {

        for (Cart cart : carts) {
            if (cart.getNameSP().equals(nameSP)) {
                System.out.println("sản phẩm này đã có trên kệ hàng");
                System.out.println("hãy nhập lại");
                break;
            }
        }
        Cart cart1 = new Cart(nameSP, amount, price);
        carts.add(cart1);
        System.out.println();
        System.out.println("sản phẩm đã được thêm \n");
    }
    public static int findIndexByName(String account){
        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).getAccount().equals(account)) {
                return i;
            }
        }
        return -1;
    }
    public static int findIndexCartByName(String name) {
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getNameSP().equals(name))
                return i;
        }
        return -1;
    }
    public static int findCartNameEditClient(String name,int index) {
        for (int i = 0; i < member.get(index).getCart().size(); i++) {
            if (member.get(index).getCart().get(i).getNameSP().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public void deleteSPClient(String account,String nameEdit){
        int index = findCartNameEditClient(nameEdit,findIndexByName(account));
        if (index!=-1){
            member.get(findIndexByName(account)).getCart().remove(findCartNameEditClient(nameEdit,findIndexByName(account)));
        } else {
            System.out.println("ko tồn tại vật phẩm trên kệ hàng ");
        }
    }
    public void delete(String account){
        int index = findIndexByName(account);
        if (index!=-1){
            member.remove(index);
        } else {
            System.out.println("ko tồn tại tài khoản này");
        }
    }
    public void deleteCart(String nameCart) {
        int indexCart = findIndexCartByName(nameCart);
        if (indexCart!=-1){
            carts.remove(indexCart);
        } else {
            System.out.println("ko tìm thấy tên SP");
        }
    }
    public List<Cart> createCart(String name, int amount, double price){

        Cart cart1 = new Cart(name,amount,price);
        carts.add(cart1);
        return carts;
    }
    public void showSP() {
        for (Cart cart : carts) {
            System.out.println(cart.toString());
        }
    }

    public void editAmountSPCliet(String account, String nameEdit) {
        System.out.println("nhập số lượng mới");
        int newSl;
        while (true) {
            try {
                newSl =Integer.parseInt(scanner.nextLine()) ;
                break;
            } catch (Exception e){
                System.out.println("nhập số lượng");
            }
        }
        int amountAfterEdit = member.get(findIndexByName(account)).getCart().get(findCartNameEditClient(nameEdit,findIndexByName(account))).getAmount() - newSl;
        member.get(findIndexByName(account)).getCart().get(findCartNameEditClient(nameEdit,findIndexByName(account))).setAmount(newSl);
        member.get(findIndexByName(account)).getCart().get(findCartNameEditClient(nameEdit,findIndexByName(account))).setPrice(newSl*carts.get(findIndexCartByName(nameEdit)).getPrice());
        carts.get(findIndexCartByName(nameEdit)).setAmount(carts.get(findIndexCartByName(nameEdit)).getAmount()+amountAfterEdit);
    }
    public void editCart(String name){
        int index = findIndexCartByName(name);
        if (index!=-1){
            int choice;
            while (true) {
                System.out.println("1.sửa số lượng");
                System.out.println("2.sửa giá");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e){
                    System.out.println("phải nhập số");
                }
            }
            if (choice==1){
                editCartAmount(index);
                System.out.println("sửa thành công");
            } else if (choice==2) {
                editCartPrice(index);
                System.out.println("sửa thành công");

            } else {
                System.out.println("ko có chức năng này");
            }
        } else {
            System.out.println("sản ko tồn tại");
        }
    }
    public void editCartAmount(int index) {
        System.out.println("nhập số lượng mới");
        int amount;
        while (true) {
            try {
                 amount = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.println("phải nhập số");
            }
        }
        carts.get(index).setAmount(amount);
    }
    public void editCartPrice(int index){
        System.out.println("nhập giá mới");
        double price;
        while (true){
            try {
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.println("phải nhập số");
            }
        }
        carts.get(index).setPrice(price);
    }

    public void yourCart(int index) {
        if (member.get(index).getCart()==null) {
            System.out.println("giỏ hàng rỗng ");
        } else {
            for (int i = 0; i < member.get(index).getCart().size(); i++) {
                System.out.println(member.get(index).getCart().get(i));
            }
        }
    }
    public int findIndexInClientCart(String cartName,String account) {
        int index = findIndexByName(account);
        if (member.get(index).getCart().isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < member.get(index).getCart().size(); i++) {
                if (member.get(index).getCart().get(i).getNameSP().equals(cartName)) {
                    return i;
                }
            } return -1;
        }
    }
    public void buy(String CartName, int amount,String account) {
        int indexAccount = findIndexByName(account);
        int indexCart = findIndexCartByName(CartName);
        int index = findIndexCartByName(CartName);
        if (indexCart!=-1){
            int count = carts.get(index).getAmount()-amount;
            if (count<0) {
                System.out.println("số lượng hiện tại ko đủ cung cấp");
            } else {
                int indexClientCartName = findIndexInClientCart(CartName,account);
                if (indexClientCartName==-1) {
                        carts.get(indexCart).setAmount(count);
                        member.get(indexAccount).getCart().add(new Cart(CartName,amount,amount*carts.get(index).getPrice()));
                        System.out.println("sản phẩm đã được thêm ");
                } else {
                    member.get(indexAccount).getCart().get(indexClientCartName).setAmount(member.get(indexAccount).getCart().get(indexClientCartName).getAmount()+amount);
                    member.get(indexAccount).getCart().get(indexClientCartName).setPrice(member.get(indexAccount).getCart().get(indexClientCartName).getAmount()*carts.get(index).getPrice());
                    carts.get(indexCart).setAmount(count);
                    System.out.println("số lượng sản phẩm đã được thêm");

                }
            }

        } else  {
            System.out.println("sản phẩm ko có trên kệ hàng");
        }
    }
    public void readFile() {
        try (FileInputStream fis = new FileInputStream("data.txt"); ObjectInputStream ois = new ObjectInputStream(fis)) {

            member = (ArrayList<Client>) ois.readObject();

        } catch (Exception ignored) {
        }
    }
    public void writeFile() {
        try (FileOutputStream fos = new FileOutputStream("data.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(member);

        } catch (Exception ignored) {
        }
    }
    public void readAdmin() {
        try (FileInputStream fis = new FileInputStream("admin.txt"); ObjectInputStream ois = new ObjectInputStream(fis)) {

            carts = (List<Cart>) ois.readObject();

        } catch (Exception ignored) {
        }
    }
    public void writeAdmin() {
        try (FileOutputStream fos = new FileOutputStream("admin.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(carts);

        } catch (Exception ignored) {
        }
    }
    public void readTopClient() {
        try (FileInputStream fis = new FileInputStream("TopClient.txt"); ObjectInputStream ois = new ObjectInputStream(fis)) {

            topMonth = (ArrayList<ClientOfTheMonth>) ois.readObject();

        } catch (Exception ignored) {
        }
    }
    public void writeTopClient() {
        try (FileOutputStream fos = new FileOutputStream("TopClient.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(topMonth);
        } catch (Exception ignored) {
        }
    }
}
