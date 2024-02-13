import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ImportCharactersFromCSV {
    public static void importCharactersFromCSV() throws IOException {

        try {
            // Open file and create a scanner to iterate over the lines
            File file = new File("Characters.csv");
            Scanner scanner = new Scanner(file);

            // Skip the first line, which contains headers
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read the lines with character data and create the characters
            while (scanner.hasNextLine()) {
                String[] characterData = scanner.nextLine().split(",", -1);
                String characterType = characterData[0];

                if (!characterType.equals("Wizard") && !characterType.equals("Warrior")) {
                    throw new IOException("A character must be a Wizard or a Warrior");
                }

                String name = characterData[1];
                int hp = Integer.parseInt(characterData[2]);

                if (characterType.equals("Wizard")) {
                    int mana = Integer.parseInt(characterData[3]);
                    int intelligence = Integer.parseInt(characterData[4]);
                    Character wizard = new Wizard(name, hp, mana, intelligence);
                }

                if (characterType.equals("Warrior")) {
                    int stamina = Integer.parseInt(characterData[5]);
                    int strength = Integer.parseInt(characterData[6]);
                    Character warrior = new Warrior(name, hp, stamina, strength);
                }
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Hey that file doesn't exist!");
        } catch (NumberFormatException numberFormatException) {
            System.err.println(numberFormatException);
        }
    }
}