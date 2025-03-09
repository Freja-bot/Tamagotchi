package models;

public class Tamagotchi {
    private String name;
    private int age;
    private int mood;
    private int energy;
    private int hunger;
    private final int maxStat = 30;
    private final int minStat = 0;

    public Tamagotchi(String name){
        this.name = name;
        this.age = 0;
        this.mood = 30;
        this.energy = 30;
        this.hunger = 30;
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
        if(this.hunger != 0){
            this.hunger = decreaseStat(this.hunger, 1);
        }
        if(this.mood != 0){
            this.mood = decreaseStat(this.mood, 1);
        }
        if(this.energy != 0){
            this.energy = decreaseStat(this.energy, 1);
        }
    }

    public String toString(){
        return "name=" + this.name + ", age=" + this.age + ", mood=" + this.mood + ", energy=" + this.energy + ", hunger=" + this.hunger;
    }

}
