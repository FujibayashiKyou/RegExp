/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class ReversibleIterator<T> extends ArrayList<T>{
    public ReversibleIterator(Collection<T> c) { super(c); }
    public Iterable<T> reversed(){
        return new Iterable<T>(){
            public Iterator<T> iterator() {
                return new Iterator<T>(){
                    int current = size() - 1;
                    
                    public boolean hasNext() {
                        return current > -1;
                    }

                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                    
                }; // End of return Iterator<T>()
            } // End of Iterator<T> iterator()
        }; // End of Iterable<T>()
    } //End of Iterable<T> reversed()
}

public class Ideoma_Method_Adapter {
    
    public static void main(String[] args){
        ReversibleIterator<String> ral = new ReversibleIterator<String>(
                Arrays.asList("This is a good day!".split(" ")));
        for(String s : ral){
            System.out.print(s + " ");
        }
        
        System.out.println(" ");
        
        for (String s : ral.reversed()){
            System.out.print(s + " ");
        }
        
        System.out.println(" ");
    }
    
}
