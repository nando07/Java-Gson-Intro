package nando;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fernandogomez on 5/1/17.
 */
public class Player {

//    Create a class definition for a class called Player that
// has properties for name, health, mana, and gold.

  private String _name;
  private double _health;
  private double _mana;
  private double _gold;
  private Map<String, Integer> equipment = new HashMap<>();

    public Player() {

        _name = "Player";
        _health = 10;
        _mana = 5;
        _gold = 40;
    }

    public Player(String name, Double health, Double mana, Double gold) {

        _name = name;
        _health = health;
        _mana = mana;
        _gold = gold;
    }

    public void display(){

        System.out.println("Name: " + _name);
        System.out.println("Health: " + _health);
        System.out.println("Mana: " + _mana);
        System.out.println("Gold: " + _gold);

        for (String key : equipment.keySet()) {
            System.out.println(key + " " + equipment.get(key));
        }

    }

    // getters
    public String getName() {
        return _name;
    }

    public Double getHealth() {
        return _health;
    }

    public Double getMana() {
        return _mana;
    }

    public Double getGold() {
        return _gold;
    }


// setters
    public void setName(String name) {
        this._name = name;
    }

    public void setHealth(Double health) {
        this._health = health;
    }

    public void setMana(Double mana) {
        this._mana = mana;
    }

    public void setGold(Double gold) {
        this._gold = gold;
    }

    public void addEquipment(String e, Integer value) {

        equipment.put(e, value);
    }
}
