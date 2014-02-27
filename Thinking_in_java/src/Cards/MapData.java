package Cards;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapData {
    //Константа, которую нужно добавить в карту типа <Cards,Integer>
    private int constant = 0;
    
    private List<Class<? extends Cards>> alphabeth;
    
    //Нужная нам карта
    private static LinkedHashMap<Class<? extends Cards>,Integer> map = 
            new LinkedHashMap<Class<? extends Cards>,Integer>();

    public MapData(List<Class<? extends Cards>> allTypes, int constant) {
        this.alphabeth = allTypes;
        this.constant = constant;
    }
    
    public Map<Class<? extends Cards>, Integer> getMap(){
        //Перебор всех значений в списке
        for(Class<? extends Cards> card : alphabeth){
            map.put(card, constant);
        }
        return map;
    }
}
