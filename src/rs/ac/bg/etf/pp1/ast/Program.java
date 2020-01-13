// generated with ast extension for cup
// version 0.8
// 13/0/2020 1:29:6


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private DeclSection DeclSection;
    private MethodDeclSection MethodDeclSection;

    public Program (String I1, DeclSection DeclSection, MethodDeclSection MethodDeclSection) {
        this.I1=I1;
        this.DeclSection=DeclSection;
        if(DeclSection!=null) DeclSection.setParent(this);
        this.MethodDeclSection=MethodDeclSection;
        if(MethodDeclSection!=null) MethodDeclSection.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public DeclSection getDeclSection() {
        return DeclSection;
    }

    public void setDeclSection(DeclSection DeclSection) {
        this.DeclSection=DeclSection;
    }

    public MethodDeclSection getMethodDeclSection() {
        return MethodDeclSection;
    }

    public void setMethodDeclSection(MethodDeclSection MethodDeclSection) {
        this.MethodDeclSection=MethodDeclSection;
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
        if(DeclSection!=null) DeclSection.accept(visitor);
        if(MethodDeclSection!=null) MethodDeclSection.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclSection!=null) DeclSection.traverseTopDown(visitor);
        if(MethodDeclSection!=null) MethodDeclSection.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclSection!=null) DeclSection.traverseBottomUp(visitor);
        if(MethodDeclSection!=null) MethodDeclSection.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(DeclSection!=null)
            buffer.append(DeclSection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclSection!=null)
            buffer.append(MethodDeclSection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
