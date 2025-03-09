package models;

import java.util.Random;

public class Dog extends Tamagotchi{
    private final char backslash = (char) 92;
    private final String ears = "    __";
    private final String[] heads = {"(/(* *)" + backslash + ")", "(/(. .)" + backslash + ")", "(/(^ ^)" + backslash + ")"};
    private final String body = "  /    " + backslash;
    private final String legs = " (|---|)__";

    public Dog(String name){
        super(name);
    }

    public String printFigure(){
        Random rng = new Random();
        return ears + '\n' + getItem(rng.nextInt(10), heads) + '\n' + body + '\n' + legs;
    }

    public void PrintSleep(){
        System.out.println("    __   __\n" + "(/(~ ~)" + backslash + ")__}");
    }

    public String makeSound(){
        return "woof";
    }
}
