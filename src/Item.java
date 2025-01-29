import java.util.Objects;

public class Item{
    private String name;

    private String rarity;

    private int upgradeCount;

    public Item(String name, String rarity, int upgradeCount){
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = upgradeCount;
    }

    public String toString(){
        return name + rarity;
    }

    //I did not have information how java would identify Item's hashCode, so as a more clear approach,
    // I choose to override hash and equals for it
    @Override
    public int hashCode(){
        return Objects.hash(name, rarity, upgradeCount);
    }

    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(getClass() != other.getClass()){
            return false;
        }

        return Objects.equals(name, ((Item) other).name) && Objects.equals(rarity, ((Item) other).rarity) &&
                Objects.equals(upgradeCount, ((Item) other).upgradeCount);

    }

    public String getRarity(){
        return this.rarity;
    }

    public String getName(){
        return name;
    }

    public int getUpgradeCount(){
        return upgradeCount;
    }

}

