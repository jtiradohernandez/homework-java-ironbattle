import java.util.Random;

public class Wizard extends Character {
    private int mana;
    private int intelligence;
    private static final int[] HP_RANGE = {50, 100};
    private static final int[] MANA_RANGE = {10, 50};
    private static final int[] INTELLIGENCE_RANGE = {1, 50};
    private final int FIREBALL_MANA = 5;
    private static final String[] wizardsNames = new String[]{"Merlin", "Gandalf", "Severus", "Alatar", "Dumbledore", "Rincewind", "Voldemort", "Albus", "Asterope", "Astra", "Atlantes", "Beatrix", "Belinda", "Fawley", "Glinda", "Gwydion", "Jadis", "Jareth", "Morgan", "Potter", "Prospero", "Radagast", "Saruman", "Thoth-Amon"};

    public enum PropertyWizard{
        HP, MANA, INTELLIGENCE
    }

    public static boolean validateInputByType(PropertyWizard property_wizard, int property_value) {
        switch (property_wizard) {
            case HP:
                if (property_value < HP_RANGE[0] || property_value > HP_RANGE[1]) {
                    System.err.println("HP must be between " + HP_RANGE[0] + " and " + HP_RANGE[1]);
                    return false;
                }
                break;
            case MANA:
                if (property_value < MANA_RANGE[0] || property_value > MANA_RANGE[1]) {
                    System.err.println("Mana must be between " + MANA_RANGE[0] + " and " + MANA_RANGE[1]);
                    return false;
                }
                break;
            case INTELLIGENCE:
                if (property_value < INTELLIGENCE_RANGE[0] || property_value > INTELLIGENCE_RANGE[1]) {
                    System.err.println("Intelligence must be between " + INTELLIGENCE_RANGE[0] + " and " + INTELLIGENCE_RANGE[1]);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }
    public static boolean validateInput(int hp, int mana, int intelligence){
        if (hp < HP_RANGE[0] || hp > HP_RANGE[1]) {
            System.err.println("HP must be between " + HP_RANGE[0] + " and " + HP_RANGE[1]);
            return false;
        } else if (mana < MANA_RANGE[0] || mana > MANA_RANGE[1]) {
            System.err.println("Mana must be between " + MANA_RANGE[0] + " and " + MANA_RANGE[1]);
            return false;
        } else if (intelligence < INTELLIGENCE_RANGE[0] || intelligence > INTELLIGENCE_RANGE[1]) {
            System.err.println("Intelligence must be between " + INTELLIGENCE_RANGE[0] + " and " + INTELLIGENCE_RANGE[1]);
            return false;
        }
        return true;
    }
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name);
        if (validateInput(hp,mana,intelligence)){
            setHp(hp);
            setMana(mana);
            setIntelligence(intelligence);
        }
        else{
            throw new IllegalArgumentException("Invalid arguments Exception");
        }
    }
    public void get_info(){
        System.out.println("***** Wizard Character *****"+"\n");
        System.out.println("Name: "+ getName()+" ");
        System.out.println("Mana: "+ getMana()+" ");
        System.out.println("Hp: "+ getHp()+" ");
        System.out.println("Intelligence: "+ intelligence+"\n");

    }

    public Wizard() {
        super(randomName(), randomInt(HP_RANGE[0], HP_RANGE[1]));
        setMana(randomInt(MANA_RANGE[0], MANA_RANGE[1]));
        setIntelligence(randomInt(INTELLIGENCE_RANGE[0], INTELLIGENCE_RANGE[1]));
    }

    public static int[] getHP_RANGE(){
        return HP_RANGE;
    }

    public static int[] getMANA_RANGE(){
        return MANA_RANGE;
    }

    public static int[] getINTELLIGENCE_RANGE(){
        return INTELLIGENCE_RANGE;
    }

    public int getMana() {
        return this.mana;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character character) {
        if (getMana() == 0) {
            setMana(getMana() + 2);
        } else if (getMana() < FIREBALL_MANA) {
            staffHit(character);
        } else {
            int randomNum = rollDice();

            if (randomNum < 4) {
                staffHit(character);
            } else {
                fireball(character);
            }
        }
    }

    @Override
    public Character clone() {
        return new Wizard(getName(), getHp(), getMana(), getIntelligence());
    }

    @Override
    public CharacterClass getCharacterClass() {
        return CharacterClass.WIZARD;
    }

    private void fireball(Character character) {
        final int HP_LOSS = getIntelligence();
        setMana(getMana() - FIREBALL_MANA);
        character.setHp(character.getHp() - HP_LOSS);
        Bard.narratesAttack(this, "casts a fireball \uD83D\uDD25", HP_LOSS);
    }

    private void staffHit(Character character) {
        final int MANA_RECOVER = 1;
        final int HP_LOSS = 2;

        setMana(getMana() + MANA_RECOVER);
        character.setHp(character.getHp() - HP_LOSS);
        Bard.narratesAttack(this, "executes a staff hit \uD83E\uDDF9", HP_LOSS);
    }


    public static String randomName() {
        Random random = new Random();
        return wizardsNames[random.nextInt(wizardsNames.length)];
    }
}
