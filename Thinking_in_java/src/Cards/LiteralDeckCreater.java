package Cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class LiteralDeckCreater extends DeckCreater {

    public static final List<Class<? extends Cards>> allTypes =
        Collections.unmodifiableList(
                Arrays.asList(Cards.class, Clubs.class, Spades.class,
                Hearts.class,Diamonds.class));

    private static final List<Class<? extends Cards>> types = 
            allTypes.subList(allTypes.indexOf(Clubs.class), 
            allTypes.size());
    
    @Override
    public List<Class<? extends Cards>> types() {
        return types;
    }
}
