package jeux;

public abstract class Character {
    private String name;
    private   String defense;
    private  int life;
    private  int forceAttack;

    public  Character(String characterName, int characterLife, int characterForceAttack, String defenseCharacter) {
        this.name = characterName;
        this.life = characterLife;
        this.forceAttack = characterForceAttack;
        this.defense = defenseCharacter;
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
    public int setLife(int characterLife){
        return this.life = characterLife;
    }
    public int getForceAttack(){
        return this.forceAttack;
    }
    public int setForceAttack(int characterForceAttack){
        return this.forceAttack = characterForceAttack;
    }
    public String getDefense(){
        return this.defense;
    }
    public String toString(){
        return "{" +"Name :" + getName()+" "+"Life :"+getLife()+" "+"Attack :"+getForceAttack()+" " +"Defense:"+ getDefense() + "";
    }
}
