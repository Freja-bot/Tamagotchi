package models;
import java.util.Random;

public class Tamagotchi {
    private String name;
    private int age;
    private int mood;
    private int energy;
    private int hunger;
    private int stress;
    private final int maxStat = 30;
    private final int minStat = 0;

    public Tamagotchi(String name){
        this.name = name;
        this.age = 0;
        this.mood = maxStat;
        this.energy = maxStat;
        this.hunger = maxStat;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getMood(){
        return this.mood;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHunger() {
        return hunger;
    }

    public void setName(String name) {
        this.name = name;
    }

    //feed() increases the hunger by saturation level and ensures it does not exceed 10
    public void feed(int saturation){
        this.hunger = increaseStat(this.hunger, saturation);
        this.mood = increaseStat(this.mood, 1);
    }

    // play
    public void play(int satisfaction){
        this.mood = increaseStat(this.mood, satisfaction);
        this.energy = decreaseStat(this.energy, 2);
    }
    //energy
    public void sleep(int energy){
        this.energy = increaseStat(this.energy, energy);
    }

    private int increaseStat(int currentStat, int amount){
        if(currentStat + amount > maxStat){
            return this.maxStat;
        }else {
            return currentStat + amount;
        }
    }

    private int decreaseStat(int currentStat, int amount){
        if(currentStat - amount < this.minStat){
            return this.minStat;
        }else {
            return currentStat - amount;
        }
    }

    public void advanceHour(){
            this.hunger = decreaseStat(this.hunger, 1);
            this.mood = decreaseStat(this.mood, 1);
            this.energy = decreaseStat(this.energy, 1);
    }

    public String toString(){
        return "name=" + this.name + ", age=" + this.age + ", mood=" + this.mood + ", energy=" + this.energy + ", hunger=" + this.hunger;
    }

    public void printSleep(){

    }

    public String printFigure() {
        return "( . .  )";
    }

    protected String getItem(int num, String[] stringArray){
        return stringArray[num % stringArray.length];
    }

    public String makeSound(){
        return "...";
    }

    public void incrementAge(){
        this.age++;
    }
}
