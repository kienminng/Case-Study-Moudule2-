package createFile;

import ProductManager.ProductManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateFile {
    public static void main(String[] args) {

        File myObj = new File("fileAccount.txt");
        System.out.println(myObj.exists());
        System.out.println(myObj.isAbsolute());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(myObj))) {
            writer.write("try");
            writer.write("abc\n");

        }catch (IOException e) {
            System.out.println("not ok");
            e.printStackTrace();
        }
    }
}
