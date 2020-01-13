// generated with ast extension for cup
// version 0.8
// 13/0/2020 1:29:6


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private ExtendsStmt ExtendsStmt;
    private VarDeclSection VarDeclSection;
    private AnyMethodDeclSection AnyMethodDeclSection;

    public AbstractClassDecl (String I1, ExtendsStmt ExtendsStmt, VarDeclSection VarDeclSection, AnyMethodDeclSection AnyMethodDeclSection) {
        this.I1=I1;
        this.ExtendsStmt=ExtendsStmt;
        if(ExtendsStmt!=null) ExtendsStmt.setParent(this);
        this.VarDeclSection=VarDeclSection;
        if(VarDeclSection!=null) VarDeclSection.setParent(this);
        this.AnyMethodDeclSection=AnyMethodDeclSection;
        if(AnyMethodDeclSection!=null) AnyMethodDeclSection.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ExtendsStmt getExtendsStmt() {
        return ExtendsStmt;
    }

    public void setExtendsStmt(ExtendsStmt ExtendsStmt) {
        this.ExtendsStmt=ExtendsStmt;
    }

    public VarDeclSection getVarDeclSection() {
        return VarDeclSection;
    }

    public void setVarDeclSection(VarDeclSection VarDeclSection) {
        this.VarDeclSection=VarDeclSection;
    }

    public AnyMethodDeclSection getAnyMethodDeclSection() {
        return AnyMethodDeclSection;
    }

    public void setAnyMethodDeclSection(AnyMethodDeclSection AnyMethodDeclSection) {
        this.AnyMethodDeclSection=AnyMethodDeclSection;
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
        if(ExtendsStmt!=null) ExtendsStmt.accept(visitor);
        if(VarDeclSection!=null) VarDeclSection.accept(visitor);
        if(AnyMethodDeclSection!=null) AnyMethodDeclSection.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsStmt!=null) ExtendsStmt.traverseTopDown(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseTopDown(visitor);
        if(AnyMethodDeclSection!=null) AnyMethodDeclSection.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsStmt!=null) ExtendsStmt.traverseBottomUp(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseBottomUp(visitor);
        if(AnyMethodDeclSection!=null) AnyMethodDeclSection.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ExtendsStmt!=null)
            buffer.append(ExtendsStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclSection!=null)
            buffer.append(VarDeclSection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AnyMethodDeclSection!=null)
            buffer.append(AnyMethodDeclSection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDecl]");
        return buffer.toString();
    }
}
