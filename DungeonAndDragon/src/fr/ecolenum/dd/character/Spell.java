package fr.ecolenum.dd.character;

public class Spell {
    private String name;
    private String damage;


    public Spell (){
        this.name = "masse";
        this.damage = "8-10";
    }


    //--------------------Degats-------------------
    //->GETTER<-
    public String getDamageSpell(){
        return this.damage;
    }

    //--------------------Sort-------------------
    //->GETTER<-
    public String getNameSpell(){
        return this.name;
    }
}



