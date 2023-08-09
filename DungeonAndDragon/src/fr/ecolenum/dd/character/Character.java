package fr.ecolenum.dd.character;

public abstract class Character {
    private String name;
    private   String defense;
    private  int life;

    private  int max_Life;
    private  int forceAttack;

    private  int max_forceAttack;



    public  Character(String characterName, int characterLife, int characterForceAttack, String defenseCharacter) {
        this.name = characterName;
        this.life = characterLife;
        this.forceAttack = characterForceAttack;
        this.defense = defenseCharacter;
        this.max_Life = 150;
        this.max_forceAttack = 20;
    }
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

    public int getMax_Life(){
        return this.max_Life;
    }
    public int getMax_forceAttack(){
        return this.max_forceAttack;
    }

    public String toString(){
        return "{" +"Name :" + getName()+" "+"Life :"+getLife()+" "+"Attack :"+getForceAttack()+" " +"Defense:"+ getDefense() + "Max force attack"+ getMax_forceAttack() + "Max_Life"+ getMax_Life();
    }
}
