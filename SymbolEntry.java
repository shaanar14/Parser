/*
    Project 2
    Author: Shaan Arora, C3236359
    SymbolEntry Class
        Stores all relevant information regarding an entry in the symbol type such as line number, declaration status etc.
 */

public class SymbolEntry
{
    //TODO add value
    //Private member variables
    //Name of the entry
    private String attribute;
    private int id;
    //Location of the attribute in the source code file
    private int lineNo, colNo;
    //Whether or not the entry as been declared
    private boolean declared;
    //the type of the entry i.e func, array etc
    private Tokens type;

    public SymbolEntry()
    {
        this.attribute = "";
        this.id = 0;
        this.lineNo = 0;
        this.colNo = 0;
        this.declared = false;
        this.type = null;
    }

    public SymbolEntry(String a)
    {
        this.attribute = a;
        this.id = 0;
        this.lineNo = 0;
        this.colNo = 0;
        this.declared = false;
        this.type = null;
    }

    public void setAttribute(String a) {this.attribute = a;}

    public void setID(int i) {this.id = i;}

    public void setLineNo(int lineNo) {this.lineNo = lineNo;}

    public void setColNo(int c) {this.colNo = c;}

    public void setDeclared(boolean dec) {this.declared = dec;}

    public void setType(Tokens type){this.type = type;}

    public String getAttribute() {return this.attribute;}

    public int getID() {return this.id;}

    public int getLineNo() {return this.lineNo;}

    public int getColNo() {return this.colNo;}

    public boolean isDeclared() {return this.declared;}

    public Tokens getType() {return this.type;}
}
