/*
    COMP3290 Project 2
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
        LexicalScanner lexical = new LexicalScanner();
        OutputController oc = new OutputController();
        //Read the file with the file name that was given in the program arguments
        lexical.readFile(fileName);
        //Set the input of the OutputController to the file/input that the LexicalScanenr object generated
        oc.setInput(lexical.getInput());
        //Output all Token objects generated by the LexicalScanner object
        oc.outputLexicalScanner(lexical);
        //Pass to the OutputController object the ArrayList of Token objects generated by the LexicalScanner object
        oc.setTokenStream(lexical.getStream());
        //Generate a listing file which is a copy of the input file except that each line will start with its its line number
        //  and all errors found will be written at the end of the file with their respective line numbers
        oc.generateListingFile("listing.txt");
        System.exit(0);
    }
}