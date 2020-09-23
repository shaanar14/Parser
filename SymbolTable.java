/*
    Project 2
    Author: Shaan Arora, C3236359
    SymbolTable Class

 */

import java.util.Hashtable;

public class SymbolTable
{
    private Hashtable<Integer, String> table;
    //need to consider scoping

    public SymbolTable()
    {
        this.table = new Hashtable<>();
    }

    public void put(Token t)
    {
        if(t.getLexeme().equals(""))
        {
            String value = t.getIDLabel().toString();
            this.table.put(t.getLineNo(), value);
        }
        else {this.table.put(t.getLineNo(), t.getLexeme());}
    }

    public String get(Token t)
    {
        return this.table.get(t.getLineNo());
    }

    public int size()
    {
        return this.table.size();
    }

    public Hashtable<Integer, String> getTable()
    {
        return this.table;
    }
}
