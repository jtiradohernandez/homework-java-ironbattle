import java.io.IOException;


public class Main {
    public static void main(String[] args)throws IOException{
        //Temporary creation of characters, can be deleted
        Character char1 = new Warrior("Darius",180,12,2);
        Character char2  = new Wizard("Lux",100,12,2);
        Bard bard = new Bard();

        //Logs (as storytelling) begin
        bard.introducesStory();
        //Call for the method that will do the combat
        combat(char1,char2);
    }


    public static void combat(Character char1, Character char2){

        boolean finished = false;
        int roundCounter = 1;
        Bard bard = new Bard();

        Character initChar1 = char1.clone();
        bard.introducesFirstOpponent(initChar1.getName(), initChar1.getCharacterClass());

        Character initChar2 = char2.clone();
        bard.introducesSecondOpponent(initChar2.getName(), initChar2.getCharacterClass());

        //Loop until one of the character wins
        while(!finished){

            //Loop for the battle
            while(char1.isAlive() && char2.isAlive()){
                bard.announcesRound(roundCounter);
                roundCounter += 1;
                char1.attack(char2);
                bard.narratesAttack(char1.getName(), char1.getAttackName(), char1.getDamageDealt());
                bard.narratesHp(char2.getName(), char2.getHp());
                char2.attack(char1);
                bard.narratesAttack(char2.getName(), char2.getAttackName(), char2.getDamageDealt());
                bard.narratesHp(char1.getName(), char1.getHp());
                if (char1.getHp() <= 0) {
                    char1.setAlive(false);
                    bard.announcesOpponentDeath(char1.getName());
                }
                if (char2.getHp() <= 0) {
                    char2.setAlive(false);
                    bard.announcesOpponentDeath(char2.getName());
                }
            }

            //Once the battle is finished, let's check who wins the battle
            if (!char2.isAlive()&&!char1.isAlive()){
                //The battle result is a tie
                bard.announcesTie();
                roundCounter = 0;
                char1=initChar1.clone();
                char2=initChar2.clone();

            }else if (!char2.isAlive()){
                //Character 2 wins the battle
                bard.announcesOpponentVictory(char1.getName());
                finished = true;
            }else if(!char1.isAlive()){
                //Character 1 wins the battle
                bard.announcesOpponentVictory(char2.getName());
                finished = true;
            }
        }
    }
}
