import java.io.IOException;
import java.util.Random;


public class Main {
    public static void main(String[] args)throws IOException{
        //Temporary creation of characters, can be deleted
        Character char1 = new Warrior("guerrero",180,12,2);
        Character char2  = new Wizard("wizard",100,12,2);

        //Logs (as storytelling) begin
        System.out.println("Welcome to the Binary Realms.\n");
        System.out.println("In a land where legends are forged and destinies entwined.\n");
        System.out.println("Amidst the dappled shadows, beneath the canopy's verdant embrace, two figures emerge.\n");
        System.out.println("Their resolve as unyielding as the ancient oaks that watch over their battle.\n");
        //Call for the method that will do the combat
        combat(char1,char2);
    }


    public static void combat(Character char1, Character char2){

        boolean finished = false;
        int roundCounter = 1;

        Character initChar1 = char1.clone();
        System.out.printf("Amidst the swirling mists of fate %s emerges, a harbinger of challenge and strife.", initChar1.getName());

        Character initChar2 = char2.clone();
        System.out.printf("And so does %s, a shadow cast from the depths of adversity.", initChar2.getName());

        //Loop until one of the character wins
        while(!finished){

            //Loop for the battle
            while(char1.isAlive()&&char2.isAlive()){
                System.out.printf("=========== ROUND %d =========== \n", roundCounter);
                roundCounter += 1;
                char1.attack(char2);
                System.out.println(char1.getName() + " attacks.");
                char2.attack(char1);
                System.out.println(char2.getName() + " attacks.");
                if (char1.getHp() <= 0) {
                    char1.setAlive(false);
                    System.out.println(char1.getName() + " dies.");
                }
                if (char2.getHp() <= 0) {
                    char2.setAlive(false);
                    System.out.println(char2.getName() + " dies.");
                }
            }

            //Once the battle is finished, let's check who wins the battle
            if (!char2.isAlive()&&!char1.isAlive()){
                //The battle result is a tie
                System.out.println("The battle's crescendo yields naught but a resolute tie.");
                System.out.println("Once more, the clash of titans echoes across the realm, as the cycle of battle begins anew.");
                char1=initChar1.clone();
                char2=initChar2.clone();

            }else if (!char2.isAlive()){
                //Character 2 wins the battle
                System.out.printf("The valiant %s shatters the foe, claiming victory in this epic duel!", char1.getName());
                finished = true;
            }else if(!char1.isAlive()){
                //Character 1 wins the battle
                System.out.printf("The valiant %s shatters the foe, claiming victory in this epic duel!", char2.getName());
                finished = true;
            }
        }
    }
}
