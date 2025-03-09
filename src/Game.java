import models.*; //imports full package models
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Tamagotchi pet = createTamagotchi(scanner);
        System.out.println(pet);
        playGame(scanner, pet);

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

    private static void playGame(Scanner scanner, Tamagotchi pet){
        boolean isPlaying = true;
        boolean advanceTime;
        int choice;
        int hour = 1;
        int day = 0;

        while (isPlaying){
            int hoursSleept = 0;
            System.out.println(pet.printFigure());
            System.out.println(pet.getName() + " says:" + pet.makeSound());
            System.out.println("What would you like to do\n1) stats\n2) feed\n3) games\n4) lights\n5) option");
            choice = chooseMenuPoint(scanner, 5);
            switch (choice){
                case 1: {
                    System.out.println(pet);
                    break;
                }
                case 2 : {
                    feedPet(pet);
                    pet.advanceHour();
                    hoursSleept++;
                    break;
                }
                case 3: {
                    pet.play(10);
                    pet.advanceHour();
                    hoursSleept++;
                    break;
                }
                case 4: {
                    System.out.println("How many hour should " + pet.getName() + " sleep?\nsleep between 1 and 10 hours");
                    hoursSleept = chooseMenuPoint(scanner, 10);
                    pet.printSleep();
                    for(int i = 0; i < hoursSleept; i++){
                        pet.sleep(hoursSleept * 3);
                        pet.advanceHour();
                    }
                    advanceTime = true;
                    break;
                }
                case 5: {
                    System.out.println("options:\n1. change your pet's name\n2. exit game");
                    int optionsChoice = chooseMenuPoint(scanner, 2);
                    if(optionsChoice == 1){
                        System.out.println("Type your pets new name:");
                        pet.setName(scanner.nextLine());
                    } else if (optionsChoice == 2) {
                        isPlaying = false;
                    }

                }
            }
                for(int i = 0; i < hoursSleept; i++) {
                    hour++;
                    System.out.println("Zzz");
                    if (hour % 24 == 0) {
                        day++;
                        pet.incrementAge();
                    }
                }
        }
    }

    private static void feedPet(Tamagotchi pet){
        pet.feed(7);
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

}
