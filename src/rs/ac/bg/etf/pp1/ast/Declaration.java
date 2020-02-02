// generated with ast extension for cup
// version 0.8
// 2/1/2020 4:2:12


package rs.ac.bg.etf.pp1.ast;

public class Declaration extends DeclList {

    private DeclElem DeclElem;

    public Declaration (DeclElem DeclElem) {
        this.DeclElem=DeclElem;
        if(DeclElem!=null) DeclElem.setParent(this);
    }

    public DeclElem getDeclElem() {
        return DeclElem;
    }

    public void setDeclElem(DeclElem DeclElem) {
        this.DeclElem=DeclElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclElem!=null) DeclElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclElem!=null) DeclElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclElem!=null) DeclElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Declaration(\n");

        if(DeclElem!=null)
            buffer.append(DeclElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Declaration]");
        return buffer.toString();
    }
}
