package fr.ecolenum.dd.Case.Enemy;

import fr.ecolenum.dd.Case.Case;

/**
 * Abstract class enemy never instantiate usef as a template for all type of enemy object
 */
public abstract class Ennemy extends Case {
    private String name;
    private int damage;
    private int life;

    /**
     * Enemy constructor
     * @param number used to define position of the object in table
     * @param enemyName used to define enemy's name
     * @param enemyDamage used to define enemy's damage
     * @param enemyLife used to define enemy's life
     */
    public Ennemy(int number,String enemyName, int enemyDamage, int enemyLife){
        super(number, "enemy");
        this.name = enemyName;
        this.damage = enemyDamage;
        this.life = enemyLife;
    }



    public int getDamageEnemy(){
        return this.damage;
    }
    public String getNameEnemy(){
        return this.name;
    }
    public int getLifeEnemy(){
        return this.life;
    }
    public int setLifeEnemy(int enemyLife){
        return this.life = enemyLife;
    }
    public String toString(){
        return "[ N°CASE : " + getCaseNumber() + " ]\n" +
                "| TYPE : " + getCaseContent() + " |\n" +
                "| NAME : " + getNameEnemy() + " |\n" +
                "| LIFE : " + getLifeEnemy() + " |\n" +
                "| POWER : " + getDamageEnemy() + " |";
    }
}
