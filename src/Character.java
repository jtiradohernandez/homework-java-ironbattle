import java.util.Random;
import java.util.UUID;

public abstract class Character implements Attacker {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;
    private String characterClass;

    private Team team;

    public Character(String name, int hp){
        setName(name);
        setHp(hp);
        setId();
    }

    public Character(String name){
        setName(name);
        setId();
    }

    public String getId() {
        return this.id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public abstract Character clone();

    public abstract void attack(Character character);

    public static int randomInt (int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getCharacterClass() {
        return this.characterClass;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}