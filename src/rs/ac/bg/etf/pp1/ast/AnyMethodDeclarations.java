// generated with ast extension for cup
// version 0.8
// 30/0/2020 2:20:37


package rs.ac.bg.etf.pp1.ast;

public class AnyMethodDeclarations extends AnyMethodDeclList {

    private AnyMethodDeclList AnyMethodDeclList;
    private AnyMethodDecl AnyMethodDecl;

    public AnyMethodDeclarations (AnyMethodDeclList AnyMethodDeclList, AnyMethodDecl AnyMethodDecl) {
        this.AnyMethodDeclList=AnyMethodDeclList;
        if(AnyMethodDeclList!=null) AnyMethodDeclList.setParent(this);
        this.AnyMethodDecl=AnyMethodDecl;
        if(AnyMethodDecl!=null) AnyMethodDecl.setParent(this);
    }

    public AnyMethodDeclList getAnyMethodDeclList() {
        return AnyMethodDeclList;
    }

    public void setAnyMethodDeclList(AnyMethodDeclList AnyMethodDeclList) {
        this.AnyMethodDeclList=AnyMethodDeclList;
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
        if(AnyMethodDeclList!=null) AnyMethodDeclList.accept(visitor);
        if(AnyMethodDecl!=null) AnyMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AnyMethodDeclList!=null) AnyMethodDeclList.traverseTopDown(visitor);
        if(AnyMethodDecl!=null) AnyMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AnyMethodDeclList!=null) AnyMethodDeclList.traverseBottomUp(visitor);
        if(AnyMethodDecl!=null) AnyMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AnyMethodDeclarations(\n");

        if(AnyMethodDeclList!=null)
            buffer.append(AnyMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AnyMethodDecl!=null)
            buffer.append(AnyMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AnyMethodDeclarations]");
        return buffer.toString();
    }
}
