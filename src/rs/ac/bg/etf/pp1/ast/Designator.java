// generated with ast extension for cup
// version 0.8
// 26/0/2020 3:13:26


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String ident;
    private DesignatorSuffix DesignatorSuffix;

    public Designator (String ident, DesignatorSuffix DesignatorSuffix) {
        this.ident=ident;
        this.DesignatorSuffix=DesignatorSuffix;
        if(DesignatorSuffix!=null) DesignatorSuffix.setParent(this);
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident=ident;
    }

    public DesignatorSuffix getDesignatorSuffix() {
        return DesignatorSuffix;
    }

    public void setDesignatorSuffix(DesignatorSuffix DesignatorSuffix) {
        this.DesignatorSuffix=DesignatorSuffix;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorSuffix!=null) DesignatorSuffix.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorSuffix!=null) DesignatorSuffix.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorSuffix!=null) DesignatorSuffix.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        buffer.append(" "+tab+ident);
        buffer.append("\n");

        if(DesignatorSuffix!=null)
            buffer.append(DesignatorSuffix.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
