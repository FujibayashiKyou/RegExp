/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ANDRON
 */

public class Collections_add_All {
    
    public static void main(String[] args){
        Collection<Integer> collection =
                new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
        
        Integer[] moreInts = {8,9,10,11,12};
        collection.addAll(Arrays.asList(moreInts));
        
        //Работает намного быстрее, но таким способом невозможно скоструировать
        //Collections
        
        List<Integer> list = Arrays.asList(13,14,15,16);
        list.set(1, 99);
        //list.add(21); //Ошибка времени выполнения - нижележащий массив не должен
        //Изменяться в размерах!
        
        for (Integer i: collection){
            System.out.print(i + ", ");
        }
    }
    
}
