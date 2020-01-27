// generated with ast extension for cup
// version 0.8
// 27/0/2020 1:29:9


package rs.ac.bg.etf.pp1.ast;

public class ObjectDesignatorSuffix extends DesignatorSuffix {

    private DesignatorSuffix DesignatorSuffix;
    private String ident;

    public ObjectDesignatorSuffix (DesignatorSuffix DesignatorSuffix, String ident) {
        this.DesignatorSuffix=DesignatorSuffix;
        if(DesignatorSuffix!=null) DesignatorSuffix.setParent(this);
        this.ident=ident;
    }

    public DesignatorSuffix getDesignatorSuffix() {
        return DesignatorSuffix;
    }

    public void setDesignatorSuffix(DesignatorSuffix DesignatorSuffix) {
        this.DesignatorSuffix=DesignatorSuffix;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident=ident;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorSuffix!=null) DesignatorSuffix.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorSuffix!=null) DesignatorSuffix.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorSuffix!=null) DesignatorSuffix.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ObjectDesignatorSuffix(\n");

        if(DesignatorSuffix!=null)
            buffer.append(DesignatorSuffix.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+ident);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ObjectDesignatorSuffix]");
        return buffer.toString();
    }
}
