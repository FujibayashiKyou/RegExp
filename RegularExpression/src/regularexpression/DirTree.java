/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regularexpression;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ANDRON
 */

public class DirTree {
    private String thisDir; //Путь к директории
    private List files = new ArrayList();
    
    
    //Конструктор класса
    DirTree(String path){
       thisDir = path;
       checkPath();
    }
    
    //Проверяем на существование файла\каталога
    private void checkPath(){
        File file = new File(thisDir);
        if (!file.exists()) { System.out.print("File not found!"); } //Если не "существует"
        if(!file.isDirectory()) { //Если не "директория"
            System.out.println("File is not directory!");
        }
        list(thisDir); //Иначе выполняем метод list(path)
    }
    
    //Этот метод выводит спичак всех файлов в директории
    private void list(String thisDir){
        File file = new File(thisDir);
        String[] dirList = file.list(); //Ложим в массив список файлов в текущей директории
        
        /*Выводим а экран все файлы начиная с текущей директории
        * Если мы обнаружили файл, мы выводим на консоль полный путь к нему, 
        * комбинируя его из пути к каталогу thisDir  и имени каталога.
        */
        int i;
        Pattern txt = Pattern.compile("\\w+\\.txt");
        Matcher m;
                
        for(i = 0; i < dirList.length; i++){
            File currFile = new File(thisDir + 
                    File.separator + dirList[i]);
            
            /* Если currFile - файл, выводим полный его путь
             * и если наш файл имеет разшерение *.txt, считываем его
             */
            try {
                m = txt.matcher(dirList[i]);
            
                if((currFile.isFile()) && (m.matches())) {
                    //System.out.println(thisDir + 
                            //File.separator + dirList[i]);
                    
                    //Добавляем в список имя файла и его путь.
                    files.add(thisDir+
                            File.separator + dirList[i]);
                }
            
                //Иначе, list вызывает сам себя
                else {
                    list(thisDir + 
                            File.separator + dirList[i]);
                } 
            //Обрабатываем ошибку
            }catch (Exception e) { 
                //System.out.println("Another type of file: " + 
                    //thisDir + File.separator + dirList[i]); 
            } 
        }
    }
    
    //Возврат files(list)
    public List getFiles(){
        return files;
    }
}
