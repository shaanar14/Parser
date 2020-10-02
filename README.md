Assignment 2 for Compiler Design
Includes the lexical scanner from the previous assignment and now includes functionality to generate an abstract syntax tree.
The grammar for the CD20 programming language has been converted into a LL(1) grammar.
LL(1) means left recursive with a lookahead of 1 token which comes from the lexical scanner
With the grammar in LL(1) form the abstract syntax tree can be generated in a top down recursive descent manner.