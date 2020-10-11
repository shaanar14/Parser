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
    //TODO consider going back to a String so we don't have 60 enums
    private NodeValue nodeValue;
    //Reference to an entry in the symbol table
    private SymbolEntry record;

    public STNode()
    {
        this.nodeValue = NodeValue.NPROG;
        this.leftChild = new STNode();
        this.middleChild = new STNode();
        this.rightChild = new STNode();
        this.record = new SymbolEntry();
    }

    public STNode(NodeValue nv)
    {
        this.nodeValue = nv;
        this.leftChild = new STNode();
        this.middleChild = new STNode();
        this.rightChild = new STNode();
        this.record = new SymbolEntry();
    }

    public STNode(NodeValue nv, STNode left)
    {
        this.nodeValue = nv;
        this.leftChild = left;
        this.middleChild = new STNode();
        this.rightChild = new STNode();
        this.record = new SymbolEntry();
    }

    public STNode(NodeValue nv, STNode left, STNode right)
    {
        this.nodeValue = nv;
        this.leftChild = left;
        this.rightChild = right;
        this.middleChild = new STNode();
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

    @Override
    //TODO rework to suit assignment specs
    public String toString()
    {
        return String.valueOf(this.getNodeValue());
    }
}
