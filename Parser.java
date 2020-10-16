/*
    Author: Shaan Arora C3236359
    Parser.java
    Wrapper class for each phase of compilation so far
 */

public class Parser
{
    //Private member variables

    private LexicalScanner scanner;
    private SyntaxTree tree;
    private SymbolTable symbolTable;

    //Default constructor
    public Parser()
    {
        this.scanner = new LexicalScanner();
        this.tree = new SyntaxTree();
        this.symbolTable = new SymbolTable();
    }

    public void parseFile(String fileName)
    {
        //Read the file for parsing
        this.scanner.readFile(fileName);
        //Tokenize source file
        this.scanner.tokenize();
        System.out.print("\n\nPreorder Traversal\n");
        //send the LexicalScanner object to the SyntaxTree object
        this.tree.setScanner(this.scanner);
        this.tree.getOutput().setInput(this.scanner.getInput());
        //generate abstract syntax tree
        this.tree.generateTree();
        //display the abstract syntax tree created
        this.tree.outputTree();
        this.tree.getOutput().generateListingFile("listing.txt");
    }
}
