package Cards;

public class Cards {
    private static String deck;
    private static int id;
    
    public Cards(String mask){ deck = mask; }
    public Cards() { }
    
    public int id(){ return id; }
    
    @Override
    public String toString(){
        return deck;
    }
}
