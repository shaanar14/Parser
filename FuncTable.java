/*
    COMP3290 Project 3
    Author: Shaan Arora C3236359
    FuncTable.java
    Used in SymbolTable.java to store a function defintion and the main body of a CD20 program
    Each FuncTable object basically dictates and defines a scoping block inside a CD20 program
 */

import java.util.ArrayList;
import java.util.Hashtable;

public class FuncTable
{
    //Private Member Variables

    //possibly refactor this into a SymbolEntry for the identifier token after <func>
    //String for the name of the current scope block
    private SymbolEntry name;
    //List of SymbolEntry objects to represent the parameters of the function
    private ArrayList<SymbolEntry> params;
    //The return type of the function
    //  which will be one of the following Tokens values, TINTG TREAL TBOOL TVOID
    //  which means the function returns an int, real bool or nothing (void)
    private Tokens returnType;
    //HashTable to store all the SymbolEntry objects generated during parsing from the statements inside the function
    private Hashtable<Integer, SymbolEntry> body;

    //Default Constructor
    public FuncTable()
    {
        this.name = new SymbolEntry();
        this.params = new ArrayList<>();
        this.returnType = null;
        this.body = new Hashtable<>();
    }

    //Parameter Constructor for name
    //public FuncTable(String n)

    //Operational methods

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: The int and SymbolEntry object passed in are combined into a key, value pair which is added in the HashTable body
    public void putInBody(int i, SymbolEntry record) {this.body.put(i, record);}

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Returns true if record does exist in the body HashTable for the current FuncTable object
    public boolean findInBody(SymbolEntry record) {return this.body.containsValue(record);}

    //Preconditions:  FuncTable has been declared & intialized, body does contain key, as one of its key, value pairs
    //Postconditions: Returns the SymbolEntry object that is paired with the key passed in from the body HashTable
    public SymbolEntry getInBody(int key)
    {
        assert this.body.containsKey(key);
        //Returns the SymbolEntry object paired with the key passed in
        return this.body.get(key);
    }

    //Setters

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Assigns the value of n to the attribute name
    public void setName(SymbolEntry n) {this.name = n;}

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Assigns the ArrayList plist to the attribute params
    public void setParams(ArrayList<SymbolEntry> plist) {this.params = plist;}

    //Specific setter for params to add a single SymbolEntry object
    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Adds s to the ArrayList params
    public void addParam(SymbolEntry s) {this.params.add(s);}

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Assigns the value of type to the attribute returnType
    public void setReturnType(Tokens type) {this.returnType = type;}

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Assigns the HashTable b to the attribute body
    public void setBody(Hashtable<Integer, SymbolEntry> b) {this.body = b;}

    //Getters

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Returns the name for the current FuncTable object
    public SymbolEntry getName() {return this.name;}

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Returns the ArrayList params for the current FuncTable object
    public ArrayList<SymbolEntry> getParams() {return this.params;}

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Returns the Tokens enum value returnType for the current FuncTable object
    public Tokens getReturnType() {return this.returnType;}

    //Preconditions:  FuncTable has been declared & intialized
    //Postconditions: Returns the HashTable body for the current FuncTable object
    public Hashtable<Integer, SymbolEntry> getBody() {return this.body;}

}