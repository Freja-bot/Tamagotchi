import models.*; //imports full package models
import java.io.File;
import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        Tamagotchi test = new Tamagotchi("Woof");
        System.out.println(test);
        test.feed(60);
        for(int i = 0; i < 50; i++){
            test.updateTamagotchhi();
        }
        System.out.println(test);
        test.play(70);
        System.out.println(test);
    }

    //Save data
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
    }
}
