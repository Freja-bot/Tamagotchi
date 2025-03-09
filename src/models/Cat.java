package models;


import java.util.Random;

public class Cat extends Tamagotchi{
    private final char backslash = (char) 92;
    private final String ears = "  '  '";
    private final String[] heads = {"{. .  }", "{ * * }", "{  . .}", "{ ^ ^ }", "{  " + (char) 34 + " }"};
    private final String body = "/    " + backslash;
    private final String[] tails = {" /^", " /'", " )", " 7"};
    private final String legs = backslash + "_||_/";

    public Cat(String name){
        super(name);
    }

    public String printFigure(){
        Random rng = new Random();
        return ears + '\n' + super.getItem(rng.nextInt(10), heads) + '\n' + body +
                getItem(rng.nextInt(10), tails) + '\n' + legs;
    }

    public void printSleep(){
        System.out.println("'  ' __\n{~ ~}__)");
    }

    public String makeSound(){
        return "Meow";
    }

}
