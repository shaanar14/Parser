/*
    Project 2
    Author: Shaan Arora, C3236359
    SymbolTable Class
    Stores all global constants, functions, expressions, variables etc that have been parsed in the form of a SymbolEntry object.
    Function definitions and the main body of the program is stored as FuncTable objects which are contained in a list
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class SymbolTable
{
    //Private Member Variables

    //Single specific SymbolEntry object for capturing the CD20 keyword which should be at the start of a program
    //It should also have a program name after it e.g. CD20 Program which is captured in the form of an identifier Token
    //This allows semantics to enforce the rule that the there is a CD20 keyword at the start and end of program in a source code file
    //  and that the program name/identifier Token do match
    //Doing this so we have direct access to this specific SymbolEntry without storing it in a HashTable
    private SymbolEntry program;
    //Hashtables are of Integer , SymbolTable Key Value pairs
    //One store SymbolEntry objects for global constants, types or arrays found during parsing
    private Hashtable<Integer, SymbolEntry> globals;
    //List of FuncTable objects to help define scoping within the source code file
    //Function declarations & defintions come before main so they will come first in the list
    private LinkedList<FuncTable> scope;

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

    //Preconditions:  None
    //Postconditions: Returns the SymbolEntry object that is associated with the key passed in from the globals HashTable
    public SymbolEntry getRecordGlobals(int key)
    {
        //Ensure that the key passed in does actually exist in the table
        assert this.globals.containsKey(key);
        //Return the SymbolEntry object that has the key passed in
        return this.globals.get(key);
    }

    //Preconditions:  SymbolTable has been declared & initialized
    //Postconditions: Creates a new HashTable object and places it into the list to act as a new scope
    public void createNewScope()
    {
        //Create a temp HashTable object for the scope
        FuncTable newScope = new FuncTable();
        //Add temp table to the list of scopes
        this.scope.add(newScope);
        //Assign the index of the new HashTable to currentIndex
        this.currentIndex = this.scope.indexOf(newScope);
    }

    //Postconditions: SymbolTable has been declared & initialized
    //Postconditions: Assigns the value n to the name attribute of the current FuncTable object in scope, acting as the current scoping block
    public void setNameCurrentScope(String n)
    {
        //make sure that we are not accessing a null object
        assert this.scope.get(this.currentIndex) != null;
        this.scope.get(this.currentIndex).setName(n);
    }

    //Preconditions:  SymbolTable has been declared & intialized
    //Postconditions: Assigns the ArrayList of SymbolEntry objects p to the params ArrayList of the FuncTable object at currentIndex in scope
    public void setParamsCurrentScope(ArrayList<SymbolEntry> p)
    {
        assert p.size() > 0;
        assert this.scope.get(this.currentIndex) != null;
        this.scope.get(this.currentIndex).setParams(p);

    }

    //Preconditions:  SymbolTable has been declared & intialized
    //Postconditions: Assigns the Tokens value t to returnType of the FuncTable object at currentIndex in scope
    public void setRTypeCurrentScope(Tokens t)
    {
        assert this.scope.get(this.currentIndex) != null;
        this.scope.get(this.currentIndex).setReturnType(t);
    }

    public void setLocCurrentScope(int[] l)
    {
        assert this.scope.get(this.currentIndex) != null;
        this.scope.get(this.currentIndex).setLocation(l);
    }

    //Preconditions:  SymbolTable has been declared & initialized
    //Postconditions: Places the int and SymbolEntry passed in into the current HashTable which is acting as the current scope
    public void putInCurrentScope(int i, SymbolEntry record)
    {
        this.scope.get(this.currentIndex).putInBody(i, record);
    }

    //Preconditions:  SymbolTable has been declared & initialized
    //Postconditions: Returns true if the record passed in does exist in the current HashTable which is acting as the current scope
    public boolean findInCurrentScope(SymbolEntry record) {return this.scope.get(this.currentIndex).findInBody(record);}

    //Preconditions: SymbolTable has been declared and initialized, object at currentIndex != null
    //Postconditions: Returns the SymbolEntry paired with the key passed in from the body of the current function/scope
    public SymbolEntry getInCurrentScope(int key)
    {
        //make sure we do have an object in scope at currentIndex
        assert this.scope.get(this.currentIndex) != null;
        return this.scope.get(this.currentIndex).getInBody(key);
    }

    public SymbolEntry findRecord(String name)
    {
        for(SymbolEntry g : this.globals.values())
        {
            if(g.getName().equals(name)) return g;
        }
        for(FuncTable f : this.scope)
        {
            return f.findRecord(name);
        }
        return null;
    }

    //Setters

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the SymbolEntry object p to the private member variable program
    public void setProgram(SymbolEntry p) {this.program = p;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns the HashTable object c to the private member variable consts
    public void setGlobals(Hashtable<Integer, SymbolEntry> c) {this.globals = c;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns s to the private member variable scope
    public void setScope(LinkedList<FuncTable> s) {this.scope = s;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Assigns i to the private member variable currentIndex
    public void setCurrentIndex(int i) {this.currentIndex = i;}

    //Getters

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the SymbolEntry object that is storing the information regarding the CD20 keyword
    public SymbolEntry getProgram() {return this.program;}

    //Specific Getter for the name of the program
    //Preconditions:  program != null
    //Postconditions: Returns the attribute of the SymbolEntry object associated with the program name
    public String getProgramName()
    {
        assert this.program != null;
        return this.program.getName();
    }

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the HashTable object of the member variable consts
    public Hashtable<Integer, SymbolEntry> getGlobals() {return this.globals;}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the list of all function defintions including main body
    public LinkedList<FuncTable> getScope() {return this.scope;}

    //Preconditions:  object at currentIndex in scope != null
    //Postconditions: Returns the FuncTable in scope at currentIndex
    public FuncTable getCurrentScope() {return this.scope.get(this.currentIndex);}

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the FuncTable object in scope with the same
    public FuncTable getCurrentScope(String record)
    {
        //if the name attribute of the FuncTable object in scope at currentIndex
        //  is the same same as record then return that FuncTable object
        if(this.scope.get(this.currentIndex).getName() == record)
        {
            return this.scope.get(this.currentIndex);
        }
        //probably return something better then null
        return null;
    }

    //Preconditions:  SymbolTable has been declared and intialized
    //Postconditions: Returns the index of the FuncTable object which is the current scope
    public int getCurrentIndex() {return this.currentIndex;}

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append(this.getProgramName().trim());
        output.append('\n');
        if(this.getGlobals().size() != 0)
        {
            for (SymbolEntry g : this.getGlobals().values())
            {
                output.append(g.toString());
                output.append('\n');
            }
        }
        if(this.getScope().size() != 0)
        {
            for(FuncTable f : this.getScope())
            {
                output.append('\n');
                output.append(f.getName().trim());
                output.append('\n');
                if(f.getReturnType() != null)
                {
                    output.append(f.getReturnType());
                    output.append('\n');
                }
                if(f.getParams().size() > 0)
                {
                    for(SymbolEntry p : f.getParams())
                    {
                        output.append(p);
                        output.append(" ");
                    }
                }
                output.append('\n');
                System.out.printf("Body size for %s is %d\n", f.getName().trim(), f.getBody().size());
                for(SymbolEntry b : f.getBody().values())
                {
                    output.append(b);
                    output.append('\n');
                }
            }
        }
        return output.toString();
    }
}
