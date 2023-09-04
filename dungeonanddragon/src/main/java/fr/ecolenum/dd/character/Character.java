package fr.ecolenum.dd.character;

/**
 * This class concerne Character and cannot be Instancied you have to instance Warrior or Wizzard
 */
public abstract class Character {
    public int getDamage;
    private String name;
    private final String defense;
    private  int life;
    private final int max_Life;
    private  int forceAttack;
    private final int max_forceAttack;


    /**
     * Default constructor character
     * @param characterName the name of the character
     * @param characterLife the life of the character
     * @param characterForceAttack the ForceAttack of the character
     * @param defenseCharacter the Defense of the character
     * @param maxCharacterforceAttack The max force attack of the character
     * @param maxCharacterLife the max life of the character
     */
    public  Character(String characterName, int characterLife, int characterForceAttack, String defenseCharacter, int maxCharacterforceAttack, int maxCharacterLife) {
        this.name = characterName;
        this.life = characterLife;
        this.forceAttack = characterForceAttack;
        this.defense = defenseCharacter;
        this.max_forceAttack = maxCharacterforceAttack;
        this.max_Life = maxCharacterLife ;
    }

    /**
     * 2nd constructor character without param constructor used when default character created
     */
    public  Character() {
        this.name = "DefaultCharacter";
        this.life = 5;
        this.forceAttack = 5;
        this.defense = "Shield";
        this.max_Life = 150;
        this.max_forceAttack = 20;
    }
    public String getName(){
        return this.name;
    }
    public String setName(String name){
        return this.name = name;
    }

    public int getLife(){
        return this.life;
    }
    public void setLife(int characterLife){
        this.life = characterLife;
    }
    public int getForceAttack(){
        return this.forceAttack;
    }
    public void setForceAttack(int improvementFactor){
        this.forceAttack = improvementFactor;
    }
    public String getDefense(){
        return this.defense;
    }

    public int getMax_Life(){
        return this.max_Life;
    }
    public int getMax_forceAttack(){
        return this.max_forceAttack;
    }

    public String toString(){
        return "{ Name :" + getName()+" "+"Life :"+getLife()+" "+"Attack :"+getForceAttack()+" " +"Defense :"+ getDefense() + " }";
    }
}
