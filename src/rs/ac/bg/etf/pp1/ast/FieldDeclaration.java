// generated with ast extension for cup
// version 0.8
// 31/0/2020 20:3:28


package rs.ac.bg.etf.pp1.ast;

public class FieldDeclaration extends FieldDeclList {

    private FieldDecl FieldDecl;

    public FieldDeclaration (FieldDecl FieldDecl) {
        this.FieldDecl=FieldDecl;
        if(FieldDecl!=null) FieldDecl.setParent(this);
    }

    public FieldDecl getFieldDecl() {
        return FieldDecl;
    }

    public void setFieldDecl(FieldDecl FieldDecl) {
        this.FieldDecl=FieldDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FieldDecl!=null) FieldDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FieldDecl!=null) FieldDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FieldDecl!=null) FieldDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FieldDeclaration(\n");

        if(FieldDecl!=null)
            buffer.append(FieldDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FieldDeclaration]");
        return buffer.toString();
    }
}
