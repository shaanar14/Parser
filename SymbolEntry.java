/*
    Project 2
    Author: Shaan Arora, C3236359
    SymbolEntry Class
    Core data structure for SymbolTable
    Stores valuable information of things like variable declarations which then gets placed into a SymbolTable
        for lookup during future compilation phases
 */

import java.util.ArrayList;

public class SymbolEntry
{
    //Private member variables

    //Name of the entry
    private String name;
    private int id;
    //Location of the attribute in the source code file
    //array acting as a pair of integer values
    //index 0 will store the line number and index 1 will store the colum number
    private final int[] location;
    //Whether or not the entry as been declared
    private boolean declared;
    //the type of the entry i.e func, array etc
    private Tokens type;
    //TODO add base register and offset for code gen
    //private final int[] stackLocation
    //List of attributes associated with this entry
    private ArrayList<SymbolEntry> attributes;

    public SymbolEntry()
    {
        this.name = "";
        this.id = 0;
        this.location = new int[2];
        this.declared = false;
        this.type = null;
        this.attributes = new ArrayList<>();
    }

    //TODO comments
    //Setters

    public void setName(String a) {this.name = a;}

    public void setID(int i) {this.id = i;}

    public void setDeclared(boolean dec) {this.declared = dec;}

    public void setType(Tokens type){this.type = type;}

    public void setLocation(int l, int c) {this.location[0] = l; this.location[1] = c;}

    public void setLineNo(int l) {this.location[0] = l;}

    public void setColNo(int c) {this.location[1] = c;}

    public void setAttributes(ArrayList<SymbolEntry> attr) {this.attributes = attr;}

    //Specific setter to add a single SymbolEntry object into the list of attributes

    public void addAttribute(SymbolEntry a) {this.attributes.add(a);}

    //Getters

    public String getName() {return this.name;}

    public int getID() {return this.id;}

    public int getLineNo() {return this.location[0];}

    public int getColNo() {return this.location[1];}

    public int[] getLocation() {return this.location;}

    public boolean isDeclared() {return this.declared;}

    public Tokens getType() {return this.type;}

    public ArrayList<SymbolEntry> getAttributes() {return this.attributes;}

    @Override
    public String toString()
    {
        return this.getName();
    }
}
