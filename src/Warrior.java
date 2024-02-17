import java.util.Random;

public class Warrior extends Character {
    private int stamina;
    private int strength;
    private static final int[] STAMINA_RANGE = {10, 50};
    private final int[] STRENGTH_RANGE = {1, 10};
    private final int[] HP_RANGE = {100, 200};
    private final int HEAVY_ATTACK_STAMINA = 5;
    private static final String[] warriorsNames = new String[]{"Aragorn", "Xena", "Conan", "Mulán", "Wonder Woman", "Samurai Jack", "Thor", "Brienne of Tarth", "Leonidas", "Boudica", "Legolas", "Joan of Arc", "Beowulf", "Attila the Hun", "Cleopatra", "Genghis Khan", "Hua Mulan", "William Wallace", "Ragnar Lothbrok", "Sun Tzu", "Zaraki Kenpachi", "Khal Drogo", "King Arthur", "Spartacus", "Achilles", "Okoye", "Captain America", "Black Panther"};

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name);
        if (hp < HP_RANGE[0] || hp > HP_RANGE[1]) {
            throw new IllegalArgumentException("HP must be between " + HP_RANGE[0] + " and " + HP_RANGE[1]);
        } else {
            setHp(hp);
        }
        if (stamina < STAMINA_RANGE[0] || stamina > STAMINA_RANGE[1]) {
            throw new IllegalArgumentException("Stamina must be between " + STAMINA_RANGE[0] + " and " + STAMINA_RANGE[1]);
        } else {
            setStamina(stamina);
        }
        if (strength < STRENGTH_RANGE[0] || strength > STRENGTH_RANGE[1]) {
            throw new IllegalArgumentException("Strength must be between " + STRENGTH_RANGE[0] + " and " + STRENGTH_RANGE[1]);
        } else {
            setStrength(strength);
        }
    }

    public Warrior() {
        super(randomName());
        setHp(randomInt(HP_RANGE[0], HP_RANGE[1]));
        setStamina(randomInt(STAMINA_RANGE[0], STAMINA_RANGE[1]));
        setStrength(randomInt(STRENGTH_RANGE[0], STRENGTH_RANGE[1]));
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

    @Override
    public void attack(Character character) {
        if (getStamina() == 0) {
            setStamina(getStamina() + 2);
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

    @Override
    public Character clone() {
        return new Warrior(getName(), getHp(), getStamina(), getStrength());
    }

    @Override
    public String getCharacterClass() {
        return "warrior";
    }

    public void heavyAttack(Character character) {
        final int HP_LOSS = getStrength();

        setStamina(getStamina() - HEAVY_ATTACK_STAMINA);
        character.setHp(character.getHp() - HP_LOSS);
        Bard.narratesAttack(this, "launches a heavy attack ⚔\uFE0F", HP_LOSS);
    }

    public void weakAttack(Character character) {
        final int STAMINA_RECOVER = 1;
        final int HP_LOSS = getStrength() / 2;

        setStamina(getStamina() + STAMINA_RECOVER);
        character.setHp(character.getHp() - HP_LOSS);
        Bard.narratesAttack(this, "launches a weak attack \uD83D\uDD2A", HP_LOSS);
    }

    public static String randomName() {
        Random random = new Random();
        return warriorsNames[random.nextInt(warriorsNames.length)];
    }
}
