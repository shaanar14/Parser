/*
    Project 1b
    Author: Shaan Arora, C3236359
    A2 Class
        Main driver for the entire parse
        Uses a LexicalScanner object for lexical analysis and a SyntaxTree object for syntax analysis
        Output of these two objects is driven by an OutputController object
*/

public class A2
{
    public final static SymbolTable st = new SymbolTable();
    public static void main(String[] args)
    {
        assert(args.length != 1) : "File name required";
        String fileName = args[0];
        LexicalScanner lexical = new LexicalScanner();
        SyntaxTree st = new SyntaxTree();
        //Read the file with the file name that was given in the program arguments
        lexical.readFile(fileName);
        //Set the input of the OutputController to the file/input that the LexicalScanenr object generated
        lexical.sendInput();
        //Output all Token objects generated by the LexicalScanner object
        lexical.output();
        //Generate a listing file which is a copy of the input file except that each line will start with its its line number
        //  and all errors found will be written at the end of the file with their respective line numbers
        lexical.generateListing("listing.txt");
        //Generate Abstract Syntax Tree for the given CD20 source code file
        st.generateTree();
        //Output the AST in preorder notation
        st.outputTree();
        System.exit(0);
    }
}