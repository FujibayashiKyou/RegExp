package Cards;

import java.util.LinkedHashMap;
import java.util.Map;

public class CardsCounter {
    private static LinkedHashMap<Class<? extends Cards>,Integer> result=
            new LinkedHashMap<Class<? extends Cards>,Integer>();
    
    private static MapData md = new MapData(LiteralDeckCreater.allTypes, 0);
    
    //Влоденный класс
    static class CardCounter 
    extends LinkedHashMap<Class<? extends Cards>,Integer>{
        //Конструктор.
        //Преобразует ArrayList<Class> -> Map<Class,Int>
        public CardCounter() throws InstantiationException, IllegalAccessException {
            super(md.getMap());
        }
        
        //Подсчёт повторений
        public void count(Cards card){
            //Class isInstance() избавляет от множества конструкций instanceof
            for(Map.Entry<Class<? extends Cards>, Integer> pair : 
                    entrySet()){
                if (pair.getKey().isInstance(card)) {
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }
        
        public String toString(){
            StringBuilder result = new StringBuilder("{");
            for(Map.Entry<Class<? extends Cards>, Integer> pair : 
                    entrySet()){
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }
    }
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException{
        //CardCounter cardCounter = new CardCounter();
        TypeCounter typeCounter = new TypeCounter(Cards.class);
        for (Cards card : PreGame.createArray(52)) {
            System.out.print(card.getClass().getSimpleName() + " ");
            typeCounter.count(card);
        }
        System.out.println();
        System.out.println(typeCounter);
    }
}
