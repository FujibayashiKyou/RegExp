package regularexpression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ANDRON
 */

public class RegularExpression {
    static Patterns telephone;
    static DirTree dt;
    private static List list = new ArrayList();
    static int index = 0; // позиция каретки

    public static void main(String[] args) {
        System.out.print("Введите корневую папку: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine(); // Считываем путь
        
        dt = new DirTree(path); // Вызываем конструктор класса DirTree
        list = dt.getFiles();
        
        // Просматриваем элементы списка
        /*
         * for (int i = 0; i < list.size(); i++){
            System.out.println("Element: " + list.get(i));
        }
        */
        
        //Считываем информацию со всех файлов
        for (int i = 0; i < list.size(); i++){
            try{
                BufferedReader in = new BufferedReader(
                        new FileReader(
                        new File(list.get(index).toString())));
                
                System.out.println("|New file open: " + list.get(index).toString() + "|");
                
                try{
                    //В цикле считываем строку с каждого файла
                    String currStroke;
                    while ((currStroke = in.readLine()) != null){
                        telephone = new Patterns(currStroke);   
                    }
                } finally {
                    in.close();
                    System.out.println("|File close: " + list.get(index).toString() + "|");
                    index++;
                }
                
            }catch (Exception e) { } //Обработка ошибки
        }
    }
}
