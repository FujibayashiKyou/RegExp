/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

import java.util.ArrayList;

class Apple{
    private static int counter;
    private static long id = counter++;
    public long id(){ return id; }
}

class Orange { }

public class Collections_With_Different_Elements {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++){
            apples.add(new Apple());
        }
        apples.add(new Orange());
        
        for(int i = 0; i < apples.size(); i++){
            System.out.println( ((Apple)apples.get(i)).id() );
        }
    }
    
}
