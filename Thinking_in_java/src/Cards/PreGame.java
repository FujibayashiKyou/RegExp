package Cards;

import java.util.ArrayList;

public class PreGame {
    public static final DeckCreater creater = 
            new LiteralDeckCreater();
    
    public static Cards randomCard() {
        return creater.randomCard();
    }
    
    public static Cards[] createArray(int size){
        return creater.createArray(size);
    }
    
    public static ArrayList<Cards> arrayList(int size){
        return creater.arrayList(size);
    }
    
}
