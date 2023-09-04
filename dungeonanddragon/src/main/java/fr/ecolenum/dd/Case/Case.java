package fr.ecolenum.dd.Case;

/**
 * Abstract class used as a template for the object in board
 */
public abstract class Case {
    private int caseNumber;
    private String caseContent;

    /**
     * Case constructor
     * @param number used to define case number on board in object
     * @param content used to define the name of content in object
     */
    public Case(int number, String content){
        this.caseNumber = number;
        this.caseContent = content;
    }


    public int getCaseNumber(){
        return this.caseNumber;
    }
    public String getCaseContent(){
        return this.caseContent;
    }
    public String toString(){
        return "CASE{ "
                +getCaseNumber()+
                "Content : "+ getCaseContent();
    }
}
