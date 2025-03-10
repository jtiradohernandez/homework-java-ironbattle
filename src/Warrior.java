import java.util.Random;

public class Warrior extends Character {
    private int stamina;
    private int strength;
    private static final int[] STAMINA_RANGE = {10, 50};
    private static final int[] STRENGTH_RANGE = {1, 10};
    private static final int[] HP_RANGE = {100, 200};
    private final int HEAVY_ATTACK_STAMINA = 5;
    private static final String[] warriorsNames = new String[]{"Aragorn", "Xena", "Conan", "Mulán", "Wonder Woman", "Samurai Jack", "Thor", "Brienne of Tarth", "Leonidas", "Boudica", "Legolas", "Joan of Arc", "Beowulf", "Attila the Hun", "Cleopatra", "Genghis Khan", "Hua Mulan", "William Wallace", "Ragnar Lothbrok", "Sun Tzu", "Zaraki Kenpachi", "Khal Drogo", "King Arthur", "Spartacus", "Achilles", "Okoye", "Captain America", "Black Panther"};

    public enum PropertyWarrior{
        HP, STAMINA, STRENGTH
    }
    public static boolean validateInputByType(PropertyWarrior property_warrior, int property_value) {
        switch (property_warrior) {
            case HP:
                if (property_value < HP_RANGE[0] || property_value > HP_RANGE[1]) {
                    System.err.println("HP must be between " + HP_RANGE[0] + " and " + HP_RANGE[1]);
                    return false;
                }
                break;
            case STAMINA:
                if (property_value < STAMINA_RANGE[0] || property_value > STAMINA_RANGE[1]) {
                    System.err.println("Stamina must be between " + STAMINA_RANGE[0] + " and " + STAMINA_RANGE[1]);
                    return false;
                }
                break;
            case STRENGTH:
                if (property_value < STRENGTH_RANGE[0] || property_value > STRENGTH_RANGE[1]) {
                    System.err.println("Strength must be between " + STRENGTH_RANGE[0] + " and " + STRENGTH_RANGE[1]);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }
    public static boolean validateInput(int hp, int stamina, int strength){
        if (hp < HP_RANGE[0] || hp > HP_RANGE[1]) {
            System.err.println("HP must be between " + HP_RANGE[0] + " and " + HP_RANGE[1]);
            return false;
        } else if (stamina < STAMINA_RANGE[0] || stamina > STAMINA_RANGE[1]) {
            System.err.println("Stamina must be between " + STAMINA_RANGE[0] + " and " + STAMINA_RANGE[1]);
            return false;
        } else if (strength < STRENGTH_RANGE[0] || strength > STRENGTH_RANGE[1]) {
            System.err.println("Strength must be between " + STRENGTH_RANGE[0] + " and " + STRENGTH_RANGE[1]);
            return false;
        }
        return true;
    }
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name);
        if (validateInput(hp,stamina,strength)){
            setHp(hp);
            setStamina(stamina);
            setStrength(strength);

        }
        else{
            throw new IllegalArgumentException("Invalid arguments Exception");
        }
    }

    public Warrior() {
        super(randomName());
        setHp(randomInt(HP_RANGE[0], HP_RANGE[1]));
        setStamina(randomInt(STAMINA_RANGE[0], STAMINA_RANGE[1]));
        setStrength(randomInt(STRENGTH_RANGE[0], STRENGTH_RANGE[1]));
    }

    public static int[] getHP_RANGE(){
        return HP_RANGE;
    }

    public static int[] getSTRENGTH_RANGE(){
        return STRENGTH_RANGE;
    }

    public static int[] getSTAMINA_RANGE(){
        return STAMINA_RANGE;
    }

    public void get_info(){
        System.out.println("***** Warrior Character ***** \n");
        System.out.println("Name: "+ getName()+" ");
        System.out.println("Stamina: "+ getStamina()+" ");
        System.out.println("Hp: "+ getHp()+" ");
        System.out.println("Strength: "+ getStrength()+"\n");
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
    public CharacterClass getCharacterClass() {
        return CharacterClass.WARRIOR;
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
