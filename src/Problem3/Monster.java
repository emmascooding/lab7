package Problem3;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength){
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName(){
        return this.name;
    }
    public int getHitPoints(){
        return this.hitPoints;
    }
    public int getStrength(){
        return this.strength;
    }
    public List<String> write(){
        List<String> list = new ArrayList<>();
        list.add(this.name);
        list.add(Integer.toString(this.hitPoints));
        list.add(Integer.toString(this.strength));
        return list;
    }
    public void read(List<String> list){
        if (!list.equals(null) && list.size()>0){
            this.name = list.get(0);
            this.hitPoints = Integer.valueOf(list.get(1));
            this.strength = Integer.valueOf(list.get(2));
        }
    }
    public String toString(){
        return "Monster{name='"+this.name+"', hitpoints="+this.hitPoints+", strength="+this.strength+"}";
    }
}
