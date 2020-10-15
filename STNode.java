/*
    COMP3290 Project
    Author: Shaan Arora, C3236359
    STNode Class
        The core data type for the syntax tree which will contain a reference to a symbol table record and have reference to three children nodes
        If each rule from the CD20 grammar, after it has been left factored which means ambiguity has been removed, child assignment works as follows:
            If the rule contains three children then assign left, middle then right
            If the rule contains two children use left and right
            If the rule contains one child use the left
 */

public class STNode
{
    //Private Member Variables
    //The nodes left most child
    private STNode leftChild;
    //The nodes middle child
    private STNode middleChild;
    //The nodes right most child
    private STNode rightChild;
    //The node value from the grammar
    private NodeValue nodeValue;
    //Reference to an entry in the symbol table
    private SymbolEntry record;

    public STNode()
    {
        this.nodeValue = NodeValue.NPROG;
        this.leftChild = null;
        this.middleChild = null;
        this.rightChild = null;
        this.record = new SymbolEntry();
    }

    public STNode(NodeValue nv)
    {
        this.nodeValue = nv;
        this.leftChild = null;
        this.middleChild = null;
        this.rightChild = null;
        this.record = new SymbolEntry();
    }

    public STNode(NodeValue nv, STNode left)
    {
        this.nodeValue = nv;
        this.leftChild = left;
        this.middleChild = null;
        this.rightChild = null;
        this.record = new SymbolEntry();
    }

    public STNode(NodeValue nv, STNode left, STNode right)
    {
        this.nodeValue = nv;
        this.leftChild = left;
        this.rightChild = right;
        this.middleChild = null;
        this.record = new SymbolEntry();
    }

    public STNode(NodeValue nv, STNode left, STNode middle, STNode right)
    {
        this.nodeValue = nv;
        this.leftChild = left;
        this.middleChild = middle;
        this.rightChild = right;
        this.record = new SymbolEntry();
    }

    public void setRecord(SymbolEntry r) {this.record = r;}

    public void setLeftChild(STNode lc) {this.leftChild = lc;}

    public void setMiddleChild(STNode mc) {this.middleChild = mc;}

    public void setRightChild(STNode rc){this.rightChild = rc;}

    public void setNodeValue(NodeValue nv) {this.nodeValue = nv;}

    public SymbolEntry getRecord() {return this.record;}

    public STNode getLeftChild() {return this.leftChild;}

    public STNode getMiddleChild() {return this.middleChild;}

    public STNode getRightChild() {return this.rightChild;}

    public NodeValue getNodeValue() {return this.nodeValue;}

    //Specific getter to retrieve the attribute of the node which is stored in a STNode's record
    public String getAttribute() {return this.getRecord().getAttribute();}

    @Override
    //TODO test on a bigger syntax tree
    public String toString()
    {
        StringBuilder nv = new StringBuilder();
        nv.append(this.getNodeValue());
        double length = nv.length();
        if(length < 7)
        {
            while(length != 7)
            {
                nv.append(" ");
                length = nv.length();
            }
        }
        StringBuilder a = new StringBuilder(this.getAttribute());
        length = a.length();
        if(length % 7 != 0)
        {
            double n = length;
            //ceiling function of the length of the lexeme divided by 6 and then times that value by 6
            //e.g. if n = 13 then this will be rounded up ot 18 which is the next multiple of 6 characters
            n = ((Math.ceil(n/7)) * 7);
            while(length != n)
            {
                a.append(" ");
                length = a.length();
            }
        }
        nv.append(a);
        return nv.toString();
    }
}
