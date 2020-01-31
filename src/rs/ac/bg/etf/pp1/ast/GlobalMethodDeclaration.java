// generated with ast extension for cup
// version 0.8
// 1/1/2020 0:9:9


package rs.ac.bg.etf.pp1.ast;

public class GlobalMethodDeclaration extends GlobalMethodDeclList {

    private GlobalMethodDecl GlobalMethodDecl;

    public GlobalMethodDeclaration (GlobalMethodDecl GlobalMethodDecl) {
        this.GlobalMethodDecl=GlobalMethodDecl;
        if(GlobalMethodDecl!=null) GlobalMethodDecl.setParent(this);
    }

    public GlobalMethodDecl getGlobalMethodDecl() {
        return GlobalMethodDecl;
    }

    public void setGlobalMethodDecl(GlobalMethodDecl GlobalMethodDecl) {
        this.GlobalMethodDecl=GlobalMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalMethodDecl!=null) GlobalMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalMethodDecl!=null) GlobalMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalMethodDecl!=null) GlobalMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalMethodDeclaration(\n");

        if(GlobalMethodDecl!=null)
            buffer.append(GlobalMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalMethodDeclaration]");
        return buffer.toString();
    }
}
