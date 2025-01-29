import java.util.ArrayList;
import java.util.Random;

public class RandomItem {
    private ArrayList<String> itemNames;

    //Just couple of names for items, more readable than random strings
    RandomItem(){
        this.itemNames = new ArrayList<>();
        this.itemNames.add("Axe");
        this.itemNames.add("Pickaxe");
        this.itemNames.add("Sword");
        this.itemNames.add("Great Sword");
        this.itemNames.add("Flamethrower"); //Unexpected but why not
        this.itemNames.add("WaterGun"); //If we have Flamethrower, why not to have WaterGun
    }

    public String getRarity(){
        Random random = new Random();
        int num = random.nextInt(1,101);

        if(num > 0 && num <= 2){
            return "Legendary";
        }
        else if(num >= 3 && num <= 8){
            return "Epic";
        }
        else if(num >= 9 && num <= 15){
            return "Rare";
        }
        else if(num >= 16 && num <= 50){
            return "Great";
        }

        return "Common";
    }

    public Item getRandomItem(){
        Random random = new Random();
        int num = random.nextInt(0,6);

        return new Item(itemNames.get(num),getRarity(),num % 3);
    }
}
