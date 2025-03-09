import models.*; //imports full package models
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        int hour = 0;
        Scanner scanner = new Scanner(System.in);
        Tamagotchi pet = createTamagotchi(scanner);
        System.out.println(pet);

        scanner.close();
    }

    private static Tamagotchi createTamagotchi(Scanner scanner){
        Tamagotchi pet;
        String petName;
        int petType;
        System.out.println("Hello, would you like to adopt a cat or a dog?\n1) Adopt a cat\n2) Adopt a dog");

        petType = chooseMenuPoint(scanner, 2);
        System.out.println("What would you like to name your new pet?");
        petName = scanner.nextLine();

        switch (petType){
            case 1 -> pet = new Cat(petName);
            case 2 -> pet = new Dog(petName);
            default -> pet = new Tamagotchi(petName);
        }
        return pet;
    }

    private static int chooseMenuPoint(Scanner scanner, int noOfOptions){
        int input;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("invalid input! type the number with a corresponding pet");
                scanner.nextLine();
            }
            input = scanner.nextInt();
            scanner.nextLine();

        }while (input > noOfOptions || input < 1);
        return input;
    }

    /*Save data
    public static void loadFile(){
        try{
            File saveFile = new File("src/saveFile.txt");
            if(saveFile.createNewFile()){
                //ask user input and create save file
                System.out.println("SaveFile created");
            }else{
                //remove this
                System.out.println("SaveFile already exist");
            }
        }catch(IOException e){
            System.out.println("An error occurred! SaveFile.txt could not be found or created!");
        }
    }*/
}
