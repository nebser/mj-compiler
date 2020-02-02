// generated with ast extension for cup
// version 0.8
// 2/1/2020 4:22:52


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodHeader MethodHeader;
    private VarDeclSection VarDeclSection;
    private StatementSection StatementSection;

    public MethodDecl (MethodHeader MethodHeader, VarDeclSection VarDeclSection, StatementSection StatementSection) {
        this.MethodHeader=MethodHeader;
        if(MethodHeader!=null) MethodHeader.setParent(this);
        this.VarDeclSection=VarDeclSection;
        if(VarDeclSection!=null) VarDeclSection.setParent(this);
        this.StatementSection=StatementSection;
        if(StatementSection!=null) StatementSection.setParent(this);
    }

    public MethodHeader getMethodHeader() {
        return MethodHeader;
    }

    public void setMethodHeader(MethodHeader MethodHeader) {
        this.MethodHeader=MethodHeader;
    }

    public VarDeclSection getVarDeclSection() {
        return VarDeclSection;
    }

    public void setVarDeclSection(VarDeclSection VarDeclSection) {
        this.VarDeclSection=VarDeclSection;
    }

    public StatementSection getStatementSection() {
        return StatementSection;
    }

    public void setStatementSection(StatementSection StatementSection) {
        this.StatementSection=StatementSection;
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
        if(MethodHeader!=null) MethodHeader.accept(visitor);
        if(VarDeclSection!=null) VarDeclSection.accept(visitor);
        if(StatementSection!=null) StatementSection.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodHeader!=null) MethodHeader.traverseTopDown(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseTopDown(visitor);
        if(StatementSection!=null) StatementSection.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodHeader!=null) MethodHeader.traverseBottomUp(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseBottomUp(visitor);
        if(StatementSection!=null) StatementSection.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodHeader!=null)
            buffer.append(MethodHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclSection!=null)
            buffer.append(VarDeclSection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementSection!=null)
            buffer.append(StatementSection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
