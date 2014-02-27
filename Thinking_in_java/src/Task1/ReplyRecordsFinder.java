package Task1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ReplyRecordsFinder {
    private static LinkedHashMap<Integer, LinkedHashMap<String,String>> records =
            new LinkedHashMap<Integer, LinkedHashMap<String,String>>();
    
    private static HashMap<Integer, Integer> dictionary = 
            new HashMap<Integer, Integer>();

    ReplyRecordsFinder(LinkedHashMap<Integer, LinkedHashMap<String,String>> records, 
            HashMap<Integer, Integer> dictionary) {
        this.records = records;
        this.dictionary = dictionary;
    }
    
    public JTable findRepeatRecord(JTable table){
        
        //Создаём таблицу
        Vector<String> headerVect = new Vector<String>();
        headerVect.add("id");
        headerVect.add("Title");
        headerVect.add("Alias");
        headerVect.add("catId");
        headerVect.add("repeatID");
        DefaultTableModel mod = new DefaultTableModel(headerVect, 0);                    
        table.setModel(mod); //Присваиваем таблице модель
        
        //Перебор значений
        Integer[] arrayOfKeys = new Integer[records.size()];
        records.keySet().toArray(arrayOfKeys);
       
        for (int i = 0; i < arrayOfKeys.length; i++){
            Vector<String> newRow = new Vector<String>(); //Новая строка
            Integer id = arrayOfKeys[i];
            Integer repeatID = 0; //Для айди повторной записи
            
            //Перебор значений в словаре
            String title = records.get(id).get("title");
            String alias = records.get(id).get("alias");
            Integer catId = Integer.valueOf(records.get(id).get("catid"));
            
            Integer count = 0; //Количество повторов одной записи
            
            for(int j = i + 1; j < arrayOfKeys.length; j++){
                Integer nextId = arrayOfKeys[j];
                
               if ( (title.equalsIgnoreCase(records.get(nextId).get("title"))) &&
                        (alias.equalsIgnoreCase(records.get(nextId).get("alias"))) &&
                      (dictionary.containsKey(catId)) &&
                       (id != nextId) ) {
                    
                   /*
                    System.out.println("----------------------------------------");
                    System.out.println("Id: " + id + " catId: " + catId 
                            + " title: " + title + " alias: " + alias 
                            + " already used! ( " 
                            + nextId 
                            + " title: " + records.get(nextId).get("title")
                            + " alias: " + records.get(nextId).get("alias")
                            + " catId: " + records.get(nextId).get("catid") + " )" );
                    System.out.println("----------------------------------------");
                    count++;
                    */
                   count++;
                   repeatID = nextId;
                   
                } else if (id == nextId) { break; }

            }
            
            newRow.add(id.toString());
            newRow.add(title);
            newRow.add(alias);
            newRow.add(catId.toString());
            if (count != 0) newRow.add(repeatID.toString());
            else newRow.add(" ");
            newRow.add(" ");
            mod.addRow(newRow); //Добавление строки в таблицу
            
            //System.out.println("Id: " + id + " catId: " + catId + 
                            //" title: " + title + " alias: " + alias);
        }
        return table;
    }
}
