Assignment 2 for Compiler Design
Includes the lexical scanner from the previous assignment and now includes functionality to generate an abstract syntax tree.
The grammar for the CD20 programming language has been left factored as much as possible into a LL(1) grammar.
LL(1) means left recursive with a lookahead of 1 token which comes from the lexical scanner.
With the grammar in LL(1) form the abstract syntax tree can be generated in a top down recursive descent manner.
Also includes the basic functionality of a symbol table to store important information for future compilation phases.
The symbol table will store constants, function declarations, expressions and variables & their location within the source code file.