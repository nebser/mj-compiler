// generated with ast extension for cup
// version 0.8
// 28/0/2020 2:16:42


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassName ClassName;
    private ExtendsStmt ExtendsStmt;
    private FieldDeclSection FieldDeclSection;
    private AnyMethodDeclSection AnyMethodDeclSection;

    public AbstractClassDecl (ClassName ClassName, ExtendsStmt ExtendsStmt, FieldDeclSection FieldDeclSection, AnyMethodDeclSection AnyMethodDeclSection) {
        this.ClassName=ClassName;
        if(ClassName!=null) ClassName.setParent(this);
        this.ExtendsStmt=ExtendsStmt;
        if(ExtendsStmt!=null) ExtendsStmt.setParent(this);
        this.FieldDeclSection=FieldDeclSection;
        if(FieldDeclSection!=null) FieldDeclSection.setParent(this);
        this.AnyMethodDeclSection=AnyMethodDeclSection;
        if(AnyMethodDeclSection!=null) AnyMethodDeclSection.setParent(this);
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

    public FieldDeclSection getFieldDeclSection() {
        return FieldDeclSection;
    }

    public void setFieldDeclSection(FieldDeclSection FieldDeclSection) {
        this.FieldDeclSection=FieldDeclSection;
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
        if(ClassName!=null) ClassName.accept(visitor);
        if(ExtendsStmt!=null) ExtendsStmt.accept(visitor);
        if(FieldDeclSection!=null) FieldDeclSection.accept(visitor);
        if(AnyMethodDeclSection!=null) AnyMethodDeclSection.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassName!=null) ClassName.traverseTopDown(visitor);
        if(ExtendsStmt!=null) ExtendsStmt.traverseTopDown(visitor);
        if(FieldDeclSection!=null) FieldDeclSection.traverseTopDown(visitor);
        if(AnyMethodDeclSection!=null) AnyMethodDeclSection.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassName!=null) ClassName.traverseBottomUp(visitor);
        if(ExtendsStmt!=null) ExtendsStmt.traverseBottomUp(visitor);
        if(FieldDeclSection!=null) FieldDeclSection.traverseBottomUp(visitor);
        if(AnyMethodDeclSection!=null) AnyMethodDeclSection.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDecl(\n");

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

        if(FieldDeclSection!=null)
            buffer.append(FieldDeclSection.toString("  "+tab));
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
