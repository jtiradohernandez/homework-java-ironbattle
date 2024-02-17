import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportCharactersFromCSV {
    public static ArrayList<Character> importCharactersFromCSV() throws IOException {

        try {
            // Open file and create a scanner to iterate over the lines
            File file = new File("Characters.csv");
            Scanner scanner = new Scanner(file);

            // Skip the first line, which contains headers
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            ArrayList<Character> characters_list = new ArrayList<Character>();
            // Read the lines with character data and create the characters
            while (scanner.hasNextLine()) {
                String[] characterData = scanner.nextLine().split(",", -1);
                String characterType = characterData[0];


                if (!characterType.equals("Wizard") && !characterType.equals("Warrior")) {
                    //throw new IOException("A character must be a Wizard or a Warrior");
                    System.err.println("A character must be a Wizard or a Warrior");
                }

                String name = characterData[1];
                int hp = Integer.parseInt(characterData[2]);

                if (characterType.equals("Wizard")) {
                    int mana = Integer.parseInt(characterData[3]);
                    int intelligence = Integer.parseInt(characterData[4]);
                    Character wizard = new Wizard(name, hp, mana, intelligence);
                    characters_list.add(wizard);

                }

                if (characterType.equals("Warrior")) {
                    int stamina = Integer.parseInt(characterData[5]);
                    int strength = Integer.parseInt(characterData[6]);
                    Character warrior = new Warrior(name, hp, stamina, strength);
                    characters_list.add(warrior);
                }
            }
            scanner.close();
            return characters_list;
            // Close the scanner


        } catch (FileNotFoundException fnfe) {
            System.err.println("Hey that file doesn't exist!");
        } catch (NumberFormatException numberFormatException) {
            System.err.println(numberFormatException);
        }
        return null;
    }
}