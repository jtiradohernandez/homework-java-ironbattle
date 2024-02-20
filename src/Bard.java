/* acts as a Logger */
public class Bard {
    public static void introducesStory() {
        String titleBanner = "  ____  _                          _____            _               \n" +
                " |  _ \\(_)                        |  __ \\          | |              \n" +
                " | |_) |_ _ __   __ _ _ __ _   _  | |__) |___  __ _| |_ __ ___  ___ \n" +
                " |  _ <| | '_ \\ / _` | '__| | | | |  _  // _ \\/ _` | | '_ ` _ \\/ __|\n" +
                " | |_) | | | | | (_| | |  | |_| | | | \\ \\  __/ (_| | | | | | | \\__ \\\n" +
                " |____/|_|_| |_|\\__,_|_|   \\__, | |_|  \\_\\___|\\__,_|_|_| |_| |_|___/\n" +
                "                            __/ |                                   \n" +
                "                           |___/                                    ";
        System.out.println("Welcome to the Binary Realms.\n" +
                titleBanner + "\n" +
                "In a land where legends are forged and destinies entwined.\n" +
                "Amidst the dappled shadows, beneath the canopy's verdant embrace, two figures emerge.\n" +
                "Their resolve as unyielding as the ancient oaks that watch over their battle.\n");
    }
    public static void introducesFirstOpponent(Character character) {
        System.out.printf("Amidst the swirling mists of fate %s emerges, a %s, a harbinger of challenge and strife.\n", getStyledNameForCharacter(character), character.getCharacterClass().toString().toLowerCase());
    }
    public static void introducesSecondOpponent(Character character) {
        System.out.printf("And so does %s, a %s, a shadow cast from the depths of adversity.\n",  getStyledNameForCharacter(character), character.getCharacterClass().toString().toLowerCase());
    }
    public static void announcesRound(int roundNumber) {
        System.out.printf("=========== ROUND %d ===========\n", roundNumber);
    }
    public static void narratesAttack(Character attacker, String attackName, int damageDealt) {
        System.out.printf("%s %s and deals %d damage\n", getStyledNameForCharacter(attacker), attackName, damageDealt);
    }
    public static void narratesHp(Character character) {
        System.out.printf("%s's remaining health: %d\n", getStyledNameForCharacter(character), character.getHp());
    }
    public static void announcesOpponentDeath(Character character) {
        System.out.printf("Alas, the noble %s\uD83D\uDC80 succumbs to fate's cruel embrace and dies.\n", getStyledNameForCharacter(character));
    }
    public static void announcesOpponentVictory(Character character) {
        System.out.printf("The valiant %s\uD83C\uDFC6 shatters the foe, claiming victory in this epic duel!", getStyledNameForCharacter(character));
    }
    public static void announcesTie() {
        System.out.println("The battle's crescendo yields naught but a resolute tie.\n" +
                "Once more, the clash of titans echoes across the realm, as the cycle of battle begins anew.\n");
    }
    public static void narratesRest(Character attacker) {
        System.out.printf("%s cannot attack \uD83E\uDDD8\n", getStyledNameForCharacter(attacker));
    }

    private static String getStyledNameForCharacter(Character character) {
        final String RED_COLOR = "\u001B[31m";
        final String BLUE_COLOR = "\u001B[34m";
        final String RESET_COLOR = "\u001B[0m";

        final String teamColor = character.getTeam() == Team.A ? RED_COLOR : BLUE_COLOR;

        return String.format("%s[%s]%s",teamColor, character.getName(), RESET_COLOR);
    }
}