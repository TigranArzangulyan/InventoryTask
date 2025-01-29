public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        RandomItem rItem = new RandomItem();

        Item item = new Item("Axe", "Common",0);
        Item item2 = new Item("Pickaxe", "Common",0);
        Item item3 = new Item("TNT", "Common",0);

        inventory.addItem(item);
        inventory.addItem(item2);
        inventory.addItem(item3);

        for(int i = 0; i < 3; ++i){
            inventory.addItem(rItem.getRandomItem());
        }


        Draw screen = new Draw();
        screen.drawScreen(inventory.getTable());

        inventory.upgrade(item,item2,item3);

        screen.drawScreen(inventory.getTable());

    }
}