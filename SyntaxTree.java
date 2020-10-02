/*
    COMP3290 Project
    Author: Shaan Arora, C3236359
    SyntaxTree Class
        An abstract syntax tree data structure to represent the underlying structure of a CD20 program.
        Each node in the tree represents an operator and its children an operand
 */

public class SyntaxTree
{
    //Private member variables
    
    //The root of the syntax tree
    private STNode root;
    //Lexical Scanner object so we can get the next lexeme
    private LexicalScanner scanner;
    //The next Token which is read by lookahead
    private Token next;
    //OutputController object for errors & listings
    private OutputController el;
    //OutputController object for displaying the Abstract Syntax tree
    private OutputController display;

    //Default Constructor
    public SyntaxTree()
    {
        this.root = new STNode();
        this.scanner = new LexicalScanner();
        this.next = new Token();
        this.el = new OutputController();
        this.display = new OutputController();
    }

    //Preorder traversal of the Abstract Syntax tree for the output
    public void preorder(STNode node)
    {
        if(node == null){return;}
        preorder(node.getLeftChild());
        preorder(node.getRightChild());
        System.out.print(node.getNodeValue());
    }

    //Recursive functions based on the CD20 grammar after it has been left factored and transformed into a LL(1) grammar
    //  Any rules in the grammar that have the node value Special do not create nodes but instead collapse up to the next rule which does have a node value

    //Setters

    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: The root of the current object is assigned the STNode r
    public void setRoot(STNode r) {this.root = r;}

    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: The LexicalScanner object of the current object is assigned the value of ls
    public void setScanner(LexicalScanner ls) {this.scanner = ls;}

    //Normal setter for next
    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: The next Token object of the current object is assigned the value of t
    public void setNext(Token t) {this.next = t;}

    //Secondary setter for next in which the LexicalScanner object of the SyntaxTree will generate the next valid token and assign it to next
    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: A new Token object is generated by the LexicalScanner object and assigned to the current objects next
    public void nextToken() {this.next = this.scanner.nextToken();}

    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: The OutputController object of the current SyntaxTree object that is used for errors is assigned the value of oc
    public void setEl(OutputController oc) {this.el = oc;}

    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: The OutputController object of the current SyntaxTree object thats used for display/output is assigned the value of oc
    public void setDisplay(OutputController oc) {this.display = oc;}

    //Getters

    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: Returns the root STNode of the current SyntaxTree object
    public STNode getRoot() {return this.root;}

    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: Returns the LexicalScanner object of the current SyntaxTree object which is used for tokenizing
    public LexicalScanner getScanner() {return this.scanner;}

    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: Returns the Token object which is being used as a look ahead after the grammar has been left factored into a LL(1) grammar
    public Token getNext() {return this.next;}

    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: Returns the OutputController of the SyntaxTree that is being used for handling and displaying errors
    public OutputController getEl() {return this.el;}

    //Preconditions: SyntaxTree object has been declared and initialized
    //Postconditions: Returns the OutputController of the SyntaxTree that is being used for displaying and outputtign the SyntaxTree
    public OutputController getDisplay() {return this.display;}
}