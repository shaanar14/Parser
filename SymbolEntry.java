/*
    Project 2
    Author: Shaan Arora, C3236359
    SymbolEntry Class
        Stores all relevant information regarding an entry in the symbol type such as line number, declaration status etc.
 */

public class SymbolEntry
{
    //Private member variables
    //Name of the entry
    private String name;
    //Where abouts in the source code file its located
    private int lineNo;
    //Whether or not the entry as been declared
    private boolean declared;
    //the type of the entry i.e func, array etc
    private Tokens type;

    public SymbolEntry()
    {
        this.name = "";
        this.declared = false;
        this.lineNo = 0;
        this.type = null;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void setLineNo(int lineNo)
    {
        this.lineNo = lineNo;
    }

    public int getLineNo()
    {
        return this.lineNo;
    }

    public String getName()
    {
        return this.name;
    }

    public void setDeclared(boolean dec)
    {
        this.declared = dec;
    }

    public boolean isDeclared()
    {
        return this.declared;
    }

    public void setType(Tokens type)
    {
        this.type = type;
    }

    public Tokens getType()
    {
        return this.type.label();
    }
}
