package Task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;

class FileOpener{
    private static File file;
    private MapData mapCreator = 
            new MapData();
    
    String FileOpener(File file){
        this.file = file;
        String sentence = open(file);
        
        return sentence;
    }
    
    private String open(File file){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader in = new BufferedReader(new FileReader(
                    file.getAbsoluteFile()));
            try{
                String temp;
                Pattern pattern;
                Matcher matcher;
                Integer primaryKey = 0;  
                
                while( (temp = in.readLine()) != null ){
                    pattern = Pattern.compile("^[^\\S].*" //Spaces!
                        + "<table name=\"n9s15_k2_items\">");
                    
                    matcher = pattern.matcher(temp); //Find <table name=....>
                    
                    if (matcher.matches()) {
                        
                        //Record in StringBuilder until </table>
                        pattern = Pattern.compile("^[^\\S].*"
                                + "</table>");
                                                
                        //Until we have next stroke
                        while ( (temp = in.readLine()) != null ){
                            String key; String value;        
                            matcher = pattern.matcher(temp); //Check for </table>
                            
                            try{ //StringIndexOutOfBoundsException!
                                if( (!matcher.matches()) && temp.indexOf('"') > - 1){
                                    
                                    //get name of the field "key"
                                    key = temp.substring(temp.indexOf('"') + 1, 
                                        temp.lastIndexOf('"'));
                                    
                                    //get value of the key-field
                                    value = temp.substring(temp.indexOf(">") + 1, 
                                        temp.lastIndexOf("<"));
                                    
                                    //If field(id) then value will be a key
                                    //else append node
                                    if (key.equals("id")) 
                                        primaryKey = Integer.valueOf(value);
                                    else {
                                        if (value.isEmpty()) value = "NULL";
                                        mapCreator.addNode(key, value);
                                    }  
                                        
                                    //print to StringBuilder
//                                    sb.append(key + " - " + value);               
//                                    sb.append("\n");
                                   
                                } else if (matcher.matches()) { break;}
                            }catch (StringIndexOutOfBoundsException e){
                                key = temp.substring(temp.indexOf('"') + 1, 
                                    temp.lastIndexOf('"'));
                               
                                value = "NULL";
                                mapCreator.addNode(key, value);
//                                sb.append(key + " - " + value);               
//                                sb.append("\n");
                            }//TRY
                        }//WHILE(second)
                        LinkedHashMap<String,String> values = mapCreator.getNode();
                        mapCreator.addNodeToCollection(primaryKey, values); 
                    } //IF  
                }//WHILE(first)
            } finally {
                //delete three empty stroke
                //mapCreator.showCollection();
                in.close();
            }
        }catch(Exception e) { e.printStackTrace(); }
        return sb.toString();
    }
    
    public LinkedHashMap<Integer, LinkedHashMap<String,String>> getCollection(){
        return mapCreator.getCollection();
    }
   
}

public class StructureCreator {
    private static JTable table;
    
    StructureCreator(JTable table){
        this.table = table;
    }
    
    public  JTable getTable(){
        FileOpener fo = new FileOpener();
        System.out.println(fo.FileOpener(
                new File("C:\\Users\\ANDRON\\Documents\\NetBeansProjects\\Thinking_in_java\\src\\Task1\\database.xml")));
         
        ReplyRecordsFinder rrf = new ReplyRecordsFinder(fo.getCollection(), 
                new Dictionary().Dictionary());
        
        rrf.findRepeatRecord(table); //возвращаем таблицу
        return table;
    }

}
