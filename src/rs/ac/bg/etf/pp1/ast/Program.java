// generated with ast extension for cup
// version 0.8
// 1/1/2020 4:6:5


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ProgramName ProgramName;
    private DeclSection DeclSection;
    private GlobalMethodDeclList GlobalMethodDeclList;

    public Program (ProgramName ProgramName, DeclSection DeclSection, GlobalMethodDeclList GlobalMethodDeclList) {
        this.ProgramName=ProgramName;
        if(ProgramName!=null) ProgramName.setParent(this);
        this.DeclSection=DeclSection;
        if(DeclSection!=null) DeclSection.setParent(this);
        this.GlobalMethodDeclList=GlobalMethodDeclList;
        if(GlobalMethodDeclList!=null) GlobalMethodDeclList.setParent(this);
    }

    public ProgramName getProgramName() {
        return ProgramName;
    }

    public void setProgramName(ProgramName ProgramName) {
        this.ProgramName=ProgramName;
    }

    public DeclSection getDeclSection() {
        return DeclSection;
    }

    public void setDeclSection(DeclSection DeclSection) {
        this.DeclSection=DeclSection;
    }

    public GlobalMethodDeclList getGlobalMethodDeclList() {
        return GlobalMethodDeclList;
    }

    public void setGlobalMethodDeclList(GlobalMethodDeclList GlobalMethodDeclList) {
        this.GlobalMethodDeclList=GlobalMethodDeclList;
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
        if(ProgramName!=null) ProgramName.accept(visitor);
        if(DeclSection!=null) DeclSection.accept(visitor);
        if(GlobalMethodDeclList!=null) GlobalMethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramName!=null) ProgramName.traverseTopDown(visitor);
        if(DeclSection!=null) DeclSection.traverseTopDown(visitor);
        if(GlobalMethodDeclList!=null) GlobalMethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramName!=null) ProgramName.traverseBottomUp(visitor);
        if(DeclSection!=null) DeclSection.traverseBottomUp(visitor);
        if(GlobalMethodDeclList!=null) GlobalMethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgramName!=null)
            buffer.append(ProgramName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclSection!=null)
            buffer.append(DeclSection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalMethodDeclList!=null)
            buffer.append(GlobalMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
