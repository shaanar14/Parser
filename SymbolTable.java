/*
    Project 2
    Author: Shaan Arora, C3236359
    SymbolTable Class
    Stores all global constants, functions, expressions, variables etc that have been parsed in the form of a SymbolEntry object.
 */

import java.util.Hashtable;
import java.util.LinkedList;

public class SymbolTable
{
    //Single specific SymbolEntry object for capturing the CD20 keyword which should be at the start of a program
    //It should also have a program name after it e.g. CD20 Program which is captured in the form of an identifier Token
    //This allows semantics to enforce the rule that the there is a CD20 keyword at the start and end of program in a source code file
    //  and that the program name/identifier Token do match
    //Doing this so we have direct access to this specific SymbolEntry without storing it in a HashTable
    private SymbolEntry program;
    //Hashtables are of Integer , SymbolTable Key Value pairs
    //One store SymbolEntry objects for global constants, types or arrays found during parsing
    private Hashtable<Integer, SymbolEntry> globals;
    //List of HashTables to help define scoping for SymbolEntries
    //Function declarations & defintions come before main so they will come first in the list
    private LinkedList<Hashtable<Integer, SymbolEntry>> scope;
    //Integer to store the index of the current scope to make adding SymbolEntry objects into that scope easier
    private int currentIndex;

    //Default Constructor
    public SymbolTable()
    {
        this.program = new SymbolEntry();
        this.globals = new Hashtable<>();
        this.scope = new LinkedList<>();
        this.currentIndex = 0;
    }

    //TODO Implement the following:
    //  void putConsts(Integer, Symbol Entry)
    //  SymbolEntry findConsts(Key) -> get(Key) Hashtable
    //  openNewScope() -> this.scope.add(new HashTable<Integer, SymbolEntry>);
    //  addToCurrentScope() -> integer set to the index of the newly created HashTable
    //  closeCurrentScope() -> reset the counter
    //  putCurrentScope()
    //  findCurrentScope()
    //  findEntry()
    //  For find functions use containsKey(Key) to check if the key does actually exist
    //      becaues i dont want get(Key) to return null


    //Operational Methods

    //Place a SymbolEntry into the globals HashTable
    //Preconditions:  SymbolTable has been declared & initlaized
    //Postconditions: Puts the int i as the key and SymbolEntry object as the vaue into the global HashTable
    public void putGlobals(int i, SymbolEntry record)
    {
        this.globals.put(i, record);
    }

    //Check to see if the record is contained in the globals HashTable
    //Preconditions:  SymbolTable has been declared & intialized, record != null
    //Postconditions: Returns true if the SymbolEntry object passed in does exist in the globals HashtTable
    public boolean findGlobals(SymbolEntry record)
    {
        return this.globals.containsValue(record);
    }

    //Preconditions:
    //Postconditions: Returns the SymbolEntry object that is associated with the key passed in from the globals HashTable
    public SymbolEntry getRecordGlobals(int key)
    {
        //Ensure that the key passed in does actually exist in the table
        assert this.globals.containsKey(key);
        //Return the SymbolEntry object that has the key passed in
        return this.globals.get(key);
    }

    //TODO test
    //Preconditions:  SymbolTable has been declared & initialized
    //Postconditions: Creates a new HashTable object and places it into the list to act as a new scope
    public void createNewScope()
    {
        //Create a temp HashTable object for the scope
        Hashtable<Integer, SymbolEntry> newScope = new Hashtable<>();
        //Add temp table to the list of scopes
        this.scope.add(newScope);
        //Assign the index of the new HashTable to currentIndex
        this.currentIndex = this.scope.indexOf(newScope);
    }

    //Preconditions:  SymbolTable has been declared & initialized
    //Postconditions: Places the int and SymbolEntry passed in into the current HashTable which is acting as the current scope
    public void putToCurrentScope(int i, SymbolEntry record)
    {
        this.scope.get(this.currentIndex).put(i, record);
    }

    //Preconditions:  SymbolTable has been declared & initialized
    //Postconditions: Returns true if the record passed in does exist in the current HashTable which is acting as the current scope
    public boolean findInCurrentScope(SymbolEntry record)
    {
        return this.scope.get(this.currentIndex).containsValue(record);
    }


    //Setters

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the SymbolEntry object p to the private member variable program
    public void setProgram(SymbolEntry p) {this.program = p;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the HashTable object c to the private member variable consts
    public void setGlobals(Hashtable<Integer, SymbolEntry> c) {this.globals = c;}

    //Preconditions:
    //Postconditions:
    public void setScope(LinkedList<Hashtable<Integer, SymbolEntry>> s) {this.scope = s;}

    //Preconditions:
    //Postconditions:
    public void setCurrentIndex(int i) {this.currentIndex = i;}

    //Getters

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the SymbolEntry object that is storing the information regarding the CD20 keyword
    public SymbolEntry getProgram() {return this.program;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the HashTable object of the member variable consts
    public Hashtable<Integer, SymbolEntry> getGlobals() {return this.globals;}

    //Preconditions
    //Postconditions
    public LinkedList<Hashtable<Integer, SymbolEntry>> getScope() {return this.scope;}

    //Preconditions:
    //Postconditions:
    public int getCurrentIndex() {return this.currentIndex;}
}
