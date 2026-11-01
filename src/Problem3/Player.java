package Problem3;

import java.util.*;
public class Player implements ISaveable{
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength){
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getWeapon(){
        return this.weapon;
    }
    public void setWeapon(String weapon){
        this.weapon = weapon;
    }
    public int getHitPoints(){
        return this.hitPoints;
    }
    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }
    public int getStrength(){
        return this.strength;
    }
    public void setStrength(int strength){
        this.strength = strength;
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
        return "Player{name='"+this.name+"', hitpoints="+this.hitPoints+", strength="+this.strength+", weapon="+this.weapon+"'}";
    }
}
