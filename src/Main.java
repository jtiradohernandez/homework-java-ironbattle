import java.io.IOException;
import java.util.Random;

public static void main(String[] args)throws IOException{
  ImportCharactersFromCSV.importCharactersFromCSV();
        //Temporary creation of characters, can be deleted
        Character char1 = new Warrior("guerrero",180,12,2);
        Character char2  = new Wizard("wizard",100,12,2);

        //Call for the method that will do the combat
        combat(char1,char2);
    }


    public static void combat(Character char1, Character char2){
        boolean finished = false;
        Character initChar1 = char1.clone();
        Character initChar2 = char2.clone();

        //Loop until one of the character wins
        while(!finished){

            //Loop for the battle
            while(char1.isAlive()&&char2.isAlive()){
                char1.attack(char2);
                char2.attack(char1);
                if (char1.getHp() <= 0) {
                    char1.setAlive(false);
                }
                if (char2.getHp() <= 0) {
                    char2.setAlive(false);
                }
            }

            //Once the battle is finished, let's check who wins the battle
            if (!char2.isAlive()&&!char1.isAlive()){
                //The battle result is a tie
                System.out.println("The battle results in a tie! The battle will be repeated");
                char1=initChar1.clone();
                char2=initChar2.clone();

            }else if (!char2.isAlive()){
                //Character 2 wins the battle
                System.out.println("The player "+char1.getName()+" wins the battle!");
                finished = true;
            }else if(!char1.isAlive()){
                //Character 1 wins the battle
                System.out.println("The player "+char2.getName()+" wins the battle!");
                finished = true;
            }
        }