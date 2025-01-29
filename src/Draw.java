import java.util.HashMap;

//Little class for drawing a more readable screen
public class Draw {
    public void drawScreen(HashMap<Item,Integer> table){
        System.out.println("\n ////////////////////////////////////");
        for (var entry : table.entrySet()) {
            if(entry.getValue() != 0) {
                System.out.println("|Name|: " + entry.getKey().getName() + " |Rarity|: " +  entry.getKey().getRarity() +  " |UpgCount|: " + entry.getKey().getUpgradeCount() + " |Quantity|: " + entry.getValue());
            }
        }
        //System.out.println("////////////////////////////////////");
    }
}
