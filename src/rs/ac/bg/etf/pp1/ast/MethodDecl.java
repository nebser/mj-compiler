// generated with ast extension for cup
// version 0.8
// 30/0/2020 2:20:37


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodHeader MethodHeader;
    private VarDeclSection VarDeclSection;
    private StatementList StatementList;

    public MethodDecl (MethodHeader MethodHeader, VarDeclSection VarDeclSection, StatementList StatementList) {
        this.MethodHeader=MethodHeader;
        if(MethodHeader!=null) MethodHeader.setParent(this);
        this.VarDeclSection=VarDeclSection;
        if(VarDeclSection!=null) VarDeclSection.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
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

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
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
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodHeader!=null) MethodHeader.traverseTopDown(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodHeader!=null) MethodHeader.traverseBottomUp(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
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

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
