public class Bard {
    public void introducesStory() {
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
    public void introducesFirstOpponent(String firstOpponentName) {
        System.out.printf("Amidst the swirling mists of fate %s emerges, a harbinger of challenge and strife.\n", firstOpponentName);
    }
    public void introducesSecondOpponent(String secondOpponentName) {
        System.out.printf("And so does %s, a shadow cast from the depths of adversity.\n", secondOpponentName);
    }
    public void announcesRound(int roundNumber) {
        System.out.printf("=========== ROUND %d ===========\n", roundNumber);
    }
    public void narratesAttack(String opponentName) {
        System.out.printf("%s attacks\n", opponentName);
    }
    public void announcesOpponentDeath(String opponentName) {
        System.out.printf("Alas, the noble %s succumbs to fate's cruel embrace and dies.\n", opponentName);
    }
    public void announcesOpponentVictory(String opponentName) {
        System.out.printf("The valiant %s shatters the foe, claiming victory in this epic duel!", opponentName);
    }
    public void announcesTie() {
        System.out.println("The battle's crescendo yields naught but a resolute tie.\n" +
                "Once more, the clash of titans echoes across the realm, as the cycle of battle begins anew.\n");
    }
}
