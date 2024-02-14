import java.util.Objects;
import java.util.Random;

public class RandomChar {

    public static Character createRandomChar() {
        String charType = randomCharType();
        System.out.println(charType);
        return Objects.equals(charType, "Wizard") ? new Wizard() : new Warrior();
    }

    public static String randomCharType() {
        Random random = new Random();
        int faceDice = random.nextInt(6) + 1;

        return faceDice%2 == 0 ? "Wizard" : "Warrior";
    }
}
