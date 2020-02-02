// generated with ast extension for cup
// version 0.8
// 2/1/2020 4:22:52


package rs.ac.bg.etf.pp1.ast;

public class AnyMethodDeclaration extends AnyMethodDeclList {

    private AnyMethodDecl AnyMethodDecl;

    public AnyMethodDeclaration (AnyMethodDecl AnyMethodDecl) {
        this.AnyMethodDecl=AnyMethodDecl;
        if(AnyMethodDecl!=null) AnyMethodDecl.setParent(this);
    }

    public AnyMethodDecl getAnyMethodDecl() {
        return AnyMethodDecl;
    }

    public void setAnyMethodDecl(AnyMethodDecl AnyMethodDecl) {
        this.AnyMethodDecl=AnyMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AnyMethodDecl!=null) AnyMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AnyMethodDecl!=null) AnyMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AnyMethodDecl!=null) AnyMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AnyMethodDeclaration(\n");

        if(AnyMethodDecl!=null)
            buffer.append(AnyMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AnyMethodDeclaration]");
        return buffer.toString();
    }
}
