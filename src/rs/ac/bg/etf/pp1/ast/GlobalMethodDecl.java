// generated with ast extension for cup
// version 0.8
// 1/1/2020 3:41:25


package rs.ac.bg.etf.pp1.ast;

public class GlobalMethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private GlobalMethodHeader GlobalMethodHeader;
    private VarDeclSection VarDeclSection;
    private StatementList StatementList;

    public GlobalMethodDecl (GlobalMethodHeader GlobalMethodHeader, VarDeclSection VarDeclSection, StatementList StatementList) {
        this.GlobalMethodHeader=GlobalMethodHeader;
        if(GlobalMethodHeader!=null) GlobalMethodHeader.setParent(this);
        this.VarDeclSection=VarDeclSection;
        if(VarDeclSection!=null) VarDeclSection.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public GlobalMethodHeader getGlobalMethodHeader() {
        return GlobalMethodHeader;
    }

    public void setGlobalMethodHeader(GlobalMethodHeader GlobalMethodHeader) {
        this.GlobalMethodHeader=GlobalMethodHeader;
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
        if(GlobalMethodHeader!=null) GlobalMethodHeader.accept(visitor);
        if(VarDeclSection!=null) VarDeclSection.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalMethodHeader!=null) GlobalMethodHeader.traverseTopDown(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalMethodHeader!=null) GlobalMethodHeader.traverseBottomUp(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalMethodDecl(\n");

        if(GlobalMethodHeader!=null)
            buffer.append(GlobalMethodHeader.toString("  "+tab));
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
        buffer.append(") [GlobalMethodDecl]");
        return buffer.toString();
    }
}
