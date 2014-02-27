package Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class DeckCreater {
    private static Random rand = new Random(47);
    
    //Список созданных типов производных от Cards
    public abstract List<Class<? extends Cards>> types();
    
    //Заполнение массива
    public Cards randomCard(){
        //Random number
        int number = rand.nextInt(types().size());
        try {
            return types().get(number).newInstance();
        } catch(InstantiationException e) { throw new RuntimeException (e);
        } catch (IllegalAccessException e) { throw new RuntimeException (e); }
    }
    
    //Создание массива типа Cards
    public Cards[] createArray(int size){
        Cards[] result = new Cards[size];
        for (int i = 0; i < size; i++){
            result[i] = randomCard();
        }
        return result;
    }
    
    //Создание списка типа Cards
    public ArrayList<Cards> arrayList(int size){
        ArrayList<Cards> result = new ArrayList<Cards>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
