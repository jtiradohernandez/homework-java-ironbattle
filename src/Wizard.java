public class Wizard extends Character {
    private int mana;
    private int intelligence;
    private final int[] MANA_RANGE = {10, 50};
    private final int[] INTELLIGENCE_RANGE = {1, 50};
    private final int FIREBALL_MANA = 5;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp); //TODO: check hp range (50-100)
        setMana(mana);
        setIntelligence(intelligence);
    }

    public int getMana() {
        return this.mana;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setMana(int mana) {
        if (mana >= MANA_RANGE[0] && mana <= MANA_RANGE[1]) {
            this.mana = mana;
        }
        //TODO: if number is not in the range, call new random number
    }

    public void setIntelligence(int intelligence) {
        if (intelligence >= INTELLIGENCE_RANGE[0] && mana <= INTELLIGENCE_RANGE[1]) {
            this.intelligence = intelligence;
        }
        //TODO: if number is not in the range, call new random number
    }

    @Override
    public void attack(Character character) {
        if (getMana() == 0) {
            setMana(getMana()+2);
            setAttackName("cannot attack");
            setDamageDealt(0);
        } else if (getMana() < FIREBALL_MANA) {
            staffHit(character);
            setAttackName("executes a staff hit");
        } else {
            int randomNum = rollDice();

            if (randomNum < 4) {
                staffHit(character);
                setAttackName("executes a staff hit");
            } else {
                fireball(character);
                setAttackName("casts a fireball");
            }
        }
    }

    public Character clone(){return new Wizard(getName(), getHp(), getMana(),getIntelligence());}

    private void fireball(Character character) {
        setMana(getMana()-FIREBALL_MANA);
        character.setHp(character.getHp()-getIntelligence());
        setDamageDealt(getIntelligence());
    }

    private void staffHit(Character character) {
        final int MANA_RECOVER = 1;
        final int HP_LOSS = 2;

        setMana(getMana()+MANA_RECOVER);
        character.setHp(character.getHp()-HP_LOSS);
        setDamageDealt(HP_LOSS);
    }
}
