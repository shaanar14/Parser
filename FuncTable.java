/*
    COMP3290 Project 3
    Author: Shaan Arora C3236359
    FuncTable.java
    Used in SymbolTable.java to store a function defintion and the main body of a CD20 program
    Each FuncTable object basically dictates and defines scope
 */

import java.util.ArrayList;
import java.util.Hashtable;

public class FuncTable
{
    //Private Member Variables
    private String name;
    private ArrayList<SymbolEntry> params;
    private Tokens returnType;
    private Hashtable<Integer, SymbolEntry> body;

    public FuncTable()
    {
        this.name = "";
        this.params = new ArrayList<>();
        this.returnType = null;
        this.body = new Hashtable<>();
    }

    //Operational methods

    public void putInBody(int i, SymbolEntry record) {this.body.put(i, record);}

    public boolean findInBody(SymbolEntry record) {return this.body.containsValue(record);}


    //Setters

    public void setName(String n) {this.name = n;}

    public void setParams(ArrayList<SymbolEntry> plist) {this.params = plist;}

    public void setReturnType(Tokens type) {this.returnType = type;}

    public void setBody(Hashtable<Integer, SymbolEntry> b) {this.body = b;}

    //Getters

    public String getName() {return this.name;}

    public ArrayList<SymbolEntry> getParams() {return this.params;}

    public Tokens getReturnType() {return this.returnType;}

    public Hashtable<Integer, SymbolEntry> getBody() {return this.body;}

}