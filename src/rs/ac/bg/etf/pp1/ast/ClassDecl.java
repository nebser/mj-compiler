// generated with ast extension for cup
// version 0.8
// 26/0/2020 3:13:26


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassName ClassName;
    private ExtendsStmt ExtendsStmt;
    private VarDeclSection VarDeclSection;
    private MethodDeclSection MethodDeclSection;

    public ClassDecl (ClassName ClassName, ExtendsStmt ExtendsStmt, VarDeclSection VarDeclSection, MethodDeclSection MethodDeclSection) {
        this.ClassName=ClassName;
        if(ClassName!=null) ClassName.setParent(this);
        this.ExtendsStmt=ExtendsStmt;
        if(ExtendsStmt!=null) ExtendsStmt.setParent(this);
        this.VarDeclSection=VarDeclSection;
        if(VarDeclSection!=null) VarDeclSection.setParent(this);
        this.MethodDeclSection=MethodDeclSection;
        if(MethodDeclSection!=null) MethodDeclSection.setParent(this);
    }

    public ClassName getClassName() {
        return ClassName;
    }

    public void setClassName(ClassName ClassName) {
        this.ClassName=ClassName;
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
        if(ClassName!=null) ClassName.accept(visitor);
        if(ExtendsStmt!=null) ExtendsStmt.accept(visitor);
        if(VarDeclSection!=null) VarDeclSection.accept(visitor);
        if(MethodDeclSection!=null) MethodDeclSection.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassName!=null) ClassName.traverseTopDown(visitor);
        if(ExtendsStmt!=null) ExtendsStmt.traverseTopDown(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseTopDown(visitor);
        if(MethodDeclSection!=null) MethodDeclSection.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassName!=null) ClassName.traverseBottomUp(visitor);
        if(ExtendsStmt!=null) ExtendsStmt.traverseBottomUp(visitor);
        if(VarDeclSection!=null) VarDeclSection.traverseBottomUp(visitor);
        if(MethodDeclSection!=null) MethodDeclSection.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        if(ClassName!=null)
            buffer.append(ClassName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
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

        if(MethodDeclSection!=null)
            buffer.append(MethodDeclSection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
