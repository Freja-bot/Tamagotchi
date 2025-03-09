package models;

public class Tamagotchi {
    private String name;
    private int age;
    private int mood;
    private int energy;
    private int hunger;
    private final int maxStat = 100;

    public Tamagotchi(String name){
        this.name = name;
        this.age = 0;
        this.mood = 100;
        this.energy = 100;
        this.hunger = 10;
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

    public void feed(int saturation){
        if(this.hunger + saturation > maxStat){
            this.hunger = maxStat;
        }else {
            this.hunger += saturation;
        }
        increaseMood(10);
    }

    public void play(int satisfaction){
        increaseMood(30);
    }

    private void decreaseEnergy(int amount){
        if(this.energy - amount < 0){
            this.energy = maxStat;
        }else {
            this.energy -= amount;
        }
    }

    private void increaseMood(int amount){
        if(this.mood + amount > maxStat){
            this.mood = maxStat;
        }else {
            this.mood += amount;
        }
    }

    public void updateTamagotchhi(){
        if(this.hunger != 0){
            this.hunger -= 1;
        }
        if(this.mood != 0){
            this.mood -= 1;
        }
        if(this.energy != 0){
            this.energy -= 1;
        }
    }

    public String toString(){
        return "name=" + this.name + ", age=" + this.age + ", mood=" + this.mood + ", energy=" + this.energy + ", hunger=" + this.hunger;
    }

}
