/*
    Project 2
    Author: Shaan Arora, C3236359
    SymbolTable Class
    Stores all global constants, functions, expressions, variables etc that have been parsed in the form of a SymbolEntry object.
 */

import java.util.Hashtable;

public class SymbolTable
{
    //Single specific SymbolEntry object for capturing the CD20 keyword which should be at the start of a program
    //It should also have a program name after it e.g. CD20 Program which is captured in the form of an identifier Token
    //This allows semantics to enforce the rule that the there is a CD20 keyword at the start and end of program in a source code file
    //  and that the program name/identifier Token do match
    //Doing this so we have direct access to this specific SymbolEntry without storing it in a HashTable
    private SymbolEntry program;
    //Hashtables are of Integer , SymbolTable Key Value pairs
    //One for any global constants we find during parsing
    private Hashtable<Integer, SymbolEntry> globals;
    //A simple list of Hashtables to capture all the functions found during parsing
    private Hashtable<Integer, SymbolEntry> funcs;
    //Another Hashtable for main which will have all statements found during parsing
    private Hashtable<Integer, SymbolEntry> main;

    //Default Constructor
    public SymbolTable()
    {
        this.program = new SymbolEntry();
        this.globals = new Hashtable<>();
        this.funcs = new Hashtable<>();
        this.main = new Hashtable<>();
    }

    //TODO Implement the following:
    //  void putConsts(Integer, Symbol Entry)
    //  void putFuncs(Integer, Integer, SymbolEntry)
    //  void putMain(Integer, SymbolEntry)
    //  SymbolEntry findConsts(Key) -> get(Key) Hashtable
    //  SymbolEntry findFuncs(Key)  -> get(Key) from Hashtable
    //  SymbolEntry findMain(Key)   -> get(Key) from Hashtable
    //  For find functions use containsKey(Key) to check if the key does actually exist
    //      becaues i dont want get(Key) to return null


    //Setters

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the SymbolEntry object p to the private member variable program
    public void setProgram(SymbolEntry p) {this.program = p;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the HashTable object c to the private member variable consts
    public void setGlobals(Hashtable<Integer, SymbolEntry> c) {this.globals = c;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the HashTable object f to the private member variable funcs
    public void setFuncs(Hashtable<Integer, SymbolEntry> f) {this.funcs = f;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the HashTable object m to the private member variable main
    public void setMain(Hashtable<Integer, SymbolEntry> m) {this.main = m;}

    //Getters

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the SymbolEntry object that is storing the information regarding the CD20 keyword
    public SymbolEntry getProgram() {return this.program;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the HashTable object of the member variable consts
    public Hashtable<Integer, SymbolEntry> getGlobals() {return this.globals;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the HashTable object of the member variable funcs
    public Hashtable<Integer, SymbolEntry> getFuncs() {return this.funcs;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the HashTable object of the member variable main
    public Hashtable<Integer, SymbolEntry> getMain() {return this.main;}
}
