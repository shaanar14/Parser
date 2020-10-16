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
    public static void main(String[] args)
    {
        assert args.length != 0  : "File name required";
        String fileName = args[0];
        Parser parser = new Parser();
        parser.parseFile(fileName);
        System.exit(0);
    }
}