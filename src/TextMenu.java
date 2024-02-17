import java.util.InputMismatchException;
import java.util.Scanner;

public class TextMenu {
    private static String getIntroText (int selection){
        String output = "";
        switch (selection) {
            case 0:
                output=
                                "╔══════════════════════════════════════════════╗\n" +
                                "║      Welcome to the RPG Battle Simulator!    ║\n" +
                                "║                                              ║\n" +
                                "║ Get ready for an adrenaline-pumping battle   ║\n" +
                                "║ between two fierce warriors                  ║\n" +
                                "║ Let's find the ultimate victor.              ║\n" +
                                "║                                              ║\n" +
                                "║                                              ║\n" +
                                "║                                              ║\n" +
                                "║                                              ║\n" +
                                "╚══════════════════════════════════════════════╝";
                break;
            case 1:
                output=
                        "PPPPPP   RRRRRR  EEEEEEE PPPPPP  AAAAA   RRRRRR  EEEEEEE\n" +
                                "PP   PP  RR   RR EE      PP   PP AA   AA  RR   RR EE    \n" +
                                "PPPPPP   RRRRRR  EEEEE   PPPPPP  AAAAAAA RRRRRR  EEEEE  \n" +
                                "PP       RR  RR  EE      PP      AA   AA RR  RR  EE     \n" +
                                "PP       RR   RR EEEEEEE PP      AA   AA RR   RR EEEEEEE";
                break;
            case 2:
                output=
                        "FFFFF   OOO   RRRR\n" +
                        "F      O   O  R   R\n" +
                        "FFF    O   O  RRRR\n" +
                        "F      O   O  R R\n" +
                        "F       OOO   R  RR";
                break;
            case 3:
                output=
                        "BBBB   AAAAA  TTTTTTT TTTTTTT L      EEEEE\n" +
                        "B   B  A   A    T       T     L      E\n" +
                        "BBBB   AAAAA    T       T     L      EEEE\n" +
                        "B   B  A   A    T       T     L      E\n" +
                        "BBBB   A   A    T       T     LLLLL  EEEEE";
                break;
            case 4:
                output=  "+-------+  \n" +
                         "/       /| \n" +
                         "+-------+ |\n" +
                         "|       | +\n" +
                         "|       |/ \n" +
                         "+-------+  \n"+
                         "Roll the dice  \n";
                break;
        }
      return output;
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");

        }
        System.out.flush();
    }

    public static void safeWait(int milliseconds) {
        try {
            Thread.sleep(milliseconds); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            System.out.println("Error Ocurr");
        }
    }

    public static void printBigText(int milliseconds, int option){
        System.out.println(getIntroText(option));
        safeWait(milliseconds);
        clearConsole();
    }


}
