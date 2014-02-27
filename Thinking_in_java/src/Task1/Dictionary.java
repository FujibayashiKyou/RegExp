package Task1;

import java.util.HashMap;

public class Dictionary {
    private static HashMap<Integer, Integer> dictionary =
            new HashMap<Integer, Integer>();

    public HashMap<Integer,Integer> Dictionary() {
        getDictionari();
        return this.dictionary;
    }
    
    
    private void getDictionari(){
        dictionary.put(1, 16);
        dictionary.put(2, 17);
        dictionary.put(3, 18);
        dictionary.put(4, 19);
        dictionary.put(5, 24);
        dictionary.put(6, 26);
        dictionary.put(7, 22);
        dictionary.put(8, 25);
        dictionary.put(9, 29);
        dictionary.put(10, 21);
        
        dictionary.put(11, 27);
        dictionary.put(12, 30);
        dictionary.put(13, 20);
        dictionary.put(14, 23);
        dictionary.put(15, 28);
    }

}