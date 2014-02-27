/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 *
 * @author ANDRON
 */
public class Printing_Containers {
    
    static Collection fill(Collection<String> collection)  {
        java.util.Collections.addAll(collection, 
                "rat", 
                "mouse", 
                "cat", 
                "dog", 
                "dog");
        return collection;
    } 
    
    static Map fill(Map<String,String> map){
        map.put("rat", "Fuzzy");
        map.put("mouse", "RX-74");
        map.put("cat", "Snowly");
        map.put("dog", "Pitbul");
        map.put("dog", "Bosco");       
        return map;
    }
    
    public static void main(String[] args){
        print(fill(new ArrayList<String>()));
        print(fill(new LinkedList<String>()));
        print(fill(new HashSet<String>()));
        print(fill(new TreeSet<String>()));
        print(fill(new LinkedHashSet<String>()));
        print(fill(new HashMap<String,String>()));
        print(fill(new TreeMap<String,String>()));
        print(fill(new LinkedHashMap<String,String>()));
    }

    private static void print(Object obj) {
        System.out.println(obj.toString());
    }
    
}
