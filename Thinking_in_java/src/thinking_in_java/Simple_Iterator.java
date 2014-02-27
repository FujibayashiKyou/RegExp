/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Simple_Iterator {
    public static void main(String[] args){
        List<String> dictionary = new ArrayList<String>();
        dictionary.add("Hello");
        dictionary.add("I`am");
        dictionary.add("love");
        dictionary.add("android");
        dictionary.add("and");
        dictionary.add("Java");
        
        Iterator<String> iterator = dictionary.iterator();
        
        int id = 0;
        while(iterator.hasNext()){
            String temp = iterator.next();
            System.out.print(id + ":" + temp + " ");
            id++;
        }
        
        System.out.println(" ");
        
        id = 0;
        for(String t: dictionary){
            System.out.print(id + ":" + t + " ");
            id++;
        }
        
        System.out.println(" ");
        
        iterator = dictionary.iterator();
        
        while(iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        
        System.out.println(dictionary);
    }
    
}
