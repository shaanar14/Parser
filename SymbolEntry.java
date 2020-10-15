/*
    Project 2
    Author: Shaan Arora, C3236359
    SymbolEntry Class
    Core data structure for SymbolTable
    Stores valuable information of things like variable declarations which then gets placed into a SymbolTable
        for lookup during future compilation phases
 */

public class SymbolEntry
{
    //Private member variables

    //Name of the entry
    private StringBuilder attribute;
    private int id;
    //Location of the attribute in the source code file
    private int lineNo, colNo;
    //Whether or not the entry as been declared
    private boolean declared;
    //the type of the entry i.e func, array etc
    private Tokens type;

    public SymbolEntry()
    {
        this.attribute = new StringBuilder();
        this.id = 0;
        this.lineNo = 0;
        this.colNo = 0;
        this.declared = false;
        this.type = null;
    }

    public SymbolEntry(Tokens t)
    {
        this.type = t;
        this.attribute = new StringBuilder();
        this.id = 0;
        this.lineNo = 0;
        this.colNo = 0;
        this.declared = false;
    }

    //Setters

    public void setAttribute(StringBuilder a) {this.attribute = a;}

    //Secondary setter for attribute so we can build the attribute as we parse
    public void addToAttribute(String s) {this.attribute.append(s);}

    public void setID(int i) {this.id = i;}

    public void setLineNo(int lineNo) {this.lineNo = lineNo;}

    public void setColNo(int c) {this.colNo = c;}

    public void setDeclared(boolean dec) {this.declared = dec;}

    public void setType(Tokens type){this.type = type;}

    //Getters

    public StringBuilder getAttribute() {return this.attribute;}

    public int getID() {return this.id;}

    public int getLineNo() {return this.lineNo;}

    public int getColNo() {return this.colNo;}

    public boolean isDeclared() {return this.declared;}

    public Tokens getType() {return this.type;}
}
