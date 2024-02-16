import java.util.Random;

// A Warrior is a Character that fights by attacking. Attacks inflict damage and in order to do one,
// stamina is required.
public class Warrior extends Character {
    private int stamina;
    private int strength;
    private final int STAMINA_MIN = 10;
    private final int STAMINA_MAX = 50;
    private final int STRENGTH_MIN = 1;
    private final int STRENGTH_MAX = 10;
    private final int HP_MIN = 100;
    private final int HP_MAX = 200;
    private final int HEAVY_ATTACK_STAMINA = 5;
    private static final String[] warriorsNames = new String[]{"Aragorn", "Xena", "Conan", "Mulán", "Wonder Woman", "Samurai Jack", "Thor", "Brienne of Tarth", "Leonidas", "Boudica", "Legolas", "Joan of Arc", "Beowulf", "Attila the Hun", "Cleopatra", "Genghis Khan", "Hua Mulan", "William Wallace", "Ragnar Lothbrok", "Sun Tzu", "Zaraki Kenpachi", "Khal Drogo", "King Arthur", "Spartacus", "Achilles", "Okoye", "Captain America", "Black Panther"};

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name);
        if(hp < HP_MIN || hp > HP_MAX) {
            throw new IllegalArgumentException("HP must be between " + HP_MIN + " and " + HP_MAX);
        } else {
            setHp(hp);
        }
        if(stamina < STAMINA_MIN || stamina > STAMINA_MAX) {
            throw new IllegalArgumentException("Stamina must be between " + STAMINA_MIN + " and " + STAMINA_MAX);
        } else {
            setStamina(stamina);
        }
        if(strength < STRENGTH_MIN || strength > STRENGTH_MAX) {
            throw new IllegalArgumentException("Strength must be between " + STRENGTH_MIN + " and " + STRENGTH_MAX);
        } else {
            setStrength(strength);
        }
        setCharacterClass("warrior");
    }

    public Warrior() {
        super(randomName());
        setHp(randomInt(HP_MIN, HP_MAX));
        setStamina(randomInt(STAMINA_MIN, STAMINA_MAX));
        setStrength(randomInt(STRENGTH_MIN, STRENGTH_MAX));
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHp(int hp) {
        super.setHp(hp);
    }

    @Override
    public void attack(Character character) {
        if (getStamina() == 0) {
            setStamina(getStamina()+2);
            Bard.narratesRest(this);
        } else if (getStamina() < HEAVY_ATTACK_STAMINA) {
            weakAttack(character);
        } else {
            int randomNum = rollDice();

            if (randomNum < 4) {
                weakAttack(character);
            } else {
                heavyAttack(character);
            }
        }
    }

    public Character clone(){return new Warrior(getName(), getHp(), getStamina(),getStrength());}

    public void heavyAttack(Character character) {
        final int HP_LOSS = getStrength();

        setStamina(getStamina()-HEAVY_ATTACK_STAMINA);
        character.setHp(character.getHp() - HP_LOSS);
        Bard.narratesAttack(this, "launches a heavy attack ⚔\uFE0F", HP_LOSS);
    }

    public void weakAttack(Character character) {
        final int STAMINA_RECOVER = 1;
        final int HP_LOSS = getStrength() / 2;

        setStamina(getStamina()+STAMINA_RECOVER);
        character.setHp(character.getHp()-HP_LOSS);
        Bard.narratesAttack(this, "launches a weak attack \uD83D\uDD2A", HP_LOSS);
    }

    public static String randomName() {
        Random random = new Random();
        return warriorsNames[random.nextInt(warriorsNames.length)];
    }
}
