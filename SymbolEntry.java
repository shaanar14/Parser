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
    //ID for the entry
    private int id;
    //Location of the attribute in the source code file
    //array acting as a pair of integer values
    //index 0 will store the line number and index 1 will store the colum number
    private final int[] location;
    //Whether or not the entry as been declared
    private boolean declared;
    //The type of the entry i.e func, array etc
    private Tokens type;
    //List of attributes associated with this entry e.g. fields in a struct
    private ArrayList<SymbolEntry> attributes;
    //TODO add base register and offset for code gen

    //Default Constructor
    public SymbolEntry()
    {
        this.name = "";
        this.id = 0;
        this.location = new int[2];
        this.declared = false;
        this.type = null;
        this.attributes = new ArrayList<>();
    }

    //Operational Method

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Returns a number by adding the line number, the column number and the length of the name attribute
    //                  This is used as the key for placing the SymbolEntry object into a SymbolTable object
    public int  generateKey()
    {
        return this.getLineNo() + this.getColNo() + this.getName().length();
    }

    //Setters

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Assigns the value of to the attribute name for the current SymbolEntry object
    public void setName(String a) {this.name = a;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Assigns the value of i to the id attribute for the current SymbolEntry object
    public void setID(int i) {this.id = i;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Assigns the value of dec to the declared attribute for the current SymbolEntry object
    public void setDeclared(boolean dec) {this.declared = dec;}

    //Specific Setter to make the current SymbolEntry object declared
    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Sets the declared attribute to true for the current SymbolEntry object
    public void declare() {this.declared = true;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Assigns the Tokens value type to the type attribute for the current SymbolEntry object
    public void setType(Tokens type){this.type = type;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Assigns the value of l to index 0 and the value of c to index 1 of the location array for the current SymbolEntry object
    public void setLocation(int l, int c) {this.location[0] = l; this.location[1] = c;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Assigns the value of l to index 0 of the location array for the current SymbolEntry object
    public void setLineNo(int l) {this.location[0] = l;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Assigns the value of c to index 1 of the location array for the current SymbolEntry object
    public void setColNo(int c) {this.location[1] = c;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Assigns the entire ArrayList attr to the attributes member variable for the current SymbolTable object
    public void setAttributes(ArrayList<SymbolEntry> attr) {this.attributes = attr;}

    //Specific setter to add a single SymbolEntry object into the list of attributes
    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Adds the SymbolEntry object a into the ArrayList attributes for the current SymbolEntry object
    public void addAttribute(SymbolEntry a) {this.attributes.add(a);}

    //Getters

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Returns the name for the current SymbolEntry object
    public String getName() {return this.name;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Returns the ID for the current SymbolEntry object
    public int getID() {return this.id;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Returns the line number within the source code file for the current SymbolEntry object
    public int getLineNo() {return this.location[0];}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Returns the column number within the source code file for the current SymbolEntry object
    public int getColNo() {return this.location[1];}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Returns an integer array storing the location within the source code file for the current SymbolEntry object
    //                  index 0 for line number, index 1 for colum no
    public int[] getLocation() {return this.location;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Returns true if the current SymbolEntry object has been declared within the current scope, otherwise false
    public boolean isDeclared() {return this.declared;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Returns the Tokens value for the current SymbolEntry object representing its type
    public Tokens getType() {return this.type;}

    //Preconditions:  SymbolEntry has been declared & intialized
    //Postconditions: Returns the ArrayList of SymbolEntry objects represent the extra attributes for the current SymbolEntry object
    public ArrayList<SymbolEntry> getAttributes() {return this.attributes;}

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append(this.getName().trim());
        if(this.getType() != null)
        {
            output.append(" : ");
            output.append(this.getType());
        }
        if(this.getAttributes().size() != 0)
        {
            output.append(" | ");
            for (SymbolEntry s : this.getAttributes())
            {
                if(s != null)
                {
                    output.append(s.getName().trim());
                    output.append(" ");
                }
            }
        }
        return output.toString();
    }
}
