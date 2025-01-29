import java.util.HashMap;
import java.util.Objects;

//Class for Inventory that will collect in itself our items, also including upgrades
public class Inventory{
    //   I choose to use HashMap, faster insertion and search and perfect for logic that I had in mind․
    //   The only downside that we can't have clear approach to objects in it. In approach that I had, uses Item as a key and/
    //   Value as Quantity of objects with that type
    private HashMap<Item, Integer> inventory;


    public Inventory() {
        this.inventory = new HashMap<>();
    }

    //Checks for object in HashMap, if we have object like that, we just increment it
    public void addItem(Item item){
        if(inventory.containsKey(item)){
            inventory.put(item, inventory.get(item) + 1);
        }
        else{
            inventory.put(item, 1);
        }
    }

    //Actually I still don't know if in assigment we have to specify items that we want to use for upgrade or not,
    //but still, for testing this function was helpful too
    public Item uprgradeAutomatic(Item item){
        if(inventory.containsKey(item)){
            if(Objects.equals(item.getRarity(), "Epic")){
                if(inventory.get(item) >= 2) {
                    inventory.put(item, inventory.get(item) - 2);
                    if((item.getUpgradeCount() + 1) == 3){
                        Item itemTemp = new Item(item.getName(), "Legendary", 0);
                        addItem(itemTemp);
                        return itemTemp;
                    }
                    Item itemTemp = new Item(item.getName(), "Epic", item.getUpgradeCount() + 1);
                    addItem(itemTemp);
                    return itemTemp;
                }
                for (var entry : inventory.entrySet()) {
                    if(entry.getKey() != item){
                        if(Objects.equals(entry.getKey().getRarity(), item.getRarity())){
                            if(entry.getKey().getUpgradeCount() == item.getUpgradeCount()){
                                if(Objects.equals(entry.getKey().getName(), item.getName())){
                                    inventory.put(entry.getKey(), entry.getValue() - 2);
                                }
                                else if(!Objects.equals(entry.getKey().getName(), item.getName())){
                                    inventory.put(entry.getKey(), entry.getValue() - 1);
                                    inventory.put(item, entry.getValue());
                                }
                                if((item.getUpgradeCount() + 1) == 3){
                                    Item itemTemp = new Item(item.getName(), "Legendary", 0);
                                    addItem(itemTemp);
                                    return itemTemp;
                                }
                                Item itemTemp = new Item(item.getName(), "Epic", item.getUpgradeCount() + 1);
                                addItem(itemTemp);
                                return itemTemp;
                            }
                        }
                    }
                }
            }
            else if(inventory.get(item) > 2){
                inventory.put(item, inventory.get(item) - 2);
                if(Objects.equals(item.getRarity(), "Common")){
                    Item itemTemp = new Item(item.getName(), "Great", item.getUpgradeCount());
                    addItem(itemTemp);
                    return itemTemp;
                }
                else if(Objects.equals(item.getRarity(), "Great")){
                    Item itemTemp = new Item(item.getName(), "Rare", item.getUpgradeCount());
                    addItem(itemTemp);
                    return itemTemp;
                }
                else if(Objects.equals(item.getRarity(), "Rare")){
                    Item itemTemp = new Item(item.getName(), "Epic", item.getUpgradeCount());
                    addItem(itemTemp);
                    return itemTemp;
                }
            }

            else{
                System.out.println("Not Enough Items");
                return item;
            }
        }
        else{
            System.out.println("No Such Item in Inventory");
            return item;
        }
        System.out.println("Unexpected Outcome");
        return item;
    }

    //Upgrade logic, but with specification of items that we want to use for upgrade
    public Item upgrade(Item toUpgrade, Item upgradeWith,Item upgradeWith1){
        if(Objects.equals(toUpgrade.getRarity(), "Epic")){
            System.out.println("Pls Choose 1 Item for Upgrade");
            return toUpgrade;
        }
        if(inventory.containsKey(toUpgrade) && inventory.containsKey(upgradeWith) && inventory.containsKey(upgradeWith1)){
            if(Objects.equals(toUpgrade.getRarity(), upgradeWith.getRarity()) && Objects.equals(upgradeWith.getRarity(), upgradeWith1.getRarity())){
                inventory.put(upgradeWith,inventory.get(upgradeWith) - 1);
                inventory.put(upgradeWith1,inventory.get(upgradeWith1) - 1);

                if(Objects.equals(toUpgrade.getRarity(), "Common")){
                    Item itemTemp = new Item(toUpgrade.getName(), "Great", toUpgrade.getUpgradeCount());
                    inventory.put(toUpgrade, inventory.get(toUpgrade) - 1);
                    addItem(itemTemp);
                    return itemTemp;
                }
                if(Objects.equals(toUpgrade.getRarity(), "Great")){
                    Item itemTemp = new Item(toUpgrade.getName(), "Rare", toUpgrade.getUpgradeCount());
                    inventory.put(toUpgrade, inventory.get(toUpgrade) - 1);
                    addItem(itemTemp);
                    return itemTemp;
                }
                if(Objects.equals(toUpgrade.getRarity(), "Rare")){
                    Item itemTemp = new Item(toUpgrade.getName(), "Epic", toUpgrade.getUpgradeCount());
                    inventory.put(toUpgrade, inventory.get(toUpgrade) - 1);
                    addItem(itemTemp);
                    return itemTemp;
                }
            }
        }
        else{
            System.out.println("No Such Item in Inventory");
            return toUpgrade;
        }
        System.out.println("Unexpected Outcome");
        return toUpgrade;
    }

    public Item upgrade(Item toUpgrade, Item upgradeWith){
        if(Objects.equals(toUpgrade.getRarity(), "Epic") && Objects.equals(upgradeWith.getRarity(), "Epic")){
            if(toUpgrade.getUpgradeCount() != upgradeWith.getUpgradeCount()){
                return toUpgrade;
            }
        }
        if(inventory.containsKey(toUpgrade) && inventory.containsKey(upgradeWith)){
            if((toUpgrade.getUpgradeCount() + 1) >= 3){
                Item temp = new Item(toUpgrade.getName(),"Legendary",0);
                inventory.put(toUpgrade,inventory.get(toUpgrade) - 1);
                inventory.put(upgradeWith,inventory.get(upgradeWith) - 1);
                addItem(temp);

                return temp;
            }
            Item temp = new Item(toUpgrade.getName(),toUpgrade.getRarity(),toUpgrade.getUpgradeCount() + 1);
            inventory.put(toUpgrade,inventory.get(toUpgrade) - 1);
            inventory.put(upgradeWith,inventory.get(upgradeWith) - 1);
            addItem(temp);

            return temp;
        }
        else{
            System.out.println("No Such Item in Inventory");
            return toUpgrade;
        }
    }

    //Just returns copy of inventory hashMap
    public HashMap<Item,Integer> getTable(){
        return new HashMap<>(inventory);
    }
}
