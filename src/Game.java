import models.*; //imports full package models
import java.io.File;
import java.io.IOException;

public class Game {
    public static void main(String[] args) {

        int hour = 0;

        Tamagotchi test = new Tamagotchi("Woof");
        System.out.println(test);
        test.feed(6);
        for(int i = 0; i < 16; i++){
            test.advanceHour();
        }
        test.feed(8);
        test.feed(8);
        test.feed(8);
        test.play(12);
        for(int i = 0; i < 4; i++){
            test.sleep(2);
            test.advanceHour();
        }
        System.out.println(test);

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
