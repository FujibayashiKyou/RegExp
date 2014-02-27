package thinking_in_java;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

class FileOpener{
    private static File file;
    
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
                while( (temp = in.readLine()) != null ){
                    sb.append(temp);
                    sb.append("/n");
                }
            } finally {
                in.close();
            }
        }catch(Exception e) { e.printStackTrace(); }
        
        return sb.toString();
    }
}

class LiteraFinder{
    private static String sentence;
    
    private LinkedHashMap<String, Integer> lhm =
        new LinkedHashMap<>();
    
    //Constructor
    LiteraFinder(String sentence){
        System.out.println("Constructor");
        this.sentence = sentence;
    }
    
    public LinkedHashMap<String, Integer> counter(){
        char[] litera = sentence.toCharArray();
        Arrays.sort(litera);

        System.out.println("Before for");
        for(char c: litera){
            if (lhm.containsKey(String.valueOf(c))) {
                lhm.put(String.valueOf(c), 
                        lhm.get(String.valueOf(c)).intValue() + 1);
            }
            else { 
                lhm.put(String.valueOf(c), 1);
            }
        }
        output(lhm.keySet(), lhm.values()); //Console
        System.out.println("After for");
        return lhm;
    }
    
    private void output(Set<String> keySet, Collection<Integer> valuesCollection){
        String[] key = new String[keySet.size()];
        keySet.toArray(key);
        
        Integer[] val = new Integer[valuesCollection.size()];
        valuesCollection.toArray(val);
        
        for(int i = 0; i < key.length; i++){
            System.out.println("Litera: '" + key[i]
                    + "' - " + val[i]);
        }
    }
}

public class Test {
    public static void main(String[] args){
        FileOpener fo = new FileOpener();

        LiteraFinder lf = new LiteraFinder(fo.FileOpener(
                new File("e:/Games/World of Warcraft/WTF/config.wtf")));
        LinkedHashMap<String, Integer> lhm = lf.counter();
        
        
    }
}
