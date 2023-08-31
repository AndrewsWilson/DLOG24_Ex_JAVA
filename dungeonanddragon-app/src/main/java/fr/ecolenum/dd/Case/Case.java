package fr.ecolenum.dd.Case;

public abstract class Case {
    private int caseNumber;
    private String caseContent;
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
