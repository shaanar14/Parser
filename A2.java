/*
    Project 2
    Author: Shaan Arora, C3236359
    A2 Class
        Main driver for the entire parse
        Uses a LexicalScanner object for lexical analysis and a SyntaxTree object for syntax analysis
        Output of these two objects is driven by an OutputController object
*/

import java.util.Arrays;

public class A2
{
    //public final static SymbolTable st = new SymbolTable();
    //TODO create Parser.java wrapper class
    //  that way we can have a single object here with a single function call call runParser(String)
    public static void main(String[] args)
    {
        assert args.length != 0  : "File name required";
        String fileName = args[0];
        OutputController output = new OutputController();
        //LexicalScanner lexical = new LexicalScanner();
        /*SyntaxTree st = new SyntaxTree();
        //Read the file with the file name that was given in the program arguments
        //st.getScanner().readFile(fileName);
        lexical.readFile(fileName);
        //Set the input of the OutputController to the file/input that the LexicalScanenr object generated
        //st.getScanner().sendInput();
        lexical.sendInput();
        //Output all Token objects generated by the LexicalScanner object
        //st.getScanner().output()
        lexical.output();
        //Generate a listing file which is a copy of the input file except that each line will start with its its line number
        //  and all errors found will be written at the end of the file with their respective line numbers
        st.getScanner().generateListing("listing.txt");
        lexical.generateListing("listing.txt");
        //Generate Abstract Syntax Tree for the given CD20 source code file
        st.generateTree();
        //Output the AST in preorder notation
        st.outputTree();*/
        SymbolEntry se = new SymbolEntry("ExampleAST");
        STNode root = new STNode(NodeValue.NPROG);
        root.setRecord(se);
        root.setLeftChild(new STNode(NodeValue.NGLOB));
        STNode main = new STNode(NodeValue.NMAIN, new STNode(NodeValue.NSDLST), new STNode(NodeValue.NSTATS));
        root.setRightChild(main);
        output.preorderTraversal(root);
        System.exit(0);
    }
}