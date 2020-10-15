/*
    Project 2
    Author: Shaan Arora, C3236359
    SymbolTable Class

 */


import java.util.Hashtable;

public class SymbolTable
{
    //Hashtables are of Integer , SymbolTable Key Value pairs
    //One for any constants we find during parsing
    private Hashtable<Integer, SymbolEntry> consts;
    //A simple list of Hashtables to capture all the functions found during parsing
    private Hashtable<Integer, SymbolEntry> funcs;
    //Another Hashtable for main which will have all statements found during parsing
    private Hashtable<Integer, SymbolEntry> main;

    //Default Constructor
    public SymbolTable()
    {
        this.consts = new Hashtable<>();
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
    //Postconditions: Assigns the HashTable object c to the private member variable consts
    public void setConsts(Hashtable<Integer, SymbolEntry> c) {this.consts = c;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the HashTable object f to the private member variable funcs
    public void setFuncs(Hashtable<Integer, SymbolEntry> f) {this.funcs = f;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the HashTable object m to the private member variable main
    public void setMain(Hashtable<Integer, SymbolEntry> m) {this.main = m;}

    //Getters

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the HashTable object of the member variable consts
    public Hashtable<Integer, SymbolEntry> getConsts() {return this.consts;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the HashTable object of the member variable funcs
    public Hashtable<Integer, SymbolEntry> getFuncs() {return this.funcs;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the HashTable object of the member variable main
    public Hashtable<Integer, SymbolEntry> getMain() {return this.main;}
}
