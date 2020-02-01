// generated with ast extension for cup
// version 0.8
// 1/1/2020 4:6:5


package rs.ac.bg.etf.pp1.ast;

public class GlobalMethodDeclarations extends GlobalMethodDeclList {

    private GlobalMethodDeclList GlobalMethodDeclList;
    private GlobalMethodDecl GlobalMethodDecl;

    public GlobalMethodDeclarations (GlobalMethodDeclList GlobalMethodDeclList, GlobalMethodDecl GlobalMethodDecl) {
        this.GlobalMethodDeclList=GlobalMethodDeclList;
        if(GlobalMethodDeclList!=null) GlobalMethodDeclList.setParent(this);
        this.GlobalMethodDecl=GlobalMethodDecl;
        if(GlobalMethodDecl!=null) GlobalMethodDecl.setParent(this);
    }

    public GlobalMethodDeclList getGlobalMethodDeclList() {
        return GlobalMethodDeclList;
    }

    public void setGlobalMethodDeclList(GlobalMethodDeclList GlobalMethodDeclList) {
        this.GlobalMethodDeclList=GlobalMethodDeclList;
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
        if(GlobalMethodDeclList!=null) GlobalMethodDeclList.accept(visitor);
        if(GlobalMethodDecl!=null) GlobalMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalMethodDeclList!=null) GlobalMethodDeclList.traverseTopDown(visitor);
        if(GlobalMethodDecl!=null) GlobalMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalMethodDeclList!=null) GlobalMethodDeclList.traverseBottomUp(visitor);
        if(GlobalMethodDecl!=null) GlobalMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalMethodDeclarations(\n");

        if(GlobalMethodDeclList!=null)
            buffer.append(GlobalMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalMethodDecl!=null)
            buffer.append(GlobalMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalMethodDeclarations]");
        return buffer.toString();
    }
}
